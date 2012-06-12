/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package language.namestable;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class Procedure {
    private String procedureName = "";
    private List<Var> procedureArgs = new ArrayList<Var>();
    private String returnType = "";
    private int lineDeclaration = 0;

    public Procedure(String functionName, List<Var> args, String returnType, int lineDeclaration) {
        if (args != null) {
            this.procedureArgs = args;
        }
        this.procedureName = functionName;
        this.returnType = returnType;
        this.lineDeclaration = lineDeclaration;
    }

    public String getProcedureName() {
        return this.procedureName;
    }

    public int getLineDeclaration() {
        return this.lineDeclaration;
    }

    public String getReturnType() {
        return returnType;
    }

    public List<Var> getProcedureArgs() {
        return this.procedureArgs;
    }

    @Override
    public String toString() {
        return "line " + this.lineDeclaration + " - " + "procedure : " + procedureName
                + ", args : " + procedureArgs.toString() + ", return type : " + returnType;
    }
}
