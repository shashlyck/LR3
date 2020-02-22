package com.shashlyck.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ConstantFunctionTest {

    @Test
    void apply() {
        ConstantFunction firstNumber = new ConstantFunction(10.5);
        assertEquals(firstNumber.apply(7), 10.5, 1.5);
    }
}