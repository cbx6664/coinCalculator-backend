package com.cbx.coinservice.health;

import com.codahale.metrics.health.HealthCheck;

/**
 * ClassName: CoinHealthCheck
 * Package: com.cbx.coinservice.health
 * Description:
 *
 * @Author CBX
 * @Create 4/1/25 18:35
 * @Version 1.0
 */
public class CoinHealthCheck extends HealthCheck {

    @Override
    protected Result check() throws Exception {
        return Result.healthy("CoinService is healthy");
    }
}