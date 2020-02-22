package com.shashlyck.functions.factory;

import com.shashlyck.functions.ArrayTabulatedFunction;
import com.shashlyck.functions.MathFunction;
import com.shashlyck.functions.TabulatedFunction;

public class ArrayTFFactory implements TabulatedFunctionFactory{

    @Override
    public TabulatedFunction create(double[] xValues, double[] yValues) {
        return new ArrayTabulatedFunction(xValues, yValues);
    }

    @Override
    public TabulatedFunction create(MathFunction source, double xFrom, double xTo, int count) {
        return new ArrayTabulatedFunction(source, xFrom, xTo, count);
    }
}
