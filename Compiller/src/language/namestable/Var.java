/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package language.namestable;

/**
 *
 * @author Admin
 */
public class Var {
    private String ident;
    private String type;
    private int lineDeclaration;
    private int variableNumber = 1;
    private boolean isGlobal = false;

    public Var(String aIdent, String aType, int line) {
        this.ident = aIdent;
        this.type = aType;
        this.lineDeclaration = line;
    }

    @Override
    public String toString() {
        return "line " + this.lineDeclaration + " - " + ident + " : " + type;
    }

    public boolean isGlobal() {
        return isGlobal;
    }

    public void setIsGlobal(boolean isGlobal) {
        this.isGlobal = isGlobal;
    }

    public int getVariableNumber() {
        return variableNumber;
    }

    public void setVariableNumber(int variableNumber) {
        this.variableNumber = variableNumber;
    }


    public String getType() {
        return type;
    }

    public String getIdent() {
        return this.ident;
    }

    public int getLineDeclaration() {
        return this.lineDeclaration;
    }

}
