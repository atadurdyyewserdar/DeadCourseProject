package javaapplication5.Classes;

import java.math.BigDecimal;

public class ConvertMoney {

    public static BigDecimal usd_to_byn(BigDecimal bigDecimal) {
        if (bigDecimal.equals(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        return bigDecimal.multiply(new BigDecimal("2.09"));
    }

    public static BigDecimal byn_to_eur(BigDecimal bigDecimal) {
        if (bigDecimal.equals(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        return bigDecimal.multiply(new BigDecimal("0.42"));
    }

    public static BigDecimal usd_to_eur(BigDecimal bigDecimal) {
        if (bigDecimal.equals(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        return bigDecimal.multiply(new BigDecimal("0.89"));
    }

    public static BigDecimal eur_to_usd(BigDecimal bigDecimal) {
        if (bigDecimal.equals(BigDecimal.ZERO)) {
            return BigDecimal.ZERO;
        }
        return bigDecimal.multiply(new BigDecimal("1.11"));
    }
}
