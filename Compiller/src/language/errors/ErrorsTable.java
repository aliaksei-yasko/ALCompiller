/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package language.errors;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Admin
 */
public class ErrorsTable {
    private List<Error> errorsList;
    private static ErrorsTable errorsTable;

    private ErrorsTable() {
        errorsList = new ArrayList<Error>();
    }

    public static ErrorsTable getInstance() {
        if (errorsTable == null) {
            errorsTable = new ErrorsTable();
        }

        return errorsTable;
    }

    public void addError(String errorMessage, int errorLine) {
        Error error = new Error(errorMessage, errorLine);
        errorsList.add(error);
    }

    public void addError(Error error) {
        errorsList.add(error);
    }

    public List<Error> getErrorsList() {
        return errorsList;
    }

    public void printErrors(PrintStream out) {
        for (Error error : errorsList) {
            out.println(error.toString());
        }
    }
}
