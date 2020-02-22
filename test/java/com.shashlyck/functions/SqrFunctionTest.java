package com.shashlyck.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrFunctionTest {

    @Test
    void apply() {
        SqrFunction firstNumber = new SqrFunction();
        assertEquals(firstNumber.apply(2), 4, 0.1);
    }
}