// $ANTLR 3.3 Nov 30, 2010 12:50:56 G:\\Compiller\\src\\language\\al\\AlLanguage.g 2012-05-27 13:15:43

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



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

import org.antlr.stringtemplate.*;
import org.antlr.stringtemplate.language.*;
import java.util.HashMap;
public class AlLanguageParser extends Parser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "IDENT", "STRING", "INT", "FLOAT", "LETTER", "DIGIT", "FLOAT_G", "EXPONENT", "COMMENT", "WS", "ESC_SEQ", "HEX_DIGIT", "UNICODE_ESC", "OCTAL_ESC", "'program'", "'global'", "'{'", "';'", "'}'", "':'", "'procedure'", "'('", "')'", "','", "'='", "'write'", "'read'", "'if'", "'else'", "'for'", "'while'", "'do'", "'return'", "'call'", "'|'", "'&'", "'!'", "'<'", "'>'", "'=='", "'!='", "'+'", "'-'", "'*'", "'/'", "'%'", "'^'", "'convertF2I'", "'convertI2F'", "'int'", "'float'", "'boolean'", "'true'", "'false'"
    };
    public static final int EOF=-1;
    public static final int T__18=18;
    public static final int T__19=19;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int T__22=22;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int T__29=29;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__50=50;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__57=57;
    public static final int IDENT=4;
    public static final int STRING=5;
    public static final int INT=6;
    public static final int FLOAT=7;
    public static final int LETTER=8;
    public static final int DIGIT=9;
    public static final int FLOAT_G=10;
    public static final int EXPONENT=11;
    public static final int COMMENT=12;
    public static final int WS=13;
    public static final int ESC_SEQ=14;
    public static final int HEX_DIGIT=15;
    public static final int UNICODE_ESC=16;
    public static final int OCTAL_ESC=17;

    // delegates
    // delegators


        public AlLanguageParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public AlLanguageParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        
    protected StringTemplateGroup templateLib =
      new StringTemplateGroup("AlLanguageParserTemplates", AngleBracketTemplateLexer.class);

    public void setTemplateLib(StringTemplateGroup templateLib) {
      this.templateLib = templateLib;
    }
    public StringTemplateGroup getTemplateLib() {
      return templateLib;
    }
    /** allows convenient multi-value initialization:
     *  "new STAttrMap().put(...).put(...)"
     */
    public static class STAttrMap extends HashMap {
      public STAttrMap put(String attrName, Object value) {
        super.put(attrName, value);
        return this;
      }
      public STAttrMap put(String attrName, int value) {
        super.put(attrName, new Integer(value));
        return this;
      }
    }

    public String[] getTokenNames() { return AlLanguageParser.tokenNames; }
    public String getGrammarFileName() { return "G:\\Compiller\\src\\language\\al\\AlLanguage.g"; }


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


    protected static class prog_scope {
        List global_variables;
        List procedures;
    }
    protected Stack prog_stack = new Stack();

    public static class prog_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "prog"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:98:1: prog : ( global_variables )? ( procedure )* program EOF -> prog(global_variables=$prog::global_variablesprocedures=$prog::proceduresprogram=$program.stprogramName=programName);
    public final AlLanguageParser.prog_return prog() throws RecognitionException {
        prog_stack.push(new prog_scope());
        AlLanguageParser.prog_return retval = new AlLanguageParser.prog_return();
        retval.start = input.LT(1);

        AlLanguageParser.procedure_return procedure1 = null;

        AlLanguageParser.program_return program2 = null;



          ((prog_scope)prog_stack.peek()).global_variables = new ArrayList();
          ((prog_scope)prog_stack.peek()).procedures = new ArrayList();

        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:108:2: ( ( global_variables )? ( procedure )* program EOF -> prog(global_variables=$prog::global_variablesprocedures=$prog::proceduresprogram=$program.stprogramName=programName))
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:108:4: ( global_variables )? ( procedure )* program EOF
            {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:108:4: ( global_variables )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==19) ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:108:4: global_variables
                    {
                    pushFollow(FOLLOW_global_variables_in_prog57);
                    global_variables();

                    state._fsp--;


                    }
                    break;

            }

            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:108:22: ( procedure )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==24) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:108:24: procedure
            	    {
            	    pushFollow(FOLLOW_procedure_in_prog62);
            	    procedure1=procedure();

            	    state._fsp--;

            	     ((prog_scope)prog_stack.peek()).procedures.add((procedure1!=null?procedure1.st:null)); 

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            pushFollow(FOLLOW_program_in_prog69);
            program2=program();

            state._fsp--;

            match(input,EOF,FOLLOW_EOF_in_prog71); 


            // TEMPLATE REWRITE
            // 110:13: -> prog(global_variables=$prog::global_variablesprocedures=$prog::proceduresprogram=$program.stprogramName=programName)
            {
                retval.st = templateLib.getInstanceOf("prog",
              new STAttrMap().put("global_variables", ((prog_scope)prog_stack.peek()).global_variables).put("procedures", ((prog_scope)prog_stack.peek()).procedures).put("program", (program2!=null?program2.st:null)).put("programName", programName));
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
            prog_stack.pop();
        }
        return retval;
    }
    // $ANTLR end "prog"

    public static class program_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "program"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:113:1: program : 'program' IDENT block -> program(block=$block.stList);
    public final AlLanguageParser.program_return program() throws RecognitionException {
        AlLanguageParser.program_return retval = new AlLanguageParser.program_return();
        retval.start = input.LT(1);

        AlLanguageParser.block_return block3 = null;



            variableNumber = 1;
            labelNumber = 0;

        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:118:2: ( 'program' IDENT block -> program(block=$block.stList))
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:118:4: 'program' IDENT block
            {
            match(input,18,FOLLOW_18_in_program123); 
            match(input,IDENT,FOLLOW_IDENT_in_program125); 
            pushFollow(FOLLOW_block_in_program127);
            block3=block();

            state._fsp--;



            // TEMPLATE REWRITE
            // 119:13: -> program(block=$block.stList)
            {
                retval.st = templateLib.getInstanceOf("program",
              new STAttrMap().put("block", (block3!=null?block3.stList:null)));
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "program"

    public static class global_variables_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "global_variables"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:122:1: global_variables : 'global' '{' ( global_declaration ';' )* '}' ;
    public final AlLanguageParser.global_variables_return global_variables() throws RecognitionException {
        AlLanguageParser.global_variables_return retval = new AlLanguageParser.global_variables_return();
        retval.start = input.LT(1);

        AlLanguageParser.global_declaration_return global_declaration4 = null;


        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:123:2: ( 'global' '{' ( global_declaration ';' )* '}' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:123:4: 'global' '{' ( global_declaration ';' )* '}'
            {
            match(input,19,FOLLOW_19_in_global_variables159); 
            match(input,20,FOLLOW_20_in_global_variables161); 
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:123:17: ( global_declaration ';' )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==IDENT) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:123:19: global_declaration ';'
            	    {
            	    pushFollow(FOLLOW_global_declaration_in_global_variables165);
            	    global_declaration4=global_declaration();

            	    state._fsp--;

            	    ((prog_scope)prog_stack.peek()).global_variables.add((global_declaration4!=null?global_declaration4.st:null));
            	    match(input,21,FOLLOW_21_in_global_variables169); 

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            match(input,22,FOLLOW_22_in_global_variables174); 

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "global_variables"

    public static class global_declaration_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "global_declaration"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:126:1: global_declaration : id= IDENT ':' t= type -> global_declaration(ident=$id.texttype=t.st);
    public final AlLanguageParser.global_declaration_return global_declaration() throws RecognitionException {
        AlLanguageParser.global_declaration_return retval = new AlLanguageParser.global_declaration_return();
        retval.start = input.LT(1);

        Token id=null;
        AlLanguageParser.type_return t = null;


        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:127:9: (id= IDENT ':' t= type -> global_declaration(ident=$id.texttype=t.st))
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:127:11: id= IDENT ':' t= type
            {
            id=(Token)match(input,IDENT,FOLLOW_IDENT_in_global_declaration194); 
            match(input,23,FOLLOW_23_in_global_declaration196); 
            pushFollow(FOLLOW_type_in_global_declaration200);
            t=type();

            state._fsp--;


                        if (currentNamesTable.isExistInThisBlock((id!=null?id.getText():null))) {
                                ErrorsTable.getInstance().addError(" name : " + "\"" + (id!=null?id.getText():null) + "\"" + " repeat declaration.", (id!=null?id.getLine():0));
                        } else {
                            Var var = new Var((id!=null?id.getText():null), (t!=null?input.toString(t.start,t.stop):null), (id!=null?id.getLine():0));
                            var.setIsGlobal(true);
                            currentNamesTable.addVar(var);
                        }
                    


            // TEMPLATE REWRITE
            // 138:9: -> global_declaration(ident=$id.texttype=t.st)
            {
                retval.st = templateLib.getInstanceOf("global_declaration",
              new STAttrMap().put("ident", (id!=null?id.getText():null)).put("type", t.st));
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "global_declaration"

    public static class procedure_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "procedure"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:141:1: procedure : 'procedure' id= IDENT '(' args= arg_list ')' ':' t= type block -> procedure(type=$t.stident=$id.textargs=$args.stListreturnType=$t.returnTypeblock=$block.stList);
    public final AlLanguageParser.procedure_return procedure() throws RecognitionException {
        AlLanguageParser.procedure_return retval = new AlLanguageParser.procedure_return();
        retval.start = input.LT(1);

        Token id=null;
        AlLanguageParser.arg_list_return args = null;

        AlLanguageParser.type_return t = null;

        AlLanguageParser.block_return block5 = null;



            variableNumber = 0;
            labelNumber = 0;

        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:150:2: ( 'procedure' id= IDENT '(' args= arg_list ')' ':' t= type block -> procedure(type=$t.stident=$id.textargs=$args.stListreturnType=$t.returnTypeblock=$block.stList))
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:150:4: 'procedure' id= IDENT '(' args= arg_list ')' ':' t= type block
            {
            match(input,24,FOLLOW_24_in_procedure253); 
            id=(Token)match(input,IDENT,FOLLOW_IDENT_in_procedure257); 
            match(input,25,FOLLOW_25_in_procedure259); 
            pushFollow(FOLLOW_arg_list_in_procedure263);
            args=arg_list();

            state._fsp--;

            match(input,26,FOLLOW_26_in_procedure265); 
            match(input,23,FOLLOW_23_in_procedure267); 
            pushFollow(FOLLOW_type_in_procedure271);
            t=type();

            state._fsp--;


                        if (!globalNamesTable.isProcedureDeclarated((id!=null?id.getText():null))) {
                            Procedure procedure = new Procedure((id!=null?id.getText():null), (args!=null?args.argsList:null), (t!=null?input.toString(t.start,t.stop):null), (id!=null?id.getLine():0));
                            globalNamesTable.addProcedure(procedure);
                            currentProcedureName = (id!=null?id.getText():null);

                            NamesTable functionNamesTable = new NamesTable();
                            functionNamesTable.setParentTable(currentNamesTable);
                            currentNamesTable = functionNamesTable;

                            for (Var var : (args!=null?args.argsList:null)) {
                                if (currentNamesTable.isExistInThisBlock(var.getIdent())) {
                                    ErrorsTable.getInstance().addError(" name : " + "\"" +
                                        var.getIdent() + "\"" + " repeat declaration.", (id!=null?id.getLine():0));
                                 } else {
                                    currentNamesTable.addVar(var);
                                    var.setVariableNumber(variableNumber);
                                    variableNumber++;
                                }
                            }

                        } else {
                            ErrorsTable.getInstance().addError(" procedure \"" + (id!=null?id.getText():null) + "\" has already been declared", (id!=null?id.getLine():0));
                        }
                    
            pushFollow(FOLLOW_block_in_procedure291);
            block5=block();

            state._fsp--;


                        currentNamesTable = currentNamesTable.getParentTable();
                    


            // TEMPLATE REWRITE
            // 181:9: -> procedure(type=$t.stident=$id.textargs=$args.stListreturnType=$t.returnTypeblock=$block.stList)
            {
                retval.st = templateLib.getInstanceOf("procedure",
              new STAttrMap().put("type", (t!=null?t.st:null)).put("ident", (id!=null?id.getText():null)).put("args", (args!=null?args.stList:null)).put("returnType", (t!=null?t.returnType:null)).put("block", (block5!=null?block5.stList:null)));
            }


            }

            retval.stop = input.LT(-1);


                variableNumber = 0;
                labelNumber = 0;

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "procedure"

    public static class arg_list_return extends ParserRuleReturnScope {
        public List<Var> argsList;
        public List<StringTemplate> stList;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "arg_list"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:184:1: arg_list returns [List<Var> argsList, List<StringTemplate> stList] : (id= IDENT ':' t= type ( ',' id= IDENT ':' t= type )* )? ;
    public final AlLanguageParser.arg_list_return arg_list() throws RecognitionException {
        AlLanguageParser.arg_list_return retval = new AlLanguageParser.arg_list_return();
        retval.start = input.LT(1);

        Token id=null;
        AlLanguageParser.type_return t = null;



            retval.argsList = new ArrayList<Var>();
            retval.stList = new ArrayList<StringTemplate>();

        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:190:2: ( (id= IDENT ':' t= type ( ',' id= IDENT ':' t= type )* )? )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:190:4: (id= IDENT ':' t= type ( ',' id= IDENT ':' t= type )* )?
            {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:190:4: (id= IDENT ':' t= type ( ',' id= IDENT ':' t= type )* )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==IDENT) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:190:6: id= IDENT ':' t= type ( ',' id= IDENT ':' t= type )*
                    {
                    id=(Token)match(input,IDENT,FOLLOW_IDENT_in_arg_list363); 
                    match(input,23,FOLLOW_23_in_arg_list365); 
                    pushFollow(FOLLOW_type_in_arg_list370);
                    t=type();

                    state._fsp--;


                                retval.argsList.add(new Var((id!=null?id.getText():null), (t!=null?input.toString(t.start,t.stop):null), (id!=null?id.getLine():0)));
                                retval.stList.add(templateLib.getInstanceOf("parameter",
                      new STAttrMap().put("type", t.st).put("ident", (id!=null?id.getText():null))));
                            
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:195:11: ( ',' id= IDENT ':' t= type )*
                    loop4:
                    do {
                        int alt4=2;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0==27) ) {
                            alt4=1;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:195:13: ',' id= IDENT ':' t= type
                    	    {
                    	    match(input,27,FOLLOW_27_in_arg_list394); 
                    	    id=(Token)match(input,IDENT,FOLLOW_IDENT_in_arg_list398); 
                    	    match(input,23,FOLLOW_23_in_arg_list400); 
                    	    pushFollow(FOLLOW_type_in_arg_list404);
                    	    t=type();

                    	    state._fsp--;


                    	                retval.argsList.add(new Var((id!=null?id.getText():null), (t!=null?input.toString(t.start,t.stop):null), (id!=null?id.getLine():0)));
                    	                retval.stList.add(templateLib.getInstanceOf("parameter",
                    	      new STAttrMap().put("type", t.st).put("ident", (id!=null?id.getText():null))));
                    	            

                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arg_list"

    public static class block_return extends ParserRuleReturnScope {
        public List<StringTemplate> stList;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "block"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:202:1: block returns [List<StringTemplate> stList] : '{' ( stmt )* '}' ;
    public final AlLanguageParser.block_return block() throws RecognitionException {
        AlLanguageParser.block_return retval = new AlLanguageParser.block_return();
        retval.start = input.LT(1);

        AlLanguageParser.stmt_return stmt6 = null;



            NamesTable currentTable = new NamesTable();
            currentTable.setParentTable(currentNamesTable);
            currentNamesTable = currentTable;
            retval.stList = new ArrayList<StringTemplate>();

        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:213:2: ( '{' ( stmt )* '}' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:213:4: '{' ( stmt )* '}'
            {
            match(input,20,FOLLOW_20_in_block452); 
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:213:8: ( stmt )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==IDENT||(LA6_0>=29 && LA6_0<=31)||(LA6_0>=33 && LA6_0<=37)) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:213:9: stmt
            	    {
            	    pushFollow(FOLLOW_stmt_in_block455);
            	    stmt6=stmt();

            	    state._fsp--;

            	     retval.stList.add((stmt6!=null?stmt6.st:null)); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match(input,22,FOLLOW_22_in_block461); 

            }

            retval.stop = input.LT(-1);


                currentNamesTable = currentTable.getParentTable();

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "block"

    public static class stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "stmt"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:216:1: stmt : ( assign_stmt ';' -> { $assign_stmt.st } | declaration_stmt ';' -> { $declaration_stmt.st } | write_stmt ';' -> { $write_stmt.st } | read_stmt ';' -> { $read_stmt.st } | if_stmt -> { $if_stmt.st } | for_stmt -> { $for_stmt.st } | while_stmt -> { $while_stmt.st } | do_while_stmt ';' -> { $do_while_stmt.st } | return_stmt ';' -> { $return_stmt.st } | procedure_call_stmt ';' -> { $procedure_call_stmt.st });
    public final AlLanguageParser.stmt_return stmt() throws RecognitionException {
        AlLanguageParser.stmt_return retval = new AlLanguageParser.stmt_return();
        retval.start = input.LT(1);

        AlLanguageParser.assign_stmt_return assign_stmt7 = null;

        AlLanguageParser.declaration_stmt_return declaration_stmt8 = null;

        AlLanguageParser.write_stmt_return write_stmt9 = null;

        AlLanguageParser.read_stmt_return read_stmt10 = null;

        AlLanguageParser.if_stmt_return if_stmt11 = null;

        AlLanguageParser.for_stmt_return for_stmt12 = null;

        AlLanguageParser.while_stmt_return while_stmt13 = null;

        AlLanguageParser.do_while_stmt_return do_while_stmt14 = null;

        AlLanguageParser.return_stmt_return return_stmt15 = null;

        AlLanguageParser.procedure_call_stmt_return procedure_call_stmt16 = null;


        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:217:2: ( assign_stmt ';' -> { $assign_stmt.st } | declaration_stmt ';' -> { $declaration_stmt.st } | write_stmt ';' -> { $write_stmt.st } | read_stmt ';' -> { $read_stmt.st } | if_stmt -> { $if_stmt.st } | for_stmt -> { $for_stmt.st } | while_stmt -> { $while_stmt.st } | do_while_stmt ';' -> { $do_while_stmt.st } | return_stmt ';' -> { $return_stmt.st } | procedure_call_stmt ';' -> { $procedure_call_stmt.st })
            int alt7=10;
            alt7 = dfa7.predict(input);
            switch (alt7) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:217:4: assign_stmt ';'
                    {
                    pushFollow(FOLLOW_assign_stmt_in_stmt472);
                    assign_stmt7=assign_stmt();

                    state._fsp--;

                    match(input,21,FOLLOW_21_in_stmt474); 


                    // TEMPLATE REWRITE
                    // 217:20: -> { $assign_stmt.st }
                    {
                        retval.st =  (assign_stmt7!=null?assign_stmt7.st:null) ;
                    }


                    }
                    break;
                case 2 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:218:4: declaration_stmt ';'
                    {
                    pushFollow(FOLLOW_declaration_stmt_in_stmt483);
                    declaration_stmt8=declaration_stmt();

                    state._fsp--;

                    match(input,21,FOLLOW_21_in_stmt485); 


                    // TEMPLATE REWRITE
                    // 218:25: -> { $declaration_stmt.st }
                    {
                        retval.st =  (declaration_stmt8!=null?declaration_stmt8.st:null) ;
                    }


                    }
                    break;
                case 3 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:219:4: write_stmt ';'
                    {
                    pushFollow(FOLLOW_write_stmt_in_stmt494);
                    write_stmt9=write_stmt();

                    state._fsp--;

                    match(input,21,FOLLOW_21_in_stmt496); 


                    // TEMPLATE REWRITE
                    // 219:19: -> { $write_stmt.st }
                    {
                        retval.st =  (write_stmt9!=null?write_stmt9.st:null) ;
                    }


                    }
                    break;
                case 4 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:220:4: read_stmt ';'
                    {
                    pushFollow(FOLLOW_read_stmt_in_stmt505);
                    read_stmt10=read_stmt();

                    state._fsp--;

                    match(input,21,FOLLOW_21_in_stmt507); 


                    // TEMPLATE REWRITE
                    // 220:18: -> { $read_stmt.st }
                    {
                        retval.st =  (read_stmt10!=null?read_stmt10.st:null) ;
                    }


                    }
                    break;
                case 5 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:221:4: if_stmt
                    {
                    pushFollow(FOLLOW_if_stmt_in_stmt516);
                    if_stmt11=if_stmt();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 221:12: -> { $if_stmt.st }
                    {
                        retval.st =  (if_stmt11!=null?if_stmt11.st:null) ;
                    }


                    }
                    break;
                case 6 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:222:4: for_stmt
                    {
                    pushFollow(FOLLOW_for_stmt_in_stmt525);
                    for_stmt12=for_stmt();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 222:13: -> { $for_stmt.st }
                    {
                        retval.st =  (for_stmt12!=null?for_stmt12.st:null) ;
                    }


                    }
                    break;
                case 7 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:223:4: while_stmt
                    {
                    pushFollow(FOLLOW_while_stmt_in_stmt534);
                    while_stmt13=while_stmt();

                    state._fsp--;



                    // TEMPLATE REWRITE
                    // 223:15: -> { $while_stmt.st }
                    {
                        retval.st =  (while_stmt13!=null?while_stmt13.st:null) ;
                    }


                    }
                    break;
                case 8 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:224:4: do_while_stmt ';'
                    {
                    pushFollow(FOLLOW_do_while_stmt_in_stmt543);
                    do_while_stmt14=do_while_stmt();

                    state._fsp--;

                    match(input,21,FOLLOW_21_in_stmt545); 


                    // TEMPLATE REWRITE
                    // 224:22: -> { $do_while_stmt.st }
                    {
                        retval.st =  (do_while_stmt14!=null?do_while_stmt14.st:null) ;
                    }


                    }
                    break;
                case 9 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:225:4: return_stmt ';'
                    {
                    pushFollow(FOLLOW_return_stmt_in_stmt554);
                    return_stmt15=return_stmt();

                    state._fsp--;

                    match(input,21,FOLLOW_21_in_stmt556); 


                    // TEMPLATE REWRITE
                    // 225:20: -> { $return_stmt.st }
                    {
                        retval.st =  (return_stmt15!=null?return_stmt15.st:null) ;
                    }


                    }
                    break;
                case 10 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:226:11: procedure_call_stmt ';'
                    {
                    pushFollow(FOLLOW_procedure_call_stmt_in_stmt572);
                    procedure_call_stmt16=procedure_call_stmt();

                    state._fsp--;

                    match(input,21,FOLLOW_21_in_stmt574); 


                    // TEMPLATE REWRITE
                    // 226:35: -> { $procedure_call_stmt.st }
                    {
                        retval.st =  (procedure_call_stmt16!=null?procedure_call_stmt16.st:null) ;
                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "stmt"

    public static class assign_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "assign_stmt"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:229:1: assign_stmt : id= IDENT s= '=' expr= expression ;
    public final AlLanguageParser.assign_stmt_return assign_stmt() throws RecognitionException {
        AlLanguageParser.assign_stmt_return retval = new AlLanguageParser.assign_stmt_return();
        retval.start = input.LT(1);

        Token id=null;
        Token s=null;
        AlLanguageParser.expression_return expr = null;


        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:230:2: (id= IDENT s= '=' expr= expression )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:230:4: id= IDENT s= '=' expr= expression
            {
            id=(Token)match(input,IDENT,FOLLOW_IDENT_in_assign_stmt591); 
            s=(Token)match(input,28,FOLLOW_28_in_assign_stmt595); 
            pushFollow(FOLLOW_expression_in_assign_stmt599);
            expr=expression();

            state._fsp--;


                        if (!currentNamesTable.isExistInAll((id!=null?id.getText():null))) {
                            ErrorsTable.getInstance().addError(" variable \"" + (id!=null?id.getText():null) + "\" must be declared.", (id!=null?id.getLine():0));
                        } else {
                            Var var = currentNamesTable.getVar((id!=null?id.getText():null));
                            if (!TypesChecker.checkTypes(var.getType(), (expr!=null?expr.type:null))) {
                                ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage((s!=null?s.getText():null)), (s!=null?s.getLine():0));
                            }
                            if (TypesChecker.isFloat(var.getType())) {
                                if (var.isGlobal()) {
                                    retval.st = templateLib.getInstanceOf("assign_field_float",
              new STAttrMap().put("expression", (expr!=null?expr.st:null)).put("programName", programName).put("fieldName", var.getIdent()));
                                } else {
                                    retval.st = templateLib.getInstanceOf("assign_var_float",
              new STAttrMap().put("expression", (expr!=null?expr.st:null)).put("variableNumber", var.getVariableNumber()));
                                }
                            } else {
                                if (var.isGlobal()) {
                                    retval.st = templateLib.getInstanceOf("assign_field_int",
              new STAttrMap().put("expression", (expr!=null?expr.st:null)).put("programName", programName).put("fieldName", var.getIdent()));
                                } else {
                                    retval.st = templateLib.getInstanceOf("assign_var_int",
              new STAttrMap().put("expression", (expr!=null?expr.st:null)).put("variableNumber", var.getVariableNumber()));
                                }
                            }
                        }
                    

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "assign_stmt"

    public static class declaration_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "declaration_stmt"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:256:1: declaration_stmt : id= IDENT ':' t= type ;
    public final AlLanguageParser.declaration_stmt_return declaration_stmt() throws RecognitionException {
        AlLanguageParser.declaration_stmt_return retval = new AlLanguageParser.declaration_stmt_return();
        retval.start = input.LT(1);

        Token id=null;
        AlLanguageParser.type_return t = null;


        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:257:2: (id= IDENT ':' t= type )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:257:4: id= IDENT ':' t= type
            {
            id=(Token)match(input,IDENT,FOLLOW_IDENT_in_declaration_stmt622); 
            match(input,23,FOLLOW_23_in_declaration_stmt624); 
            pushFollow(FOLLOW_type_in_declaration_stmt628);
            t=type();

            state._fsp--;


                        if (currentNamesTable.isExistInThisBlock((id!=null?id.getText():null))) {
                            ErrorsTable.getInstance().addError(" name : " + "\"" + (id!=null?id.getText():null) + "\"" + " repeat declaration.", (id!=null?id.getLine():0));
                        } else {
                            Var var = new Var((id!=null?id.getText():null), (t!=null?input.toString(t.start,t.stop):null), (id!=null?id.getLine():0));
                            var.setVariableNumber(variableNumber);
                            variableNumber++;
                            currentNamesTable.addVar(var);

                            if (TypesChecker.isFloat(var.getType())) {
                                retval.st = templateLib.getInstanceOf("declaration_float",
              new STAttrMap().put("variableNumber", var.getVariableNumber()));
                            } else {
                                retval.st = templateLib.getInstanceOf("declaration_int",
              new STAttrMap().put("variableNumber", var.getVariableNumber()));
                            }
                        }
                    

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "declaration_stmt"

    public static class write_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "write_stmt"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:276:1: write_stmt : ( 'write' '(' expr= expression ')' | 'write' '(' str= STRING ')' -> write_string(string=$str.text));
    public final AlLanguageParser.write_stmt_return write_stmt() throws RecognitionException {
        AlLanguageParser.write_stmt_return retval = new AlLanguageParser.write_stmt_return();
        retval.start = input.LT(1);

        Token str=null;
        AlLanguageParser.expression_return expr = null;


        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:277:2: ( 'write' '(' expr= expression ')' | 'write' '(' str= STRING ')' -> write_string(string=$str.text))
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==29) ) {
                int LA8_1 = input.LA(2);

                if ( (LA8_1==25) ) {
                    int LA8_2 = input.LA(3);

                    if ( (LA8_2==STRING) ) {
                        alt8=2;
                    }
                    else if ( (LA8_2==IDENT||(LA8_2>=INT && LA8_2<=FLOAT)||LA8_2==25||LA8_2==37||LA8_2==40||(LA8_2>=51 && LA8_2<=52)||(LA8_2>=56 && LA8_2<=57)) ) {
                        alt8=1;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 8, 2, input);

                        throw nvae;
                    }
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 8, 1, input);

                    throw nvae;
                }
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:277:4: 'write' '(' expr= expression ')'
                    {
                    match(input,29,FOLLOW_29_in_write_stmt649); 
                    match(input,25,FOLLOW_25_in_write_stmt651); 
                    pushFollow(FOLLOW_expression_in_write_stmt655);
                    expr=expression();

                    state._fsp--;

                    match(input,26,FOLLOW_26_in_write_stmt657); 

                                if (TypesChecker.isFloat((expr!=null?expr.type:null))) {
                                    retval.st = templateLib.getInstanceOf("write_float",
                      new STAttrMap().put("expression", (expr!=null?expr.st:null)));
                                } else {
                                    retval.st = templateLib.getInstanceOf("write_int",
                      new STAttrMap().put("expression", (expr!=null?expr.st:null)));
                                }
                            

                    }
                    break;
                case 2 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:285:11: 'write' '(' str= STRING ')'
                    {
                    match(input,29,FOLLOW_29_in_write_stmt679); 
                    match(input,25,FOLLOW_25_in_write_stmt681); 
                    str=(Token)match(input,STRING,FOLLOW_STRING_in_write_stmt685); 
                    match(input,26,FOLLOW_26_in_write_stmt687); 


                    // TEMPLATE REWRITE
                    // 285:38: -> write_string(string=$str.text)
                    {
                        retval.st = templateLib.getInstanceOf("write_string",
                      new STAttrMap().put("string", (str!=null?str.getText():null)));
                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "write_stmt"

    public static class read_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "read_stmt"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:288:1: read_stmt : 'read' '(' id= IDENT ')' ;
    public final AlLanguageParser.read_stmt_return read_stmt() throws RecognitionException {
        AlLanguageParser.read_stmt_return retval = new AlLanguageParser.read_stmt_return();
        retval.start = input.LT(1);

        Token id=null;

        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:289:2: ( 'read' '(' id= IDENT ')' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:289:4: 'read' '(' id= IDENT ')'
            {
            match(input,30,FOLLOW_30_in_read_stmt707); 
            match(input,25,FOLLOW_25_in_read_stmt709); 
            id=(Token)match(input,IDENT,FOLLOW_IDENT_in_read_stmt713); 
            match(input,26,FOLLOW_26_in_read_stmt715); 

                        if (!currentNamesTable.isExistInAll((id!=null?id.getText():null))) {
                            ErrorsTable.getInstance().addError(" variable \"" + (id!=null?id.getText():null) + "\" must be declared.", (id!=null?id.getLine():0));
                        } else {
                            Var var = currentNamesTable.getVar((id!=null?id.getText():null));

                            if (TypesChecker.isFloat(var.getType())) {
                                if (var.isGlobal()) {
                                    retval.st = templateLib.getInstanceOf("read_field_float",
              new STAttrMap().put("programName", programName).put("fieldName", var.getIdent()));
                                } else {
                                    retval.st = templateLib.getInstanceOf("read_var_float",
              new STAttrMap().put("variableNumber", var.getVariableNumber()));
                                }
                            } else {
                                if (var.isGlobal()) {
                                    retval.st = templateLib.getInstanceOf("read_field_int",
              new STAttrMap().put("programName", programName).put("fieldName", var.getIdent()));
                                } else {
                                    retval.st = templateLib.getInstanceOf("read_var_int",
              new STAttrMap().put("variableNumber", var.getVariableNumber()));
                                }
                            }

                            variableNumber++;
                        }
                    

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "read_stmt"

    public static class if_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "if_stmt"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:315:1: if_stmt : s= 'if' '(' expr= expression ')' ifblock= block ( 'else' elseblock= block )? ;
    public final AlLanguageParser.if_stmt_return if_stmt() throws RecognitionException {
        AlLanguageParser.if_stmt_return retval = new AlLanguageParser.if_stmt_return();
        retval.start = input.LT(1);

        Token s=null;
        AlLanguageParser.expression_return expr = null;

        AlLanguageParser.block_return ifblock = null;

        AlLanguageParser.block_return elseblock = null;


        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:316:2: (s= 'if' '(' expr= expression ')' ifblock= block ( 'else' elseblock= block )? )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:316:4: s= 'if' '(' expr= expression ')' ifblock= block ( 'else' elseblock= block )?
            {
            s=(Token)match(input,31,FOLLOW_31_in_if_stmt738); 
            match(input,25,FOLLOW_25_in_if_stmt740); 
            pushFollow(FOLLOW_expression_in_if_stmt744);
            expr=expression();

            state._fsp--;

            match(input,26,FOLLOW_26_in_if_stmt746); 
            pushFollow(FOLLOW_block_in_if_stmt750);
            ifblock=block();

            state._fsp--;

            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:316:49: ( 'else' elseblock= block )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==32) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:316:51: 'else' elseblock= block
                    {
                    match(input,32,FOLLOW_32_in_if_stmt754); 
                    pushFollow(FOLLOW_block_in_if_stmt758);
                    elseblock=block();

                    state._fsp--;


                    }
                    break;

            }


                        if (!TypesChecker.checkTypes((expr!=null?expr.type:null), Type.BOOLEAN)) {
                            ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage((s!=null?s.getText():null)), (s!=null?s.getLine():0));
                        }

                        retval.st = templateLib.getInstanceOf("if_operator",
              new STAttrMap().put("expression", (expr!=null?expr.st:null)).put("ifBlock", (ifblock!=null?ifblock.stList:null)).put("elseBlock", (elseblock!=null?elseblock.stList:null)).put("firstLabel", labelNumber).put("secondLabel", labelNumber + 1));

                        labelNumber = labelNumber + 2;
                    

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "if_stmt"

    public static class for_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "for_stmt"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:329:1: for_stmt : s= 'for' '(' begin= assign_stmt ';' check= expression ';' end= assign_stmt ')' forBlock= block ;
    public final AlLanguageParser.for_stmt_return for_stmt() throws RecognitionException {
        AlLanguageParser.for_stmt_return retval = new AlLanguageParser.for_stmt_return();
        retval.start = input.LT(1);

        Token s=null;
        AlLanguageParser.assign_stmt_return begin = null;

        AlLanguageParser.expression_return check = null;

        AlLanguageParser.assign_stmt_return end = null;

        AlLanguageParser.block_return forBlock = null;


        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:330:2: (s= 'for' '(' begin= assign_stmt ';' check= expression ';' end= assign_stmt ')' forBlock= block )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:330:4: s= 'for' '(' begin= assign_stmt ';' check= expression ';' end= assign_stmt ')' forBlock= block
            {
            s=(Token)match(input,33,FOLLOW_33_in_for_stmt784); 
            match(input,25,FOLLOW_25_in_for_stmt786); 
            pushFollow(FOLLOW_assign_stmt_in_for_stmt790);
            begin=assign_stmt();

            state._fsp--;

            match(input,21,FOLLOW_21_in_for_stmt792); 
            pushFollow(FOLLOW_expression_in_for_stmt796);
            check=expression();

            state._fsp--;

            match(input,21,FOLLOW_21_in_for_stmt798); 
            pushFollow(FOLLOW_assign_stmt_in_for_stmt802);
            end=assign_stmt();

            state._fsp--;

            match(input,26,FOLLOW_26_in_for_stmt804); 
            pushFollow(FOLLOW_block_in_for_stmt808);
            forBlock=block();

            state._fsp--;


                        if (!TypesChecker.isBoolean((check!=null?check.type:null))) {
                            ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage((s!=null?s.getText():null)), (s!=null?s.getLine():0));
                        }

                        retval.st = templateLib.getInstanceOf("for_operator",
              new STAttrMap().put("beginExpression", (begin!=null?begin.st:null)).put("checkExpression", (check!=null?check.st:null)).put("endExpression", (end!=null?end.st:null)).put("forBlock", (forBlock!=null?forBlock.stList:null)).put("firstLabel", labelNumber).put("secondLabel", labelNumber + 1).put("thirdLabel", labelNumber + 2));

                        labelNumber = labelNumber + 3;
                    

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "for_stmt"

    public static class while_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "while_stmt"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:343:1: while_stmt : s= 'while' '(' expr= expression ')' whileBlock= block ;
    public final AlLanguageParser.while_stmt_return while_stmt() throws RecognitionException {
        AlLanguageParser.while_stmt_return retval = new AlLanguageParser.while_stmt_return();
        retval.start = input.LT(1);

        Token s=null;
        AlLanguageParser.expression_return expr = null;

        AlLanguageParser.block_return whileBlock = null;


        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:344:2: (s= 'while' '(' expr= expression ')' whileBlock= block )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:344:4: s= 'while' '(' expr= expression ')' whileBlock= block
            {
            s=(Token)match(input,34,FOLLOW_34_in_while_stmt831); 
            match(input,25,FOLLOW_25_in_while_stmt833); 
            pushFollow(FOLLOW_expression_in_while_stmt837);
            expr=expression();

            state._fsp--;

            match(input,26,FOLLOW_26_in_while_stmt839); 
            pushFollow(FOLLOW_block_in_while_stmt843);
            whileBlock=block();

            state._fsp--;


                        if (!TypesChecker.checkTypes((expr!=null?expr.type:null), Type.BOOLEAN)) {
                            ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage((s!=null?s.getText():null)), (s!=null?s.getLine():0));
                        }

                        retval.st = templateLib.getInstanceOf("while_do",
              new STAttrMap().put("checkExpression", (expr!=null?expr.st:null)).put("whileBlock", (whileBlock!=null?whileBlock.stList:null)).put("firstLabel", labelNumber).put("secondLabel", labelNumber + 1).put("thirdLabel", labelNumber + 2));

                        labelNumber = labelNumber + 3;
                    

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "while_stmt"

    public static class do_while_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "do_while_stmt"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:357:1: do_while_stmt : s= 'do' doBlock= block 'while' '(' expr= expression ')' ;
    public final AlLanguageParser.do_while_stmt_return do_while_stmt() throws RecognitionException {
        AlLanguageParser.do_while_stmt_return retval = new AlLanguageParser.do_while_stmt_return();
        retval.start = input.LT(1);

        Token s=null;
        AlLanguageParser.block_return doBlock = null;

        AlLanguageParser.expression_return expr = null;


        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:358:2: (s= 'do' doBlock= block 'while' '(' expr= expression ')' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:358:4: s= 'do' doBlock= block 'while' '(' expr= expression ')'
            {
            s=(Token)match(input,35,FOLLOW_35_in_do_while_stmt866); 
            pushFollow(FOLLOW_block_in_do_while_stmt870);
            doBlock=block();

            state._fsp--;

            match(input,34,FOLLOW_34_in_do_while_stmt872); 
            match(input,25,FOLLOW_25_in_do_while_stmt874); 
            pushFollow(FOLLOW_expression_in_do_while_stmt878);
            expr=expression();

            state._fsp--;

            match(input,26,FOLLOW_26_in_do_while_stmt880); 

                        if (!TypesChecker.checkTypes((expr!=null?expr.type:null), Type.BOOLEAN)) {
                            ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage((s!=null?s.getText():null)), (s!=null?s.getLine():0));
                        }

                        retval.st = templateLib.getInstanceOf("do_while",
              new STAttrMap().put("checkExpression", (expr!=null?expr.st:null)).put("doBlock", (doBlock!=null?doBlock.stList:null)).put("firstLabel", labelNumber));

                        labelNumber++;
                    

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "do_while_stmt"

    public static class return_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "return_stmt"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:370:1: return_stmt : s= 'return' expr= expression -> { $expr.st };
    public final AlLanguageParser.return_stmt_return return_stmt() throws RecognitionException {
        AlLanguageParser.return_stmt_return retval = new AlLanguageParser.return_stmt_return();
        retval.start = input.LT(1);

        Token s=null;
        AlLanguageParser.expression_return expr = null;


        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:371:2: (s= 'return' expr= expression -> { $expr.st })
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:371:4: s= 'return' expr= expression
            {
            s=(Token)match(input,36,FOLLOW_36_in_return_stmt903); 
            pushFollow(FOLLOW_expression_in_return_stmt907);
            expr=expression();

            state._fsp--;


                        Procedure procedure = globalNamesTable.getProcedure(currentProcedureName);
                        if (!TypesChecker.checkTypes((expr!=null?expr.type:null), procedure.getReturnType())) {
                            ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage((s!=null?s.getText():null)), (s!=null?s.getLine():0));
                        }
                    


            // TEMPLATE REWRITE
            // 379:9: -> { $expr.st }
            {
                retval.st =  (expr!=null?expr.st:null) ;
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "return_stmt"

    public static class procedure_call_stmt_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "procedure_call_stmt"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:382:1: procedure_call_stmt : procedure_call -> { $procedure_call.st };
    public final AlLanguageParser.procedure_call_stmt_return procedure_call_stmt() throws RecognitionException {
        AlLanguageParser.procedure_call_stmt_return retval = new AlLanguageParser.procedure_call_stmt_return();
        retval.start = input.LT(1);

        AlLanguageParser.procedure_call_return procedure_call17 = null;


        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:383:9: ( procedure_call -> { $procedure_call.st })
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:383:11: procedure_call
            {
            pushFollow(FOLLOW_procedure_call_in_procedure_call_stmt948);
            procedure_call17=procedure_call();

            state._fsp--;



            // TEMPLATE REWRITE
            // 384:9: -> { $procedure_call.st }
            {
                retval.st =  (procedure_call17!=null?procedure_call17.st:null) ;
            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "procedure_call_stmt"

    public static class procedure_call_return extends ParserRuleReturnScope {
        public String procedureId;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "procedure_call"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:387:1: procedure_call returns [String procedureId] : 'call' id= IDENT '(' argsType= arg_call ')' ;
    public final AlLanguageParser.procedure_call_return procedure_call() throws RecognitionException {
        AlLanguageParser.procedure_call_return retval = new AlLanguageParser.procedure_call_return();
        retval.start = input.LT(1);

        Token id=null;
        AlLanguageParser.arg_call_return argsType = null;



            List<StringTemplate> argTypes = new ArrayList<StringTemplate>();

        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:392:2: ( 'call' id= IDENT '(' argsType= arg_call ')' )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:392:4: 'call' id= IDENT '(' argsType= arg_call ')'
            {
            match(input,37,FOLLOW_37_in_procedure_call987); 
            id=(Token)match(input,IDENT,FOLLOW_IDENT_in_procedure_call991); 
             retval.procedureId = (id!=null?id.getText():null); 
            match(input,25,FOLLOW_25_in_procedure_call994); 
            pushFollow(FOLLOW_arg_call_in_procedure_call998);
            argsType=arg_call();

            state._fsp--;

            match(input,26,FOLLOW_26_in_procedure_call1000); 

                        if (globalNamesTable.isProcedureDeclarated((id!=null?id.getText():null))) {
                            Procedure procedure = globalNamesTable.getProcedure((id!=null?id.getText():null));
                            if (procedure.getProcedureArgs().size() == (argsType!=null?argsType.types:null).size()) {
                                int i = 0;
                                for (String type : (argsType!=null?argsType.types:null)) {
                                    String procedureArgType = procedure.getProcedureArgs().get(i).getType();
                                    if (!type.equals(procedureArgType)) {
                                        ErrorsTable.getInstance().addError(" wrong type of parameter for procedure \"" + (id!=null?id.getText():null) + "\".", (id!=null?id.getLine():0));
                                    }

                                    if (TypesChecker.isFloat(type)) {
                                        argTypes.add(templateLib.getInstanceOf("type_float"));
                                    } else {
                                        argTypes.add(templateLib.getInstanceOf("type_int"));
                                    }

                                    i++;
                                }
                            } else {
                                ErrorsTable.getInstance().addError(" wrong number of arguments for procedure \"" + (id!=null?id.getText():null) + "\".", (id!=null?id.getLine():0));
                            }

                            StringTemplate returnType;
                            if (TypesChecker.isFloat(procedure.getReturnType())) {
                                returnType = templateLib.getInstanceOf("type_float");
                            } else if (TypesChecker.isBoolean(procedure.getReturnType())){
                                returnType = templateLib.getInstanceOf("type_boolean");
                            } else {
                                returnType = templateLib.getInstanceOf("type_int");
                            }

                            retval.st = templateLib.getInstanceOf("procedure_call",
              new STAttrMap().put("programName", programName).put("procedureName", (id!=null?id.getText():null)).put("argTemplates", (argsType!=null?argsType.stList:null)).put("argTypes", argTypes).put("returnType", returnType));
                        } else {
                            ErrorsTable.getInstance().addError(" procedure \"" + (id!=null?id.getText():null) + "\" must be declared.", (id!=null?id.getLine():0));
                        }
                    

            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "procedure_call"

    public static class expression_return extends ParserRuleReturnScope {
        public String type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "expression"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:432:1: expression returns [String type] : first= and_expression (op= '|' second= expression )? ;
    public final AlLanguageParser.expression_return expression() throws RecognitionException {
        AlLanguageParser.expression_return retval = new AlLanguageParser.expression_return();
        retval.start = input.LT(1);

        Token op=null;
        AlLanguageParser.and_expression_return first = null;

        AlLanguageParser.expression_return second = null;


         String newType = ""; 
        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:436:2: (first= and_expression (op= '|' second= expression )? )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:436:4: first= and_expression (op= '|' second= expression )?
            {
            pushFollow(FOLLOW_and_expression_in_expression1037);
            first=and_expression();

            state._fsp--;

             newType = (first!=null?first.type:null); retval.st = (first!=null?first.st:null); 
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:436:69: (op= '|' second= expression )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==38) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:436:71: op= '|' second= expression
                    {
                    op=(Token)match(input,38,FOLLOW_38_in_expression1045); 
                    pushFollow(FOLLOW_expression_in_expression1049);
                    second=expression();

                    state._fsp--;


                                newType = TypesChecker.getLogicResultType((first!=null?first.type:null), (second!=null?second.type:null));
                                if (newType.equals(Type.ERROR)) {
                                    ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage((op!=null?op.getText():null)), (op!=null?op.getLine():0));
                                }

                                retval.st = templateLib.getInstanceOf("logical_or",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("firstLabel", labelNumber).put("secondLabel", labelNumber + 1).put("thirdLabel", labelNumber + 2));

                                labelNumber = labelNumber + 3;
                            

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

             retval.type = newType; 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "expression"

    public static class and_expression_return extends ParserRuleReturnScope {
        public String type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "and_expression"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:450:1: and_expression returns [String type] : first= not_expression (op= '&' second= and_expression )? ;
    public final AlLanguageParser.and_expression_return and_expression() throws RecognitionException {
        AlLanguageParser.and_expression_return retval = new AlLanguageParser.and_expression_return();
        retval.start = input.LT(1);

        Token op=null;
        AlLanguageParser.not_expression_return first = null;

        AlLanguageParser.and_expression_return second = null;


         String newType = ""; 
        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:454:2: (first= not_expression (op= '&' second= and_expression )? )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:454:4: first= not_expression (op= '&' second= and_expression )?
            {
            pushFollow(FOLLOW_not_expression_in_and_expression1089);
            first=not_expression();

            state._fsp--;

             newType = (first!=null?first.type:null); retval.st = (first!=null?first.st:null); 
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:454:68: (op= '&' second= and_expression )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==39) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:454:70: op= '&' second= and_expression
                    {
                    op=(Token)match(input,39,FOLLOW_39_in_and_expression1096); 
                    pushFollow(FOLLOW_and_expression_in_and_expression1100);
                    second=and_expression();

                    state._fsp--;


                                newType = TypesChecker.getLogicResultType((first!=null?first.type:null), (second!=null?second.type:null));
                                if (newType.equals(Type.ERROR)) {
                                    ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage((op!=null?op.getText():null)), (op!=null?op.getLine():0));
                                }

                                retval.st = templateLib.getInstanceOf("logical_and",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("firstLabel", labelNumber).put("secondLabel", labelNumber + 1).put("thirdLabel", labelNumber + 2));

                                labelNumber = labelNumber + 3;
                            

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

             retval.type = newType; 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "and_expression"

    public static class not_expression_return extends ParserRuleReturnScope {
        public String type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "not_expression"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:468:1: not_expression returns [String type] : (op= '!' first= not_expression | second= comparison );
    public final AlLanguageParser.not_expression_return not_expression() throws RecognitionException {
        AlLanguageParser.not_expression_return retval = new AlLanguageParser.not_expression_return();
        retval.start = input.LT(1);

        Token op=null;
        AlLanguageParser.not_expression_return first = null;

        AlLanguageParser.comparison_return second = null;


         String newType = "";
        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:472:2: (op= '!' first= not_expression | second= comparison )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==40) ) {
                alt12=1;
            }
            else if ( (LA12_0==IDENT||(LA12_0>=INT && LA12_0<=FLOAT)||LA12_0==25||LA12_0==37||(LA12_0>=51 && LA12_0<=52)||(LA12_0>=56 && LA12_0<=57)) ) {
                alt12=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 12, 0, input);

                throw nvae;
            }
            switch (alt12) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:472:4: op= '!' first= not_expression
                    {
                    op=(Token)match(input,40,FOLLOW_40_in_not_expression1140); 
                    pushFollow(FOLLOW_not_expression_in_not_expression1144);
                    first=not_expression();

                    state._fsp--;


                                newType = TypesChecker.getLogicResultType((first!=null?first.type:null), Type.BOOLEAN);
                                if (newType.equals(Type.ERROR)) {
                                    ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage((op!=null?op.getText():null)), (op!=null?op.getLine():0));
                                }

                                retval.st = templateLib.getInstanceOf("logical_not",
                      new STAttrMap().put("expression", (first!=null?first.st:null)).put("firstLabel", labelNumber).put("secondLabel", labelNumber + 1));

                                labelNumber = labelNumber + 2;
                            

                    }
                    break;
                case 2 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:483:4: second= comparison
                    {
                    pushFollow(FOLLOW_comparison_in_not_expression1161);
                    second=comparison();

                    state._fsp--;

                     newType = (second!=null?second.type:null); retval.st = (second!=null?second.st:null); 

                    }
                    break;

            }
            retval.stop = input.LT(-1);

             retval.type = newType; 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "not_expression"

    public static class comparison_return extends ParserRuleReturnScope {
        public String type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "comparison"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:486:1: comparison returns [String type] : first= math_expression ( (op= '<' | op= '>' | op= '==' | op= '!=' ) second= math_expression )? ;
    public final AlLanguageParser.comparison_return comparison() throws RecognitionException {
        AlLanguageParser.comparison_return retval = new AlLanguageParser.comparison_return();
        retval.start = input.LT(1);

        Token op=null;
        AlLanguageParser.math_expression_return first = null;

        AlLanguageParser.math_expression_return second = null;


         String newType = ""; 
        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:490:2: (first= math_expression ( (op= '<' | op= '>' | op= '==' | op= '!=' ) second= math_expression )? )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:490:4: first= math_expression ( (op= '<' | op= '>' | op= '==' | op= '!=' ) second= math_expression )?
            {
            pushFollow(FOLLOW_math_expression_in_comparison1190);
            first=math_expression();

            state._fsp--;

             newType = (first!=null?first.type:null); retval.st = (first!=null?first.st:null); 
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:491:9: ( (op= '<' | op= '>' | op= '==' | op= '!=' ) second= math_expression )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=41 && LA14_0<=44)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:491:11: (op= '<' | op= '>' | op= '==' | op= '!=' ) second= math_expression
                    {
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:491:11: (op= '<' | op= '>' | op= '==' | op= '!=' )
                    int alt13=4;
                    switch ( input.LA(1) ) {
                    case 41:
                        {
                        alt13=1;
                        }
                        break;
                    case 42:
                        {
                        alt13=2;
                        }
                        break;
                    case 43:
                        {
                        alt13=3;
                        }
                        break;
                    case 44:
                        {
                        alt13=4;
                        }
                        break;
                    default:
                        NoViableAltException nvae =
                            new NoViableAltException("", 13, 0, input);

                        throw nvae;
                    }

                    switch (alt13) {
                        case 1 :
                            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:491:12: op= '<'
                            {
                            op=(Token)match(input,41,FOLLOW_41_in_comparison1207); 

                            }
                            break;
                        case 2 :
                            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:491:21: op= '>'
                            {
                            op=(Token)match(input,42,FOLLOW_42_in_comparison1213); 

                            }
                            break;
                        case 3 :
                            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:491:30: op= '=='
                            {
                            op=(Token)match(input,43,FOLLOW_43_in_comparison1219); 

                            }
                            break;
                        case 4 :
                            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:491:40: op= '!='
                            {
                            op=(Token)match(input,44,FOLLOW_44_in_comparison1225); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_math_expression_in_comparison1230);
                    second=math_expression();

                    state._fsp--;


                                newType = TypesChecker.getComparisonResultType((first!=null?first.type:null), (second!=null?second.type:null));
                                if (newType.equals(Type.ERROR)) {
                                    ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage((op!=null?op.getText():null)), (op!=null?op.getLine():0));
                                }

                                if (TypesChecker.isInt((first!=null?first.type:null))) {
                                    if ((op!=null?op.getText():null).equals("<")) {
                                        retval.st = templateLib.getInstanceOf("comp_int_lt",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("firstLabel", labelNumber).put("secondLabel", labelNumber + 1));
                                        labelNumber = labelNumber + 2;
                                    } else if ((op!=null?op.getText():null).equals(">")) {
                                        retval.st = templateLib.getInstanceOf("comp_int_gt",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("firstLabel", labelNumber).put("secondLabel", labelNumber + 1));
                                        labelNumber = labelNumber + 2;
                                    } else if ((op!=null?op.getText():null).equals("==")) {
                                        retval.st = templateLib.getInstanceOf("comp_int_eq",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("firstLabel", labelNumber).put("secondLabel", labelNumber + 1));
                                        labelNumber = labelNumber + 2;
                                    } else if ((op!=null?op.getText():null).equals("!=")) {
                                        retval.st = templateLib.getInstanceOf("comp_int_ne",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("firstLabel", labelNumber).put("secondLabel", labelNumber + 1));
                                        labelNumber = labelNumber + 2;
                                    }
                                } else if (TypesChecker.isFloat((first!=null?first.type:null))) {
                                    if ((op!=null?op.getText():null).equals("<")) {
                                        retval.st = templateLib.getInstanceOf("comp_float_lt",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("firstLabel", labelNumber).put("secondLabel", labelNumber + 1));
                                        labelNumber = labelNumber + 2;
                                    } else if ((op!=null?op.getText():null).equals(">")) {
                                        retval.st = templateLib.getInstanceOf("comp_float_gt",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("firstLabel", labelNumber).put("secondLabel", labelNumber + 1));
                                        labelNumber = labelNumber + 2;
                                    } else if ((op!=null?op.getText():null).equals("==")) {
                                        retval.st = templateLib.getInstanceOf("comp_float_eq",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("firstLabel", labelNumber).put("secondLabel", labelNumber + 1));
                                        labelNumber = labelNumber + 2;
                                    } else if ((op!=null?op.getText():null).equals("!=")) {
                                        retval.st = templateLib.getInstanceOf("comp_float_ne",
                      new STAttrMap().put("firstExpression", (first!=null?first.st:null)).put("secondExpression", (second!=null?second.st:null)).put("firstLabel", labelNumber).put("secondLabel", labelNumber + 1));
                                        labelNumber = labelNumber + 2;
                                    }
                                }
                            

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

             retval.type = newType; 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "comparison"

    public static class math_expression_return extends ParserRuleReturnScope {
        public String type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "math_expression"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:530:1: math_expression returns [String type] : first= mult ( (op= '+' | op= '-' ) second= math_expression )? ;
    public final AlLanguageParser.math_expression_return math_expression() throws RecognitionException {
        AlLanguageParser.math_expression_return retval = new AlLanguageParser.math_expression_return();
        retval.start = input.LT(1);

        Token op=null;
        AlLanguageParser.mult_return first = null;

        AlLanguageParser.math_expression_return second = null;


         String newType = ""; 
        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:534:2: (first= mult ( (op= '+' | op= '-' ) second= math_expression )? )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:534:4: first= mult ( (op= '+' | op= '-' ) second= math_expression )?
            {
            pushFollow(FOLLOW_mult_in_math_expression1270);
            first=mult();

            state._fsp--;

             newType = (first!=null?first.type:null); retval.st = (first!=null?first.st:null); 
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:534:59: ( (op= '+' | op= '-' ) second= math_expression )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=45 && LA16_0<=46)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:534:61: (op= '+' | op= '-' ) second= math_expression
                    {
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:534:61: (op= '+' | op= '-' )
                    int alt15=2;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==45) ) {
                        alt15=1;
                    }
                    else if ( (LA15_0==46) ) {
                        alt15=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 0, input);

                        throw nvae;
                    }
                    switch (alt15) {
                        case 1 :
                            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:534:62: op= '+'
                            {
                            op=(Token)match(input,45,FOLLOW_45_in_math_expression1279); 

                            }
                            break;
                        case 2 :
                            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:534:71: op= '-'
                            {
                            op=(Token)match(input,46,FOLLOW_46_in_math_expression1285); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_math_expression_in_math_expression1290);
                    second=math_expression();

                    state._fsp--;


                                newType = TypesChecker.getSumResultType((first!=null?first.type:null), (second!=null?second.type:null));
                                if (newType.equals(Type.ERROR)) {
                                    ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage((op!=null?op.getText():null)), (op!=null?op.getLine():0));
                                }
                                if ((op!=null?op.getText():null).equals("+")) {
                                    if (TypesChecker.isFloat((first!=null?first.type:null))) {
                                        retval.st = templateLib.getInstanceOf("add_float",
                      new STAttrMap().put("firstValue", (first!=null?first.st:null)).put("secondValue", (second!=null?second.st:null)));
                                    } else {
                                        retval.st = templateLib.getInstanceOf("add_int",
                      new STAttrMap().put("firstValue", (first!=null?first.st:null)).put("secondValue", (second!=null?second.st:null)));
                                    }
                                } else {
                                    if (TypesChecker.isFloat((first!=null?first.type:null))) {
                                        retval.st = templateLib.getInstanceOf("sub_float",
                      new STAttrMap().put("firstValue", (first!=null?first.st:null)).put("secondValue", (second!=null?second.st:null)));
                                    } else {
                                        retval.st = templateLib.getInstanceOf("sub_int",
                      new STAttrMap().put("firstValue", (first!=null?first.st:null)).put("secondValue", (second!=null?second.st:null)));
                                    }
                                }
                            

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

             retval.type = newType; 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "math_expression"

    public static class mult_return extends ParserRuleReturnScope {
        public String type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "mult"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:556:1: mult returns [String type] : first= mod ( (op= '*' | op= '/' ) second= mult )? ;
    public final AlLanguageParser.mult_return mult() throws RecognitionException {
        AlLanguageParser.mult_return retval = new AlLanguageParser.mult_return();
        retval.start = input.LT(1);

        Token op=null;
        AlLanguageParser.mod_return first = null;

        AlLanguageParser.mult_return second = null;


         String newType = ""; 
        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:560:2: (first= mod ( (op= '*' | op= '/' ) second= mult )? )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:560:4: first= mod ( (op= '*' | op= '/' ) second= mult )?
            {
            pushFollow(FOLLOW_mod_in_mult1330);
            first=mod();

            state._fsp--;

             newType = (first!=null?first.type:null); retval.st = (first!=null?first.st:null); 
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:560:57: ( (op= '*' | op= '/' ) second= mult )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=47 && LA18_0<=48)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:560:58: (op= '*' | op= '/' ) second= mult
                    {
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:560:58: (op= '*' | op= '/' )
                    int alt17=2;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==47) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==48) ) {
                        alt17=2;
                    }
                    else {
                        NoViableAltException nvae =
                            new NoViableAltException("", 17, 0, input);

                        throw nvae;
                    }
                    switch (alt17) {
                        case 1 :
                            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:560:60: op= '*'
                            {
                            op=(Token)match(input,47,FOLLOW_47_in_mult1338); 

                            }
                            break;
                        case 2 :
                            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:560:69: op= '/'
                            {
                            op=(Token)match(input,48,FOLLOW_48_in_mult1344); 

                            }
                            break;

                    }

                    pushFollow(FOLLOW_mult_in_mult1349);
                    second=mult();

                    state._fsp--;


                                if ((op!=null?op.getText():null).equals("*")) {
                                    newType = TypesChecker.getMultResultType((first!=null?first.type:null), (second!=null?second.type:null));

                                    if (TypesChecker.isFloat((first!=null?first.type:null))) {
                                        retval.st = templateLib.getInstanceOf("mult_float",
                      new STAttrMap().put("firstValue", first.st).put("secondValue", second.st));
                                    } else {
                                        retval.st = templateLib.getInstanceOf("mult_int",
                      new STAttrMap().put("firstValue", first.st).put("secondValue", second.st));
                                    }
                                } else {
                                    newType = TypesChecker.getDivResultType((first!=null?first.type:null), (second!=null?second.type:null));

                                    if (TypesChecker.isFloat((first!=null?first.type:null))) {
                                        retval.st = templateLib.getInstanceOf("div_float",
                      new STAttrMap().put("firstValue", first.st).put("secondValue", second.st));
                                    } else {
                                        retval.st = templateLib.getInstanceOf("div_int",
                      new STAttrMap().put("firstValue", first.st).put("secondValue", second.st));
                                    }
                                }

                                if (newType.equals(Type.ERROR)) {
                                    ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage((op!=null?op.getText():null)), (op!=null?op.getLine():0));
                                }
                            

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

             retval.type = newType; 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "mult"

    public static class mod_return extends ParserRuleReturnScope {
        public String type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "mod"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:585:1: mod returns [String type] : first= pow (op= '%' second= pow )? ;
    public final AlLanguageParser.mod_return mod() throws RecognitionException {
        AlLanguageParser.mod_return retval = new AlLanguageParser.mod_return();
        retval.start = input.LT(1);

        Token op=null;
        AlLanguageParser.pow_return first = null;

        AlLanguageParser.pow_return second = null;


         String newType = ""; 
        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:589:9: (first= pow (op= '%' second= pow )? )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:589:11: first= pow (op= '%' second= pow )?
            {
            pushFollow(FOLLOW_pow_in_mod1395);
            first=pow();

            state._fsp--;

             newType = (first!=null?first.type:null); retval.st = (first!=null?first.st:null); 
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:589:64: (op= '%' second= pow )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==49) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:589:65: op= '%' second= pow
                    {
                    op=(Token)match(input,49,FOLLOW_49_in_mod1401); 
                    pushFollow(FOLLOW_pow_in_mod1405);
                    second=pow();

                    state._fsp--;


                                newType = TypesChecker.getModResultType((first!=null?first.type:null), (second!=null?second.type:null));
                                if (newType.equals(Type.ERROR)) {
                                    ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage((op!=null?op.getText():null)), (op!=null?op.getLine():0));
                                }

                                if (TypesChecker.isFloat((first!=null?first.type:null))) {
                                    retval.st = templateLib.getInstanceOf("mod_float",
                      new STAttrMap().put("firstValue", (first!=null?first.st:null)).put("secondValue", (second!=null?second.st:null)));
                                } else {
                                    retval.st = templateLib.getInstanceOf("mod_int",
                      new STAttrMap().put("firstValue", (first!=null?first.st:null)).put("secondValue", (second!=null?second.st:null)));
                                }
                            

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

             retval.type = newType; 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "mod"

    public static class pow_return extends ParserRuleReturnScope {
        public String type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "pow"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:604:1: pow returns [String type] : first= convert_type (op= '^' second= convert_type )? ;
    public final AlLanguageParser.pow_return pow() throws RecognitionException {
        AlLanguageParser.pow_return retval = new AlLanguageParser.pow_return();
        retval.start = input.LT(1);

        Token op=null;
        AlLanguageParser.convert_type_return first = null;

        AlLanguageParser.convert_type_return second = null;


         String newType = ""; 
        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:608:2: (first= convert_type (op= '^' second= convert_type )? )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:608:4: first= convert_type (op= '^' second= convert_type )?
            {
            pushFollow(FOLLOW_convert_type_in_pow1452);
            first=convert_type();

            state._fsp--;

             newType = (first!=null?first.type:null); retval.st = (first!=null?first.st:null); 
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:608:67: (op= '^' second= convert_type )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==50) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:608:69: op= '^' second= convert_type
                    {
                    op=(Token)match(input,50,FOLLOW_50_in_pow1460); 
                    pushFollow(FOLLOW_convert_type_in_pow1464);
                    second=convert_type();

                    state._fsp--;


                                newType = TypesChecker.getPowResultType((first!=null?first.type:null), (second!=null?second.type:null));
                                if (newType.equals(Type.ERROR)) {
                                    ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage((op!=null?op.getText():null)), (op!=null?op.getLine():0));
                                }

                                if (TypesChecker.isFloat((first!=null?first.type:null))) {
                                    retval.st = templateLib.getInstanceOf("pow_float",
                      new STAttrMap().put("firstValue", (first!=null?first.st:null)).put("secondValue", (second!=null?second.st:null)));
                                } else {
                                    retval.st = templateLib.getInstanceOf("pow_int",
                      new STAttrMap().put("firstValue", (first!=null?first.st:null)).put("secondValue", (second!=null?second.st:null)));
                                }
                            

                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

             retval.type = newType; 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "pow"

    public static class convert_type_return extends ParserRuleReturnScope {
        public String type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "convert_type"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:623:1: convert_type returns [String type] : (convert= 'convertF2I' '(' atom ')' -> convert_f2i(atom=$atom.st) | convert= 'convertI2F' '(' atom ')' -> convert_i2f(atom=$atom.st) | atom -> {$atom.st});
    public final AlLanguageParser.convert_type_return convert_type() throws RecognitionException {
        AlLanguageParser.convert_type_return retval = new AlLanguageParser.convert_type_return();
        retval.start = input.LT(1);

        Token convert=null;
        AlLanguageParser.atom_return atom18 = null;

        AlLanguageParser.atom_return atom19 = null;

        AlLanguageParser.atom_return atom20 = null;


         String newType = ""; 
        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:627:9: (convert= 'convertF2I' '(' atom ')' -> convert_f2i(atom=$atom.st) | convert= 'convertI2F' '(' atom ')' -> convert_i2f(atom=$atom.st) | atom -> {$atom.st})
            int alt21=3;
            switch ( input.LA(1) ) {
            case 51:
                {
                alt21=1;
                }
                break;
            case 52:
                {
                alt21=2;
                }
                break;
            case IDENT:
            case INT:
            case FLOAT:
            case 25:
            case 37:
            case 56:
            case 57:
                {
                alt21=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:627:11: convert= 'convertF2I' '(' atom ')'
                    {
                    convert=(Token)match(input,51,FOLLOW_51_in_convert_type1511); 
                    match(input,25,FOLLOW_25_in_convert_type1513); 
                    pushFollow(FOLLOW_atom_in_convert_type1515);
                    atom18=atom();

                    state._fsp--;

                    match(input,26,FOLLOW_26_in_convert_type1517); 

                                if (TypesChecker.isFloat((atom18!=null?atom18.type:null))) {
                                    newType = Type.INT;
                                } else {
                                    ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage((convert!=null?convert.getText():null)), (convert!=null?convert.getLine():0));
                                }
                            


                    // TEMPLATE REWRITE
                    // 635:9: -> convert_f2i(atom=$atom.st)
                    {
                        retval.st = templateLib.getInstanceOf("convert_f2i",
                      new STAttrMap().put("atom", (atom18!=null?atom18.st:null)));
                    }


                    }
                    break;
                case 2 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:636:11: convert= 'convertI2F' '(' atom ')'
                    {
                    convert=(Token)match(input,52,FOLLOW_52_in_convert_type1558); 
                    match(input,25,FOLLOW_25_in_convert_type1560); 
                    pushFollow(FOLLOW_atom_in_convert_type1562);
                    atom19=atom();

                    state._fsp--;

                    match(input,26,FOLLOW_26_in_convert_type1564); 

                                if (TypesChecker.isInt((atom19!=null?atom19.type:null))) {
                                    newType = Type.FLOAT;
                                } else {
                                    ErrorsTable.getInstance().addError(TypesChecker.getWrongMessage((convert!=null?convert.getText():null)), (convert!=null?convert.getLine():0));
                                }
                            


                    // TEMPLATE REWRITE
                    // 644:9: -> convert_i2f(atom=$atom.st)
                    {
                        retval.st = templateLib.getInstanceOf("convert_i2f",
                      new STAttrMap().put("atom", (atom19!=null?atom19.st:null)));
                    }


                    }
                    break;
                case 3 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:645:11: atom
                    {
                    pushFollow(FOLLOW_atom_in_convert_type1603);
                    atom20=atom();

                    state._fsp--;

                     newType = (atom20!=null?atom20.type:null); 


                    // TEMPLATE REWRITE
                    // 646:9: -> {$atom.st}
                    {
                        retval.st = (atom20!=null?atom20.st:null);
                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

             retval.type = newType; 
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "convert_type"

    public static class atom_return extends ParserRuleReturnScope {
        public String type;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "atom"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:648:1: atom returns [String type] : (id= IDENT | INT -> const_int(value=$INT.text) | FLOAT -> const_float(value=$FLOAT.text) | '(' expr= expression ')' -> {$expr.st} | boolean_literal -> const_int(value=$boolean_literal.st) | p= procedure_call -> { $p.st });
    public final AlLanguageParser.atom_return atom() throws RecognitionException {
        AlLanguageParser.atom_return retval = new AlLanguageParser.atom_return();
        retval.start = input.LT(1);

        Token id=null;
        Token INT21=null;
        Token FLOAT22=null;
        AlLanguageParser.expression_return expr = null;

        AlLanguageParser.procedure_call_return p = null;

        AlLanguageParser.boolean_literal_return boolean_literal23 = null;


        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:650:2: (id= IDENT | INT -> const_int(value=$INT.text) | FLOAT -> const_float(value=$FLOAT.text) | '(' expr= expression ')' -> {$expr.st} | boolean_literal -> const_int(value=$boolean_literal.st) | p= procedure_call -> { $p.st })
            int alt22=6;
            switch ( input.LA(1) ) {
            case IDENT:
                {
                alt22=1;
                }
                break;
            case INT:
                {
                alt22=2;
                }
                break;
            case FLOAT:
                {
                alt22=3;
                }
                break;
            case 25:
                {
                alt22=4;
                }
                break;
            case 56:
            case 57:
                {
                alt22=5;
                }
                break;
            case 37:
                {
                alt22=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:650:4: id= IDENT
                    {
                    id=(Token)match(input,IDENT,FOLLOW_IDENT_in_atom1640); 

                                boolean isExist = currentNamesTable.isExistInAll((id!=null?id.getText():null));
                                if (isExist) {
                                    Var var = currentNamesTable.getVar((id!=null?id.getText():null));
                                    retval.type = var.getType();
                                    if (TypesChecker.isFloat(var.getType())) {
                                        if (var.isGlobal()) {
                                            retval.st = templateLib.getInstanceOf("referenceField_float",
                      new STAttrMap().put("programName", programName).put("fieldName", var.getIdent()));
                                        } else {
                                            retval.st = templateLib.getInstanceOf("referenceVariable_float",
                      new STAttrMap().put("variableNumber", var.getVariableNumber()));
                                        }
                                    } else {
                                        if (var.isGlobal()) {
                                            retval.st = templateLib.getInstanceOf("referenceField_int",
                      new STAttrMap().put("programName", programName).put("fieldName", var.getIdent()));
                                        } else {
                                            retval.st = templateLib.getInstanceOf("referenceVariable_int",
                      new STAttrMap().put("variableNumber", var.getVariableNumber()));
                                        }
                                    }
                                } else {
                                    ErrorsTable.getInstance().addError(" variable \"" + (id!=null?id.getText():null) + "\" must be declared.", (id!=null?id.getLine():0));
                                }
                            

                    }
                    break;
                case 2 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:673:4: INT
                    {
                    INT21=(Token)match(input,INT,FOLLOW_INT_in_atom1655); 
                     retval.type = Type.INT; 


                    // TEMPLATE REWRITE
                    // 673:30: -> const_int(value=$INT.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_int",
                      new STAttrMap().put("value", (INT21!=null?INT21.getText():null)));
                    }


                    }
                    break;
                case 3 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:674:4: FLOAT
                    {
                    FLOAT22=(Token)match(input,FLOAT,FOLLOW_FLOAT_in_atom1673); 
                     retval.type = Type.FLOAT; 


                    // TEMPLATE REWRITE
                    // 674:34: -> const_float(value=$FLOAT.text)
                    {
                        retval.st = templateLib.getInstanceOf("const_float",
                      new STAttrMap().put("value", (FLOAT22!=null?FLOAT22.getText():null)));
                    }


                    }
                    break;
                case 4 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:675:4: '(' expr= expression ')'
                    {
                    match(input,25,FOLLOW_25_in_atom1691); 
                    pushFollow(FOLLOW_expression_in_atom1695);
                    expr=expression();

                    state._fsp--;

                    match(input,26,FOLLOW_26_in_atom1697); 
                     retval.type = (expr!=null?expr.type:null); 


                    // TEMPLATE REWRITE
                    // 675:52: -> {$expr.st}
                    {
                        retval.st = (expr!=null?expr.st:null);
                    }


                    }
                    break;
                case 5 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:676:4: boolean_literal
                    {
                    pushFollow(FOLLOW_boolean_literal_in_atom1708);
                    boolean_literal23=boolean_literal();

                    state._fsp--;

                     retval.type = Type.BOOLEAN; 


                    // TEMPLATE REWRITE
                    // 676:46: -> const_int(value=$boolean_literal.st)
                    {
                        retval.st = templateLib.getInstanceOf("const_int",
                      new STAttrMap().put("value", (boolean_literal23!=null?boolean_literal23.st:null)));
                    }


                    }
                    break;
                case 6 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:677:4: p= procedure_call
                    {
                    pushFollow(FOLLOW_procedure_call_in_atom1728);
                    p=procedure_call();

                    state._fsp--;


                                if (globalNamesTable.isProcedureDeclarated((p!=null?p.procedureId:null))) {
                                    Procedure procedure = globalNamesTable.getProcedure((p!=null?p.procedureId:null));
                                    retval.type = procedure.getReturnType();
                                }
                            


                    // TEMPLATE REWRITE
                    // 683:11: -> { $p.st }
                    {
                        retval.st =  (p!=null?p.st:null) ;
                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "atom"

    public static class type_return extends ParserRuleReturnScope {
        public StringTemplate returnType;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "type"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:686:1: type returns [StringTemplate returnType] : ( 'int' -> type_int() | 'float' -> type_float() | 'boolean' -> type_boolean());
    public final AlLanguageParser.type_return type() throws RecognitionException {
        AlLanguageParser.type_return retval = new AlLanguageParser.type_return();
        retval.start = input.LT(1);

        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:688:2: ( 'int' -> type_int() | 'float' -> type_float() | 'boolean' -> type_boolean())
            int alt23=3;
            switch ( input.LA(1) ) {
            case 53:
                {
                alt23=1;
                }
                break;
            case 54:
                {
                alt23=2;
                }
                break;
            case 55:
                {
                alt23=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 23, 0, input);

                throw nvae;
            }

            switch (alt23) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:688:4: 'int'
                    {
                    match(input,53,FOLLOW_53_in_type1757); 
                     retval.returnType = templateLib.getInstanceOf("return_int"); 


                    // TEMPLATE REWRITE
                    // 688:43: -> type_int()
                    {
                        retval.st = templateLib.getInstanceOf("type_int");
                    }


                    }
                    break;
                case 2 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:689:4: 'float'
                    {
                    match(input,54,FOLLOW_54_in_type1770); 
                     retval.returnType = templateLib.getInstanceOf("return_float"); 


                    // TEMPLATE REWRITE
                    // 689:47: -> type_float()
                    {
                        retval.st = templateLib.getInstanceOf("type_float");
                    }


                    }
                    break;
                case 3 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:690:4: 'boolean'
                    {
                    match(input,55,FOLLOW_55_in_type1783); 
                     retval.returnType = templateLib.getInstanceOf("return_int"); 


                    // TEMPLATE REWRITE
                    // 690:47: -> type_boolean()
                    {
                        retval.st = templateLib.getInstanceOf("type_boolean");
                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "type"

    public static class boolean_literal_return extends ParserRuleReturnScope {
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "boolean_literal"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:693:1: boolean_literal : ( 'true' -> { new StringTemplate(\"1\") } | 'false' -> { new StringTemplate(\"0\") });
    public final AlLanguageParser.boolean_literal_return boolean_literal() throws RecognitionException {
        AlLanguageParser.boolean_literal_return retval = new AlLanguageParser.boolean_literal_return();
        retval.start = input.LT(1);

        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:694:2: ( 'true' -> { new StringTemplate(\"1\") } | 'false' -> { new StringTemplate(\"0\") })
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==56) ) {
                alt24=1;
            }
            else if ( (LA24_0==57) ) {
                alt24=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }
            switch (alt24) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:694:4: 'true'
                    {
                    match(input,56,FOLLOW_56_in_boolean_literal1802); 


                    // TEMPLATE REWRITE
                    // 694:11: -> { new StringTemplate(\"1\") }
                    {
                        retval.st =  new StringTemplate("1") ;
                    }


                    }
                    break;
                case 2 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:695:4: 'false'
                    {
                    match(input,57,FOLLOW_57_in_boolean_literal1811); 


                    // TEMPLATE REWRITE
                    // 695:12: -> { new StringTemplate(\"0\") }
                    {
                        retval.st =  new StringTemplate("0") ;
                    }


                    }
                    break;

            }
            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "boolean_literal"

    public static class arg_call_return extends ParserRuleReturnScope {
        public List<String> types;
        public List<StringTemplate> stTypes;
        public List<StringTemplate> stList;
        public StringTemplate st;
        public Object getTemplate() { return st; }
        public String toString() { return st==null?null:st.toString(); }
    };

    // $ANTLR start "arg_call"
    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:698:1: arg_call returns [List<String> types, List<StringTemplate> stTypes, List<StringTemplate> stList] : (first= expression ( ',' second= expression )* )? ;
    public final AlLanguageParser.arg_call_return arg_call() throws RecognitionException {
        AlLanguageParser.arg_call_return retval = new AlLanguageParser.arg_call_return();
        retval.start = input.LT(1);

        AlLanguageParser.expression_return first = null;

        AlLanguageParser.expression_return second = null;



            retval.types = new ArrayList<String>();
            retval.stList = new ArrayList<StringTemplate>();

        try {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:704:2: ( (first= expression ( ',' second= expression )* )? )
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:704:4: (first= expression ( ',' second= expression )* )?
            {
            // G:\\Compiller\\src\\language\\al\\AlLanguage.g:704:4: (first= expression ( ',' second= expression )* )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==IDENT||(LA26_0>=INT && LA26_0<=FLOAT)||LA26_0==25||LA26_0==37||LA26_0==40||(LA26_0>=51 && LA26_0<=52)||(LA26_0>=56 && LA26_0<=57)) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:704:6: first= expression ( ',' second= expression )*
                    {
                    pushFollow(FOLLOW_expression_in_arg_call1839);
                    first=expression();

                    state._fsp--;


                                if ((first!=null?first.type:null) != null)
                                {
                                    retval.types.add((first!=null?first.type:null));
                                    retval.stList.add((first!=null?first.st:null));
                                }
                            
                    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:712:11: ( ',' second= expression )*
                    loop25:
                    do {
                        int alt25=2;
                        int LA25_0 = input.LA(1);

                        if ( (LA25_0==27) ) {
                            alt25=1;
                        }


                        switch (alt25) {
                    	case 1 :
                    	    // G:\\Compiller\\src\\language\\al\\AlLanguage.g:712:13: ',' second= expression
                    	    {
                    	    match(input,27,FOLLOW_27_in_arg_call1863); 
                    	    pushFollow(FOLLOW_expression_in_arg_call1867);
                    	    second=expression();

                    	    state._fsp--;


                    	                if ((second!=null?second.type:null) != null) {
                    	                    retval.types.add((second!=null?second.type:null));
                    	                    retval.stList.add((second!=null?second.st:null));
                    	                }
                    	            

                    	    }
                    	    break;

                    	default :
                    	    break loop25;
                        }
                    } while (true);


                    }
                    break;

            }


            }

            retval.stop = input.LT(-1);

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return retval;
    }
    // $ANTLR end "arg_call"

    // Delegated rules


    protected DFA7 dfa7 = new DFA7(this);
    static final String DFA7_eotS =
        "\14\uffff";
    static final String DFA7_eofS =
        "\14\uffff";
    static final String DFA7_minS =
        "\1\4\1\27\12\uffff";
    static final String DFA7_maxS =
        "\1\45\1\34\12\uffff";
    static final String DFA7_acceptS =
        "\2\uffff\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\12\1\1\1\2";
    static final String DFA7_specialS =
        "\14\uffff}>";
    static final String[] DFA7_transitionS = {
            "\1\1\30\uffff\1\2\1\3\1\4\1\uffff\1\5\1\6\1\7\1\10\1\11",
            "\1\13\4\uffff\1\12",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            ""
    };

    static final short[] DFA7_eot = DFA.unpackEncodedString(DFA7_eotS);
    static final short[] DFA7_eof = DFA.unpackEncodedString(DFA7_eofS);
    static final char[] DFA7_min = DFA.unpackEncodedStringToUnsignedChars(DFA7_minS);
    static final char[] DFA7_max = DFA.unpackEncodedStringToUnsignedChars(DFA7_maxS);
    static final short[] DFA7_accept = DFA.unpackEncodedString(DFA7_acceptS);
    static final short[] DFA7_special = DFA.unpackEncodedString(DFA7_specialS);
    static final short[][] DFA7_transition;

    static {
        int numStates = DFA7_transitionS.length;
        DFA7_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA7_transition[i] = DFA.unpackEncodedString(DFA7_transitionS[i]);
        }
    }

    class DFA7 extends DFA {

        public DFA7(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 7;
            this.eot = DFA7_eot;
            this.eof = DFA7_eof;
            this.min = DFA7_min;
            this.max = DFA7_max;
            this.accept = DFA7_accept;
            this.special = DFA7_special;
            this.transition = DFA7_transition;
        }
        public String getDescription() {
            return "216:1: stmt : ( assign_stmt ';' -> { $assign_stmt.st } | declaration_stmt ';' -> { $declaration_stmt.st } | write_stmt ';' -> { $write_stmt.st } | read_stmt ';' -> { $read_stmt.st } | if_stmt -> { $if_stmt.st } | for_stmt -> { $for_stmt.st } | while_stmt -> { $while_stmt.st } | do_while_stmt ';' -> { $do_while_stmt.st } | return_stmt ';' -> { $return_stmt.st } | procedure_call_stmt ';' -> { $procedure_call_stmt.st });";
        }
    }
 

    public static final BitSet FOLLOW_global_variables_in_prog57 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_procedure_in_prog62 = new BitSet(new long[]{0x0000000001040000L});
    public static final BitSet FOLLOW_program_in_prog69 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_prog71 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_program123 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_program125 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_block_in_program127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_global_variables159 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_global_variables161 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_global_declaration_in_global_variables165 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_global_variables169 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_22_in_global_variables174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_global_declaration194 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_global_declaration196 = new BitSet(new long[]{0x00E0000000000000L});
    public static final BitSet FOLLOW_type_in_global_declaration200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_procedure253 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_procedure257 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_procedure259 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_arg_list_in_procedure263 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_procedure265 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_procedure267 = new BitSet(new long[]{0x00E0000000000000L});
    public static final BitSet FOLLOW_type_in_procedure271 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_block_in_procedure291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_arg_list363 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_arg_list365 = new BitSet(new long[]{0x00E0000000000000L});
    public static final BitSet FOLLOW_type_in_arg_list370 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_arg_list394 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_arg_list398 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_arg_list400 = new BitSet(new long[]{0x00E0000000000000L});
    public static final BitSet FOLLOW_type_in_arg_list404 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_20_in_block452 = new BitSet(new long[]{0x0000003EE0400010L});
    public static final BitSet FOLLOW_stmt_in_block455 = new BitSet(new long[]{0x0000003EE0400010L});
    public static final BitSet FOLLOW_22_in_block461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_assign_stmt_in_stmt472 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_stmt474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_declaration_stmt_in_stmt483 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_stmt485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_write_stmt_in_stmt494 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_stmt496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_read_stmt_in_stmt505 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_stmt507 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_if_stmt_in_stmt516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_for_stmt_in_stmt525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_while_stmt_in_stmt534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_do_while_stmt_in_stmt543 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_stmt545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_return_stmt_in_stmt554 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_stmt556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_procedure_call_stmt_in_stmt572 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_stmt574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_assign_stmt591 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_assign_stmt595 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_expression_in_assign_stmt599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_declaration_stmt622 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_declaration_stmt624 = new BitSet(new long[]{0x00E0000000000000L});
    public static final BitSet FOLLOW_type_in_declaration_stmt628 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_write_stmt649 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_write_stmt651 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_expression_in_write_stmt655 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_write_stmt657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_write_stmt679 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_write_stmt681 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_STRING_in_write_stmt685 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_write_stmt687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_read_stmt707 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_read_stmt709 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_read_stmt713 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_read_stmt715 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_if_stmt738 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_if_stmt740 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_expression_in_if_stmt744 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_if_stmt746 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_block_in_if_stmt750 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_32_in_if_stmt754 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_block_in_if_stmt758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_for_stmt784 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_for_stmt786 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_assign_stmt_in_for_stmt790 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_for_stmt792 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_expression_in_for_stmt796 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_for_stmt798 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_assign_stmt_in_for_stmt802 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_for_stmt804 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_block_in_for_stmt808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_while_stmt831 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_while_stmt833 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_expression_in_while_stmt837 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_while_stmt839 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_block_in_while_stmt843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_do_while_stmt866 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_block_in_do_while_stmt870 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_34_in_do_while_stmt872 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_do_while_stmt874 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_expression_in_do_while_stmt878 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_do_while_stmt880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_return_stmt903 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_expression_in_return_stmt907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_procedure_call_in_procedure_call_stmt948 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_procedure_call987 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_IDENT_in_procedure_call991 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_procedure_call994 = new BitSet(new long[]{0x0318013EE60000D0L});
    public static final BitSet FOLLOW_arg_call_in_procedure_call998 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_procedure_call1000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_and_expression_in_expression1037 = new BitSet(new long[]{0x0000004000000002L});
    public static final BitSet FOLLOW_38_in_expression1045 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_expression_in_expression1049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_not_expression_in_and_expression1089 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_and_expression1096 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_and_expression_in_and_expression1100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_not_expression1140 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_not_expression_in_not_expression1144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_comparison_in_not_expression1161 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_math_expression_in_comparison1190 = new BitSet(new long[]{0x00001E0000000002L});
    public static final BitSet FOLLOW_41_in_comparison1207 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_42_in_comparison1213 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_43_in_comparison1219 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_44_in_comparison1225 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_math_expression_in_comparison1230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mult_in_math_expression1270 = new BitSet(new long[]{0x0000600000000002L});
    public static final BitSet FOLLOW_45_in_math_expression1279 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_46_in_math_expression1285 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_math_expression_in_math_expression1290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_mod_in_mult1330 = new BitSet(new long[]{0x0001800000000002L});
    public static final BitSet FOLLOW_47_in_mult1338 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_48_in_mult1344 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_mult_in_mult1349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_pow_in_mod1395 = new BitSet(new long[]{0x0002000000000002L});
    public static final BitSet FOLLOW_49_in_mod1401 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_pow_in_mod1405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_convert_type_in_pow1452 = new BitSet(new long[]{0x0004000000000002L});
    public static final BitSet FOLLOW_50_in_pow1460 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_convert_type_in_pow1464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_convert_type1511 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_convert_type1513 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_atom_in_convert_type1515 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_convert_type1517 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_convert_type1558 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_convert_type1560 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_atom_in_convert_type1562 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_convert_type1564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_atom_in_convert_type1603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_IDENT_in_atom1640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_INT_in_atom1655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_FLOAT_in_atom1673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_atom1691 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_expression_in_atom1695 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_atom1697 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_boolean_literal_in_atom1708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_procedure_call_in_atom1728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_type1757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_type1770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_type1783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_boolean_literal1802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_boolean_literal1811 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_expression_in_arg_call1839 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_arg_call1863 = new BitSet(new long[]{0x0318013EE20000D0L});
    public static final BitSet FOLLOW_expression_in_arg_call1867 = new BitSet(new long[]{0x0000000008000002L});

}