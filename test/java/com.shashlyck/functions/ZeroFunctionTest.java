package com.shashlyck.functions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ZeroFunctionTest {

    @Test
    void apply() {

        ZeroFunction firstNumber = new ZeroFunction();
        assertEquals(firstNumber.apply(1295.2), 0, 0.1);
    }
}