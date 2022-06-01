package com.app.calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CalculatorTest {
    Calculator calculator = new Calculator();

    @Test
    public void canAdd(){
        Assertions.assertEquals(5, calculator.add(2,3));
    }

    @Test
    public void canSub(){
        Assertions.assertEquals(2, calculator.sub(5,3));
    }

    @Test
    public void canMul(){
        Assertions.assertEquals(6, calculator.mul(2,3));
    }

    @Test
    public void canDiv(){
        Assertions.assertEquals(3, calculator.div(9,3));
    }

}