package com.shashlyck.functions;

public class SqrRootFunction implements MathFunction {
    @Override
    public double apply(double x) {
        return Math.sqrt(x);
    }
}
