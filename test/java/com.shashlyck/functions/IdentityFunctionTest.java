package com.shashlyck.functions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IdentityFunctionTest {

    @Test
    void apply() {
        IdentityFunction firstNumber = new IdentityFunction();
        assertEquals(firstNumber.apply(8), 8, 0.01);
    }
}