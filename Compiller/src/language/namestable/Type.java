/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package language.namestable;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Admin
 */
public class Type {
    public static final Map<String, String> jvmTypes = new HashMap<String, String>();
    
    public static final String INT = "int";
    public static final String FLOAT = "float";
    public static final String BOOLEAN = "boolean";
    public static final String ERROR = "error";

    static {
        jvmTypes.put("int", "I");
        jvmTypes.put("float", "F");
        jvmTypes.put("boolean", "B");
    }
}
