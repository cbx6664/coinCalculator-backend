package com.cbx.coinservice.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * ClassName: CoinCalculator
 * Package: com.cbx.coinservice.core
 * Description:
 *
 * @Author CBX
 * @Create 4/1/25 18:37
 * @Version 1.0
 */


public class CoinCalculator {

    public List<Double> calculateMinimumCoins(double target, List<Double> denominations) {
        // 校验目标金额范围
        if (target < 0 || target > 10000) {
            throw new IllegalArgumentException("Target amount must be within the range between 0 and 10,000.00.");
        }

        // 校验硬币面额是否合法
        List<Double> validDenominations = List.of(0.01, 0.05, 0.1, 0.2, 0.5, 1.0, 2.0, 5.0, 10.0, 50.0, 100.0, 1000.0);
        for (double coin : denominations) {
            if (!validDenominations.contains(coin)) {
                throw new IllegalArgumentException("Invalid coin denomination: " + coin);
            }
        }

        // 确保硬币面额有序（降序排列，用于贪心算法）
        List<Double> sortedDenominations = new ArrayList<>(denominations);
        Collections.sort(sortedDenominations, Collections.reverseOrder());

        // 计算最小硬币组合
        List<Double> result = new ArrayList<>();
        target = Math.round(target * 100.0) / 100.0; // 避免浮点运算误差

        for (double coin : sortedDenominations) {
            while (target >= coin) {
                target = Math.round((target - coin) * 100.0) / 100.0;
                result.add(coin);
            }
        }

        // 如果目标金额无法被完全兑换
        if (target != 0) {
            throw new IllegalArgumentException("Cannot achieve target amount with the given denominations.");
        }

        // 返回结果按升序排列
        Collections.sort(result);
        return result;
    }

}
