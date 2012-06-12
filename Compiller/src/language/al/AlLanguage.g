grammar AlLanguage;

options{
    output=template;
}

@header {
    package language.al;

    import java.util.Map;
    import java.util.HashMap;

    import java.io.FileReader;
    import java.io.FileWriter;
    import java.io.IOException;
    import java.io.FileNotFoundException;

    import language.namestable.NamesTable;
    import language.namestable.Procedure;
    import language.namestable.Var;
    import language.namestable.Type;
    import language.namestable.TypesChecker;
    import language.errors.Error;
    import language.errors.ErrorsTable;

    import org.antlr.stringtemplate.StringTemplateGroup;
    import org.antlr.stringtemplate.language.AngleBracketTemplateLexer;

}

@lexer::header {
    package language.al;
}

@members {
    private static String programName = "";

    private NamesTable globalNamesTable = new NamesTable();
    private NamesTable currentNamesTable = globalNamesTable;

    private String currentProcedureName;

    private int errorLine;
    private int variableNumber = 0;
    private int labelNumber = 0;

    public static StringTemplateGroup templateGroup;
    public static final String templateFileName = "template/ByteCode.stg";

    public static void main(String[] args) throws Exception {
        templateGroup = new StringTemplateGroup(new FileReader(templateFileName),
            AngleBracketTemplateLexer.class);

        if (args.length != 1) {
            System.out.println("Arguments error. Please input file name.");
            return;
        }
        String codeFile = args[0];
        if (codeFile.lastIndexOf(".") < 0) {
            System.out.println("Error in file name. Please input valid file name.");
            return;
        }
        programName = codeFile.substring(0, codeFile.lastIndexOf("."));

        try {
            AlLanguageLexer lexer = new AlLanguageLexer(new ANTLRFileStream(codeFile));
            AlLanguageParser parser = new AlLanguageParser(new CommonTokenStream(lexer));
            parser.setTemplateLib(templateGroup);
            RuleReturnScope returnScope =  parser.prog();

            if (!ErrorsTable.getInstance().getErrorsList().isEmpty()) {
                System.out.println("Next errors was found: ");
                ErrorsTable.getInstance().printErrors(System.out);
                System.out.println("Compilation failed!");
            } else {
                System.out.println("Compilation has been successful!");
                FileWriter out = new FileWriter(programName + ".txt.j");
                out.write(returnScope.getTemplate().toString());
                out.close();
            }
        } catch(FileNotFoundException ex) {
            System.out.println("File not found. Please input vailid file name.");
        }

    }

    public String getErrorHeader(RecognitionException e) {
        errorLine = e.line;
        return "";
    }

    public void emitErrorMessage(String message) {
        ErrorsTable.getInstance().addError(message, errorLine);
    }
}


prog
scope {
  List global_variables;
  List procedures;
}
@init {
  $prog::global_variables = new ArrayList();
  $prog::procedures = new ArrayList();
}

	: global_variables? ( procedure { $prog::procedures.add($procedure.st); } )* program EOF

            ->prog(global_variables={$prog::global_variables}, procedures={$prog::procedures}, program={$program.st}, programName={programName})
	;

program
@init {
    variableNumber = 1;
    labelNumber = 0;
}
	: 'program' IDENT block
            -> program(block={$block.stList})
	;

global_variables
	: 'global' '{' ( global_declaration {$prog::global_variables.add($global_declaration.st);} ';' )* '}'
	;

global_declaration
        : id=IDENT ':' t=type
        {
            if (currentNamesTable.isExistInThisBlock($id.text)) {
                    ErrorsTable.getInstance().addError(" name : " + "\"" + $id.text + "\"" + " repeat declaration.", $id.line);
            } else {
                Var var = new Var($id.text, $t.text, $id.line);
                var.setIsGlobal(true);
                currentNamesTable.addVar(var);
            }
        }

        ->global_declaration(ident={$id.text}, type={t.st})
	;

procedure
@init {
    variableNumber = 0;
    labelNumber = 0;
}
@after {
    variableNumber = 0;
    labelNumber = 0;
}
	: 'procedure' id=IDENT '(' args=arg_list ')' ':' t=type
        {
            if (!globalNamesTable.isProcedureDeclarated($id.text)) {
                Procedure procedure = new Procedure($id.text, $args.argsList, $t.text, $id.line);
                globalNamesTable.addProcedure(procedure);
                currentProcedureName = $id.text;

                NamesTable functionNamesTable = new NamesTable();
                functionNamesTable.setParentTable(currentNamesTable);
                currentNamesTable = functionNamesTable;

                for (Var var : $args.argsList) {
                    if (currentNamesTable.isExistInThisBlock(var.getIdent())) {
                        ErrorsTable.getInstance().addError(" name : " + "\"" +
                            var.getIdent() + "\"" + " repeat declaration.", $id.line);
                     } else {
                        currentNamesTable.addVar(var);
                        var.setVariableNumber(variableNumber);
                        variableNumber++;
                    }
                }

            } else {
                ErrorsTable.getInstance().addError(" procedure \"" + $id.text + "\" has already been declared", $id.line);
            }
        }
        block
        {
            currentNamesTable = currentNamesTable.getParentTable();
        }

        -> procedure(type={$t.st}, ident={$id.text}, args={$args.stList}, returnType={$t.returnType}, block={$block.stList})
	;

arg_list
returns [List<Var> argsList, List<StringTemplate> stList]
@init {
    $argsList = new ArrayList<Var>();
    $stList = new ArrayList<StringTemplate>();
}
	: ( id=IDENT ':'  t=type
        {
            $argsList.add(new Var($id.text, $t.text, $id.line));
            $stList.add(%parameter(type={t.st}, ident={$id.text}));
        }
          ( ',' id=IDENT ':' t=type
        {
            $argsList.add(new Var($id.text, $t.text, $id.line));
            $stList.add(%parameter(type={t.st}, ident={$id.text}));
        } )* )?
        ;

block
returns [List<StringTemplate> stList]
@init {
    NamesTable currentTable = new NamesTable();
    currentTable.setParentTable(currentNamesTable);
    currentNamesTable = currentTable;
    $stList = new ArrayList<StringTemplate>();
}
@after {
    currentNamesTable = currentTable.getParentTable();
}
	: '{' (stmt { $stList.add($stmt.st); })* '}'
	;

stmt
	: assign_stmt ';' -> { $assign_stmt.st }
	| declaration_stmt ';' -> { $declaration_stmt.st }
	| write_stmt ';' -> { $write_stmt.st }
	| read_stmt ';' -> { $read_stmt.st }
	| if_stmt -> { $if_stmt.st }
	| for_stmt -> { $for_stmt.st }
	| while_stmt -> { $while_stmt.st }
	| do_while_stmt ';' -> { $do_while_stmt.st }
	| return_stmt ';' -> { $return_stmt.st }
        | procedure_call_stmt ';' -> { $procedure_call_stmt.st }
	;

assign_stmt
	: id=IDENT s='=' expr=expression
        {
            if (!currentNamesTable.isExistInAll($id.text)) {
                ErrorsTable.getInstance().addError(" variable \"" + $id.text + "\" must be declared.", $id.line);
            } else {
                Var var = currentNamesTable.getVar($id.text);
                if (!TypesChecker.checkTypes(var.getType(), $expr.type)) {
                    ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage($s.text), $s.line);
                }
                if (TypesChecker.isFloat(var.getType())) {
                    if (var.isGlobal()) {
                        $st = %assign_field_float(expression={$expr.st}, programName={programName}, fieldName={var.getIdent()});
                    } else {
                        $st = %assign_var_float(expression={$expr.st}, variableNumber={var.getVariableNumber()});
                    }
                } else {
                    if (var.isGlobal()) {
                        $st = %assign_field_int(expression={$expr.st}, programName={programName}, fieldName={var.getIdent()});
                    } else {
                        $st = %assign_var_int(expression={$expr.st}, variableNumber={var.getVariableNumber()});
                    }
                }
            }
        }
	;

declaration_stmt
	: id=IDENT ':' t=type
        {
            if (currentNamesTable.isExistInThisBlock($id.text)) {
                ErrorsTable.getInstance().addError(" name : " + "\"" + $id.text + "\"" + " repeat declaration.", $id.line);
            } else {
                Var var = new Var($id.text, $t.text, $id.line);
                var.setVariableNumber(variableNumber);
                variableNumber++;
                currentNamesTable.addVar(var);

                if (TypesChecker.isFloat(var.getType())) {
                    $st = %declaration_float(variableNumber={var.getVariableNumber()});
                } else {
                    $st = %declaration_int(variableNumber={var.getVariableNumber()});
                }
            }
        }
	;

write_stmt
	: 'write' '(' expr=expression ')'
        {
            if (TypesChecker.isFloat($expr.type)) {
                $st = %write_float(expression={$expr.st});
            } else {
                $st = %write_int(expression={$expr.st});
            }
        }
        | 'write' '(' str=STRING ')' -> write_string(string={$str.text})
	;

read_stmt
	: 'read' '(' id=IDENT ')'
        {
            if (!currentNamesTable.isExistInAll($id.text)) {
                ErrorsTable.getInstance().addError(" variable \"" + $id.text + "\" must be declared.", $id.line);
            } else {
                Var var = currentNamesTable.getVar($id.text);

                if (TypesChecker.isFloat(var.getType())) {
                    if (var.isGlobal()) {
                        $st = %read_field_float(programName={programName}, fieldName={var.getIdent()});
                    } else {
                        $st = %read_var_float(variableNumber={var.getVariableNumber()});
                    }
                } else {
                    if (var.isGlobal()) {
                        $st = %read_field_int(programName={programName}, fieldName={var.getIdent()});
                    } else {
                        $st = %read_var_int(variableNumber={var.getVariableNumber()});
                    }
                }

                variableNumber++;
            }
        }
	;

if_stmt
	: s='if' '(' expr=expression ')' ifblock=block ( 'else' elseblock=block )?
        {
            if (!TypesChecker.checkTypes($expr.type, Type.BOOLEAN)) {
                ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage($s.text), $s.line);
            }

            $st = %if_operator(expression={$expr.st}, ifBlock={$ifblock.stList},
                elseBlock={$elseblock.stList}, firstLabel={labelNumber}, secondLabel={labelNumber + 1});

            labelNumber = labelNumber + 2;
        }
	;

for_stmt
	: s='for' '(' begin=assign_stmt ';' check=expression ';' end=assign_stmt ')' forBlock=block
        {
            if (!TypesChecker.isBoolean($check.type)) {
                ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage($s.text), $s.line);
            }

            $st = %for_operator(beginExpression={$begin.st}, checkExpression={$check.st}, endExpression={$end.st},
                forBlock={$forBlock.stList}, firstLabel={labelNumber}, secondLabel={labelNumber + 1}, thirdLabel={labelNumber + 2});

            labelNumber = labelNumber + 3;
        }
	;

while_stmt
	: s='while' '(' expr=expression ')' whileBlock=block
        {
            if (!TypesChecker.checkTypes($expr.type, Type.BOOLEAN)) {
                ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage($s.text), $s.line);
            }

            $st = %while_do(checkExpression={$expr.st}, whileBlock={$whileBlock.stList}, firstLabel={labelNumber},
                secondLabel={labelNumber + 1}, thirdLabel={labelNumber + 2});

            labelNumber = labelNumber + 3;
        }
	;

do_while_stmt
	: s='do' doBlock=block 'while' '(' expr=expression ')'
        {
            if (!TypesChecker.checkTypes($expr.type, Type.BOOLEAN)) {
                ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage($s.text), $s.line);
            }

            $st = %do_while(checkExpression={$expr.st}, doBlock={$doBlock.stList}, firstLabel={labelNumber});

            labelNumber++;
        }
	;

return_stmt
	: s='return' expr=expression
        {
            Procedure procedure = globalNamesTable.getProcedure(currentProcedureName);
            if (!TypesChecker.checkTypes($expr.type, procedure.getReturnType())) {
                ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage($s.text), $s.line);
            }
        }

        -> { $expr.st }
	;

procedure_call_stmt
        : procedure_call
        -> { $procedure_call.st }
        ;

procedure_call
returns [String procedureId]
@init {
    List<StringTemplate> argTypes = new ArrayList<StringTemplate>();
}
	: 'call' id=IDENT { $procedureId = $id.text; }'(' argsType=arg_call ')'
        {
            if (globalNamesTable.isProcedureDeclarated($id.text)) {
                Procedure procedure = globalNamesTable.getProcedure($id.text);
                if (procedure.getProcedureArgs().size() == $argsType.types.size()) {
                    int i = 0;
                    for (String type : $argsType.types) {
                        String procedureArgType = procedure.getProcedureArgs().get(i).getType();
                        if (!type.equals(procedureArgType)) {
                            ErrorsTable.getInstance().addError(" wrong type of parameter for procedure \"" + $id.text + "\".", $id.line);
                        }

                        if (TypesChecker.isFloat(type)) {
                            argTypes.add(%type_float());
                        } else {
                            argTypes.add(%type_int());
                        }

                        i++;
                    }
                } else {
                    ErrorsTable.getInstance().addError(" wrong number of arguments for procedure \"" + $id.text + "\".", $id.line);
                }

                StringTemplate returnType;
                if (TypesChecker.isFloat(procedure.getReturnType())) {
                    returnType = %type_float();
                } else if (TypesChecker.isBoolean(procedure.getReturnType())){
                    returnType = %type_boolean();
                } else {
                    returnType = %type_int();
                }

                $st = %procedure_call(programName={programName}, procedureName={$id.text}, argTemplates={$arg_call.stList}, argTypes={argTypes}, returnType={returnType});
            } else {
                ErrorsTable.getInstance().addError(" procedure \"" + $id.text + "\" must be declared.", $id.line);
            }
        }
	;

expression
returns [String type]
@init { String newType = ""; }
@after { $type = newType; }
	: first=and_expression { newType = $first.type; $st = $first.st; } ( op='|' second=expression
        {
            newType = TypesChecker.getLogicResultType($first.type, $second.type);
            if (newType.equals(Type.ERROR)) {
                ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage($op.text), $op.line);
            }

            $st = %logical_or(firstExpression={$first.st}, secondExpression={$second.st}, firstLabel={labelNumber},
                secondLabel={labelNumber + 1}, thirdLabel={labelNumber + 2});

            labelNumber = labelNumber + 3;
        } )?
	;

and_expression
returns [String type]
@init { String newType = ""; }
@after { $type = newType; }
	: first=not_expression { newType = $first.type; $st = $first.st; }( op='&' second=and_expression
        {
            newType = TypesChecker.getLogicResultType($first.type, $second.type);
            if (newType.equals(Type.ERROR)) {
                ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage($op.text), $op.line);
            }

            $st = %logical_and(firstExpression={$first.st}, secondExpression={$second.st}, firstLabel={labelNumber},
                secondLabel={labelNumber + 1}, thirdLabel={labelNumber + 2});

            labelNumber = labelNumber + 3;
        } )?
	;

not_expression
returns [String type]
@init { String newType = "";}
@after { $type = newType; }
	: op='!' first=not_expression
        {
            newType = TypesChecker.getLogicResultType($first.type, Type.BOOLEAN);
            if (newType.equals(Type.ERROR)) {
                ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage($op.text), $op.line);
            }

            $st = %logical_not(expression={$first.st}, firstLabel={labelNumber}, secondLabel={labelNumber + 1});

            labelNumber = labelNumber + 2;
        }
	| second=comparison { newType = $second.type; $st = $second.st; }
	;

comparison
returns [String type]
@init { String newType = ""; }
@after { $type = newType; }
	: first=math_expression { newType = $first.type; $st = $first.st; }
        ( (op='<' | op='>' | op='==' | op='!=') second=math_expression
        {
            newType = TypesChecker.getComparisonResultType($first.type, $second.type);
            if (newType.equals(Type.ERROR)) {
                ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage($op.text), $op.line);
            }

            if (TypesChecker.isInt($first.type)) {
                if ($op.text.equals("<")) {
                    $st = %comp_int_lt(firstExpression={$first.st}, secondExpression={$second.st}, firstLabel={labelNumber}, secondLabel={labelNumber + 1});
                    labelNumber = labelNumber + 2;
                } else if ($op.text.equals(">")) {
                    $st = %comp_int_gt(firstExpression={$first.st}, secondExpression={$second.st}, firstLabel={labelNumber}, secondLabel={labelNumber + 1});
                    labelNumber = labelNumber + 2;
                } else if ($op.text.equals("==")) {
                    $st = %comp_int_eq(firstExpression={$first.st}, secondExpression={$second.st}, firstLabel={labelNumber}, secondLabel={labelNumber + 1});
                    labelNumber = labelNumber + 2;
                } else if ($op.text.equals("!=")) {
                    $st = %comp_int_ne(firstExpression={$first.st}, secondExpression={$second.st}, firstLabel={labelNumber}, secondLabel={labelNumber + 1});
                    labelNumber = labelNumber + 2;
                }
            } else if (TypesChecker.isFloat($first.type)) {
                if ($op.text.equals("<")) {
                    $st = %comp_float_lt(firstExpression={$first.st}, secondExpression={$second.st}, firstLabel={labelNumber}, secondLabel={labelNumber + 1});
                    labelNumber = labelNumber + 2;
                } else if ($op.text.equals(">")) {
                    $st = %comp_float_gt(firstExpression={$first.st}, secondExpression={$second.st}, firstLabel={labelNumber}, secondLabel={labelNumber + 1});
                    labelNumber = labelNumber + 2;
                } else if ($op.text.equals("==")) {
                    $st = %comp_float_eq(firstExpression={$first.st}, secondExpression={$second.st}, firstLabel={labelNumber}, secondLabel={labelNumber + 1});
                    labelNumber = labelNumber + 2;
                } else if ($op.text.equals("!=")) {
                    $st = %comp_float_ne(firstExpression={$first.st}, secondExpression={$second.st}, firstLabel={labelNumber}, secondLabel={labelNumber + 1});
                    labelNumber = labelNumber + 2;
                }
            }
        } )?
	;

math_expression
returns [String type]
@init { String newType = ""; }
@after { $type = newType; }
	: first=mult { newType = $first.type; $st = $first.st; } ( (op='+' | op='-') second=math_expression
        {
            newType = TypesChecker.getSumResultType($first.type, $second.type);
            if (newType.equals(Type.ERROR)) {
                ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage($op.text), $op.line);
            }
            if ($op.text.equals("+")) {
                if (TypesChecker.isFloat($first.type)) {
                    $st = %add_float(firstValue={$first.st}, secondValue={$second.st});
                } else {
                    $st = %add_int(firstValue={$first.st}, secondValue={$second.st});
                }
            } else {
                if (TypesChecker.isFloat($first.type)) {
                    $st = %sub_float(firstValue={$first.st}, secondValue={$second.st});
                } else {
                    $st = %sub_int(firstValue={$first.st}, secondValue={$second.st});
                }
            }
        } )?
	;

mult
returns [String type]
@init { String newType = ""; }
@after { $type = newType; }
	: first=mod { newType = $first.type; $st = $first.st; }(( op='*' | op='/') second=mult
        {
            if ($op.text.equals("*")) {
                newType = TypesChecker.getMultResultType($first.type, $second.type);

                if (TypesChecker.isFloat($first.type)) {
                    $st = %mult_float(firstValue={first.st}, secondValue={second.st});
                } else {
                    $st = %mult_int(firstValue={first.st}, secondValue={second.st});
                }
            } else {
                newType = TypesChecker.getDivResultType($first.type, $second.type);

                if (TypesChecker.isFloat($first.type)) {
                    $st = %div_float(firstValue={first.st}, secondValue={second.st});
                } else {
                    $st = %div_int(firstValue={first.st}, secondValue={second.st});
                }
            }

            if (newType.equals(Type.ERROR)) {
                ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage($op.text), $op.line);
            }
        } )?
	;
mod
returns [String type]
@init { String newType = ""; }
@after { $type = newType; }
        : first=pow { newType = $first.type; $st = $first.st; }(op='%' second=pow
        {
            newType = TypesChecker.getModResultType($first.type, $second.type);
            if (newType.equals(Type.ERROR)) {
                ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage($op.text), $op.line);
            }

            if (TypesChecker.isFloat($first.type)) {
                $st = %mod_float(firstValue={$first.st}, secondValue={$second.st});
            } else {
                $st = %mod_int(firstValue={$first.st}, secondValue={$second.st});
            }
        } )?
        ;

pow
returns [String type]
@init { String newType = ""; }
@after { $type = newType; }
	: first=convert_type { newType = $first.type; $st = $first.st; } ( op='^' second=convert_type
        {
            newType = TypesChecker.getPowResultType($first.type, $second.type);
            if (newType.equals(Type.ERROR)) {
                ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage($op.text), $op.line);
            }

            if (TypesChecker.isFloat($first.type)) {
                $st = %pow_float(firstValue={$first.st}, secondValue={$second.st});
            } else {
                $st = %pow_int(firstValue={$first.st}, secondValue={$second.st});
            }
        } )?
	;

convert_type
returns [String type]
@init { String newType = ""; }
@after { $type = newType; }
        : convert='convertF2I' '(' atom ')'
        {
            if (TypesChecker.isFloat($atom.type)) {
                newType = Type.INT;
            } else {
                ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage($convert.text), $convert.line);
            }
        }
        -> convert_f2i(atom={$atom.st})
        | convert='convertI2F' '(' atom ')'
        {
            if (TypesChecker.isInt($atom.type)) {
                newType = Type.FLOAT;
            } else {
                ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage($convert.text), $convert.line);
            }
        }
        -> convert_i2f(atom={$atom.st})
        | atom { newType = $atom.type; }
        -> {$atom.st}
        ;
atom
returns [String type]
	: id=IDENT
        {
            boolean isExist = currentNamesTable.isExistInAll($id.text);
            if (isExist) {
                Var var = currentNamesTable.getVar($id.text);
                $type = var.getType();
                if (TypesChecker.isFloat(var.getType())) {
                    if (var.isGlobal()) {
                        $st = %referenceField_float(programName={programName}, fieldName={var.getIdent()});
                    } else {
                        $st = %referenceVariable_float(variableNumber={var.getVariableNumber()});
                    }
                } else {
                    if (var.isGlobal()) {
                        $st = %referenceField_int(programName={programName}, fieldName={var.getIdent()});
                    } else {
                        $st = %referenceVariable_int(variableNumber={var.getVariableNumber()});
                    }
                }
            } else {
                ErrorsTable.getInstance().addError(" variable \"" + $id.text + "\" must be declared.", $id.line);
            }
        }
	| INT { $type = Type.INT; } -> const_int(value = {$INT.text})
	| FLOAT { $type = Type.FLOAT; } -> const_float(value = {$FLOAT.text})
	| '(' expr=expression ')' { $type = $expr.type; } -> {$expr.st}
	| boolean_literal { $type = Type.BOOLEAN; } -> const_int(value = {$boolean_literal.st})
	| p=procedure_call
        {
            if (globalNamesTable.isProcedureDeclarated($p.procedureId)) {
                Procedure procedure = globalNamesTable.getProcedure($p.procedureId);
                $type = procedure.getReturnType();
            }
        } -> { $p.st }
	;

type
returns [StringTemplate returnType]
	: 'int' { $returnType = %return_int(); } -> type_int()
	| 'float' { $returnType = %return_float(); } -> type_float()
	| 'boolean' { $returnType = %return_int(); } -> type_boolean()
	;

boolean_literal
	: 'true' -> { new StringTemplate("1") }
	| 'false' -> { new StringTemplate("0") }
	;

arg_call
returns [List<String> types, List<StringTemplate> stTypes, List<StringTemplate> stList]
@init {
    $types = new ArrayList<String>();
    $stList = new ArrayList<StringTemplate>();
}
	: ( first=expression
        {
            if ($first.type != null)
            {
                $types.add($first.type);
                $stList.add($first.st);
            }
        }
          ( ',' second=expression
        {
            if ($second.type != null) {
                $types.add($second.type);
                $stList.add($second.st);
            }
        })* )?
	;


IDENT
	: ( LETTER | '_' )( LETTER | '_' | DIGIT )*
	;

INT
	: ('-')? ( '1'..'9' ) ( DIGIT )*
	| '0'
	;

FLOAT
    : ('-')? FLOAT_G
    ;

fragment
FLOAT_G
	: DIGIT+ '.' EXPONENT
	| DIGIT+ ( '.' ( DIGIT + ( EXPONENT ) ? ) ? | EXPONENT )
	;

fragment
EXPONENT
	: ( 'e' | 'E' ) ( '+' | '-' )? DIGIT+
    	;

fragment
LETTER
	:'A'..'Z' | 'a'..'z'
	;

fragment
DIGIT
	: '0'..'9'
	;

COMMENT
    :   '//' ~('\n'|'\r')* '\r'? '\n' {$channel=HIDDEN;}
    ;

WS
 	: ('\t' | '\r'? '\n' | ' ')+ { $channel = HIDDEN; }
 	;


STRING
    :  '"' ( ESC_SEQ | ~('\\'|'"') )* '"'
    ;

fragment
HEX_DIGIT : ('0'..'9'|'a'..'f'|'A'..'F') ;

fragment
ESC_SEQ
    :   '\\' ('b'|'t'|'n'|'f'|'r'|'\"'|'\''|'\\')
    |   UNICODE_ESC
    |   OCTAL_ESC
    ;

fragment
OCTAL_ESC
    :   '\\' ('0'..'3') ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7') ('0'..'7')
    |   '\\' ('0'..'7')
    ;

fragment
UNICODE_ESC
    :   '\\' 'u' HEX_DIGIT HEX_DIGIT HEX_DIGIT HEX_DIGIT
    ;