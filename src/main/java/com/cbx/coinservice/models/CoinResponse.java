package com.cbx.coinservice.models;

import java.util.List;

/**
 * ClassName: CoinResponse
 * Package: com.cbx.coinservice.models
 * Description:
 *
 * @Author CBX
 * @Create 4/1/25 18:13
 * @Version 1.0
 */
public class CoinResponse {
    private List<Double> coins;

    public CoinResponse(List<Double> coins) {
        this.coins = coins;
    }

    public List<Double> getCoins() {
        return coins;
    }

    public void setCoins(List<Double> coins) {
        this.coins = coins;
    }
}
