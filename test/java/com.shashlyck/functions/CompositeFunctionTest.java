package com.shashlyck.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompositeFunctionTest {

    @Test
    void apply() {
        MathFunction firstFunction = new IdentityFunction();
        MathFunction secondFunction = new ConstantFunction(2);
        MathFunction function = new CompositeFunction(firstFunction, secondFunction);
        assertEquals(function.apply(2), 3.76, 0.01);
        double[] xValues = new double[]{1, 3, 4};
        double[] yValues = new double[]{2, 1, 3};

        MathFunction thirdFunction= new SqrFunction();
        MathFunction array = new ArrayTabulatedFunction(xValues, yValues);
        assertEquals(array.apply(2), 1.5, 0.1);
        assertEquals(thirdFunction.apply(1.5), 2.25, 0.01);
        assertEquals(array.apply(2), 2.25, 0.1);

        MathFunction list = new LinkedListTabulatedFunction(xValues, yValues);
        assertEquals(list.apply(2), 1.5, 0.1);
        assertEquals(secondFunction.apply(1.5), 2.35, 0.01);
        assertEquals(list.apply(2), 2.35, 0.1);
    }
}