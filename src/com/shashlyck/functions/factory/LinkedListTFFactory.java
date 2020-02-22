package com.shashlyck.functions.factory;

import com.shashlyck.functions.LinkedListTabulatedFunction;
import com.shashlyck.functions.MathFunction;
import com.shashlyck.functions.TabulatedFunction;

public class LinkedListTFFactory implements TabulatedFunctionFactory {

    @Override
    public TabulatedFunction create(double[] xValues, double[] yValues) {
        return new LinkedListTabulatedFunction(xValues, yValues);
    }

    @Override
    public TabulatedFunction create(MathFunction source, double xFrom, double xTo, int count) {
        return new LinkedListTabulatedFunction(source, xFrom, xTo, count);
    }
}
