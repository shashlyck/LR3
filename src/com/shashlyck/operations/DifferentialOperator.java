package com.shashlyck.operations;

import com.shashlyck.functions.MathFunction;

public interface DifferentialOperator<M extends MathFunction> {
    M derive(M function);
}
