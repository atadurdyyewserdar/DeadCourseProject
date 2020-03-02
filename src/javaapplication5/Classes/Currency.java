package javaapplication5.Classes;

import java.math.BigDecimal;

public class Currency {

    private String id;

    private BigDecimal rate;

    public Currency() {
        id = "USD";
        rate = BigDecimal.ZERO;
    }

    public Currency(String id, BigDecimal rate) {
        this.id = id;
        this.rate = rate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }
}
