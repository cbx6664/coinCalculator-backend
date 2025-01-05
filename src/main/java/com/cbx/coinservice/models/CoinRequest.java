package com.cbx.coinservice.models;

import java.util.List;

/**
 * ClassName: CoinRequest
 * Package: com.cbx.coinservice.models
 * Description:
 *
 * @Author CBX
 * @Create 4/1/25 18:12
 * @Version 1.0
 */
public class CoinRequest {
    private double targetAmount;
    private List<Double> coinDenominations;

    public double getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(double targetAmount) {
        this.targetAmount = targetAmount;
    }

    public List<Double> getCoinDenominations() {
        return coinDenominations;
    }

    public void setCoinDenominations(List<Double> coinDenominations) {
        this.coinDenominations = coinDenominations;
    }
}
