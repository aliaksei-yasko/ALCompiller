/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package language.namestable;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alex
 */
public class NamesTable {
    private Map<String, Var> vars = new HashMap<String, Var>();
    private Map<String, Procedure> procedures = new HashMap<String, Procedure>();
    private NamesTable parentTable;

    public boolean isExistInThisBlock(String varName) {
        boolean isCount = vars.containsKey(varName);
        return isCount;
    }

    public boolean isExistInAll(String varName) {
        boolean isCount = this.isExistInThisBlock(varName);
        if (!isCount) {
            if (parentTable == null) {
                return false;
            } else {
                isCount = parentTable.isExistInAll(varName);
                return isCount;
            }
        }
        return isCount;
    }

    public boolean isProcedureDeclarated(String procedureName) {
        boolean isDeclarated = procedures.containsKey(procedureName);
        return isDeclarated;
    }

    public void addProcedure(Procedure procedure) {
        procedures.put(procedure.getProcedureName(), procedure);
    }

    public Procedure getProcedure(String procedureName) {
        return procedures.get(procedureName);
    }

    public void addVar(Var var) {
        vars.put(var.getIdent(), var);
    }

    public Var getVar(String aIdent) {
        Var var = vars.get(aIdent);
        if (var == null) {
            if (parentTable == null) {
                return null;
            } else {
                var = parentTable.getVar(aIdent);
                return var;
            }
        }
        return var;
    }

    public List<Var> getVars() {
        return new ArrayList<Var>(vars.values());
    }

    public List<Procedure> getProcedures() {
         return new ArrayList<Procedure>(procedures.values());
    }
    
    public void print(PrintStream out) {
        for (String ident : vars.keySet()) {
            Var var = vars.get(ident);
            out.println(var);
        }
        for (String ident : procedures.keySet()) {
            Procedure procedere = procedures.get(ident);
            out.println(procedere);
        }
    }

    public void setParentTable(NamesTable table) {
        this.parentTable = table;
    }

    public NamesTable getParentTable() {
        return this.parentTable;
    }

}
 