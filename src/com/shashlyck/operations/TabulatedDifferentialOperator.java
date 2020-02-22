package com.shashlyck.operations;

import com.shashlyck.functions.Point;
import com.shashlyck.functions.TabulatedFunction;
import com.shashlyck.functions.factory.TabulatedFunctionFactory;

public class TabulatedDifferentialOperator implements DifferentialOperator<TabulatedFunction> {

    TabulatedFunctionFactory functionFactory;

    @Override
    public TabulatedFunction derive(TabulatedFunction function) {
        Point[] arrayPoint = TabulatedFunctionOperationService.asPoints(function);
        double[] xValues = new double[function.getCount()];
        double[] yValues = new double[function.getCount()];

        for (int k = 0; k < xValues.length - 1; k++) {
            yValues[k] = (arrayPoint[k + 1].y - arrayPoint[k].y) / (arrayPoint[k + 1].x - arrayPoint[k].x);
            xValues[k] = arrayPoint[k].x;
        }
        xValues[xValues.length - 1] = arrayPoint[xValues.length - 1].x;
        yValues[yValues.length - 1] = yValues[yValues.length - 2];

        return functionFactory.create(xValues, yValues);
    }
}
