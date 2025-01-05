package com.cbx.coinservice.core;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * ClassName: CoinCalculatorTest
 * Package: com.cbx.coinservice.core
 * Description:
 *
 * @Author CBX
 * @Create 5/1/25 16:40
 * @Version 1.0
 */
class CoinCalculatorTest {
    private final CoinCalculator calculator = new CoinCalculator();

    @Test
    void testCalculateMinimumCoins_ValidInput() {
        List<Double> denominations = Arrays.asList(0.01, 0.05, 0.1, 1.0, 5.0);
        double target = 11.56;
        List<Double> expected = Arrays.asList(0.01, 0.05, 0.1, 0.1, 0.1, 0.1, 0.1, 1.0, 5.0, 5.0);

        List<Double> result = calculator.calculateMinimumCoins(target, denominations);

        assertEquals(expected, result);
    }

    @Test
    void testCalculateMinimumCoins_InvalidTarget() {
        List<Double> denominations = Arrays.asList(0.01, 0.05, 0.1, 0.25, 1.0, 5.0);

        Executable executable = () -> calculator.calculateMinimumCoins(-1, denominations);
        assertThrows(IllegalArgumentException.class, executable);

        executable = () -> calculator.calculateMinimumCoins(10001, denominations);
        assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    void testCalculateMinimumCoins_InvalidDenomination() {
        List<Double> denominations = Arrays.asList(0.01, 0.05, 0.1, 0.25, 1.0, 3.0);

        Executable executable = () -> calculator.calculateMinimumCoins(10, denominations);
        assertThrows(IllegalArgumentException.class, executable);
    }

    @Test
    void testCalculateMinimumCoins_UnachievableTarget() {
        List<Double> denominations = Arrays.asList(0.05, 0.1, 0.25, 1.0, 5.0);
        double target = 0.03;

        Executable executable = () -> calculator.calculateMinimumCoins(target, denominations);
        assertThrows(IllegalArgumentException.class, executable);
    }

}