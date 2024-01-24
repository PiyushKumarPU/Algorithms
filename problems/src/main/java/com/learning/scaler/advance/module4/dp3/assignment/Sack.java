package com.learning.scaler.advance.module4.dp3.assignment;

public class Sack {
    public Integer profit;
    public Integer weight;
    public Double unitPrice;

    public Sack(Integer profit, Integer weight) {
        this.profit = profit;
        this.weight = weight;
        this.unitPrice = profit / (double) weight;
    }
}
