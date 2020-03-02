package javaapplication5.Classes;

import java.math.BigInteger;

public class Convertor {

    public static boolean isDouble(String str) {
        if (str == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    public static boolean isInteger(String str) {
        if (str == null) {
            return false;
        }
        try {
            int d = Integer.parseInt(str);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }

    public static boolean isLong(String str) {
        if (str == null) {
            return false;
        }
        try {
            long bi = Long.parseLong(str);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}
