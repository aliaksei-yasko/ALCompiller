/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package language.namestable;

/**
 *
 * @author Q-YAA
 */
public class TypesChecker {

    public static boolean checkTypes(String firstType, String secondType) {
        if (firstType == null || secondType == null) {
            return false;
        }
        if (firstType.equals(secondType)) {
            return true;
        } else {
            return false;
        }
    }

    public static String getWrongMessage(String operator) {
        return " wrong type for the operator \"" + operator + "\".";
    }

    public static String getPowResultType(String firstType, String secondType) {
        if (!checkTypes(firstType, secondType)) {
            return Type.ERROR;
        }
        if (isBothFloat(firstType, secondType)) {
            return Type.FLOAT;
        } else if (isBothInt(firstType, secondType)) {
            return Type.INT;
        } else {
            return Type.ERROR;
        }
    }

    public static String getComparisonResultType(String firstType, String secondType) {
        if (!checkTypes(firstType, secondType)) {
            return Type.ERROR;
        }
        if (isSomeBoolean(firstType, secondType)) {
            return Type.ERROR;
        } else {
            return Type.BOOLEAN;
        }
    }

    public static String getLogicResultType(String firstType, String secondType) {
        if (!checkTypes(firstType, secondType)) {
            return Type.ERROR;
        }
        if (isBothBoolean(firstType, secondType)) {
            return Type.BOOLEAN;
        } else {
            return Type.ERROR;
        }
    }

    public static String getModResultType(String firstType, String secondType) {
        if (!checkTypes(firstType, secondType)) {
            return Type.ERROR;
        }
        if (isBothFloat(firstType, secondType)) {
            return Type.FLOAT;
        } else if (isBothInt(firstType, secondType)) {
            return Type.INT;
        } else {
            return Type.ERROR;
        }
    }

    public static String getDivResultType(String firstType, String secondType) {
        if (!checkTypes(firstType, secondType)) {
            return Type.ERROR;
        }
        if (isSomeBoolean(firstType, secondType)) {
            return Type.ERROR;
        } else {
            return Type.FLOAT;
        }
    }

    public static String getSumResultType(String firstType, String secondType) {
        if (!checkTypes(firstType, secondType)) {
            return Type.ERROR;
        }
        if (isBothFloat(firstType, secondType)) {
            return Type.FLOAT;
        } else if (isBothInt(firstType, secondType)) {
            return Type.INT;
        } else {
            return Type.ERROR;
        }
    }

    public static String getMultResultType(String firstType, String secondType) {
        if (!checkTypes(firstType, secondType)) {
            return Type.ERROR;
        }
        if (isBothFloat(firstType, secondType)) {
            return Type.FLOAT;
        } else if (isBothInt(firstType, secondType)) {
            return Type.INT;
        } else {
            return Type.ERROR;
        }
    }


    public static boolean isBoolean(String type) {
        if (type == null) {
            return false;
        }
        if (type.equals(Type.BOOLEAN)) {
            return true;
        }

        return false;
    }

    public static boolean isInt(String type) {
        if (type == null) {
            return false;
        }
        if (type.equals(Type.INT)) {
            return true;
        }

        return false;
    }

    public static boolean isFloat(String type) {
        if (type == null) {
            return false;
        }
        if (type.equals(Type.FLOAT)) {
            return true;
        }

        return false;
    }

    public static boolean isBothInt(String firstType, String secondType) {
        if (isInt(firstType)&& isInt(secondType)) {
            return true;
        }

        return false;
    }

    public static boolean isBothFloat(String firstType, String secondType) {
        if (isFloat(firstType) && isFloat(secondType)) {
            return true;
        }

        return false;
    }

    public static boolean isBothBoolean(String firstType, String secondType) {
        if (isBoolean(firstType) && isBoolean(secondType)) {
            return true;
        }

        return false;
    }

    public static boolean isSomeBoolean(String firstType, String secondType) {
        if (isBoolean(firstType) || isBoolean(secondType)) {
            return true;
        }

        return false;
    }

    public static boolean isSomeInt(String firstType, String secondType) {
        if (isInt(firstType) || isInt(secondType)) {
            return true;
        }

        return false;
    }

     public static boolean isSomeFloat(String firstType, String secondType) {
        if (isFloat(firstType) || isFloat(secondType)) {
            return true;
        }

        return false;
    }
}
