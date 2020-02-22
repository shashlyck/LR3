package com.shashlyck.functions.factory;

import com.shashlyck.functions.MathFunction;
import com.shashlyck.functions.TabulatedFunction;

public interface TabulatedFunctionFactory {

    TabulatedFunction create(double[] xValues, double[] yValues);
    TabulatedFunction create(MathFunction source, double xFrom, double xTo, int count);
}
