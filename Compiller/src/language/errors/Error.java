/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package language.errors;

/**
 *
 * @author Admin
 */
public class Error {
    private String errorMessage;
    private int errorLine;

    public Error(String errorMessage, int errorLine) {
        this.errorLine = errorLine;
        this.errorMessage = errorMessage;
    }

    public int getErrorLine() {
        return errorLine;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "line " + Integer.toString(errorLine) + " :" + errorMessage;
    }
}
