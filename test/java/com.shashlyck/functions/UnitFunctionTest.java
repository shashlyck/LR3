package com.shashlyck.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitFunctionTest {

    @Test
    void apply() {
        UnitFunction firstNumber = new UnitFunction();
        assertEquals(firstNumber.apply(1295.2), 1.00, 0.1);
    }
}