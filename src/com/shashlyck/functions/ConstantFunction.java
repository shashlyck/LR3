package com.shashlyck.functions;

public class ConstantFunction implements MathFunction{

    private double constant;

    public ConstantFunction(double constant) {
        this.constant = constant;
    }

    @Override
    public double apply(double x) {
        return constant;
    }
}
