package com.shashlyck.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqrRootFunctionTest {

    @Test
    void apply() {
        SqrRootFunction firstNumber = new SqrRootFunction();
        assertEquals(firstNumber.apply(64), 8, 0.01);
    }
}