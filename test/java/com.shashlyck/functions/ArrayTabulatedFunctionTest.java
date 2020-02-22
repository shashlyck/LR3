package com.shashlyck.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTabulatedFunctionTest {
    private double[] xValues = new double[]{1., 4., 7., 10., 13.};
    private double[] yValues = new double[]{4., 6., 8., 10., 12.};

    private double PRECISION = 0.1;
    private MathFunction Function = new SqrFunction();

    private ArrayTabulatedFunction initializeUsingTwoArrays() {
        return new ArrayTabulatedFunction(xValues, yValues);
    }

    private ArrayTabulatedFunction initializeUsingMathFunction() {
        return new ArrayTabulatedFunction(Function, 10, 0, 11);
    }

    @Test
    void getCount() {

        ArrayTabulatedFunction firstNumber = initializeUsingTwoArrays();
        assertEquals(firstNumber.getCount(), 5, PRECISION);
        ArrayTabulatedFunction secondNumber = initializeUsingMathFunction();
        assertEquals(secondNumber.getCount(), 11, PRECISION);
    }

    @Test
    void getX() {
        ArrayTabulatedFunction firstNumber = initializeUsingTwoArrays();
        assertEquals(firstNumber.getX(1), 4, PRECISION);
        ArrayTabulatedFunction secondNumber = initializeUsingMathFunction();
        assertEquals(secondNumber.getX(2), 2, PRECISION);
        for (int i = 0; i < 5; i++) {
            assertEquals(firstNumber.getX(i), 1 + 3 * i, PRECISION);
        }

        assertEquals(firstNumber.getX(0), 1, PRECISION);
    }

    @Test
    void getY() {
        ArrayTabulatedFunction firstNumber = initializeUsingTwoArrays();
        assertEquals(firstNumber.getY(0), 4, PRECISION);
        ArrayTabulatedFunction secondNumber = initializeUsingMathFunction();
        assertEquals(secondNumber.getY(3), 9, PRECISION);
    }

    @Test
    void setY() {
        ArrayTabulatedFunction firstNumber = initializeUsingTwoArrays();
        firstNumber.setY(3, 16);
        assertEquals(firstNumber.getY(3), 16, PRECISION);
        ArrayTabulatedFunction secondNumber = initializeUsingMathFunction();
        secondNumber.setY(7, 3);
        assertEquals(secondNumber.getY(7), 3, PRECISION);
    }

    @Test
    void leftBound() {
        ArrayTabulatedFunction firstNumber = initializeUsingTwoArrays();
        assertEquals(firstNumber.leftBound(), 1, PRECISION);
        ArrayTabulatedFunction secondNumber = initializeUsingMathFunction();
        assertEquals(secondNumber.leftBound(), 0, PRECISION);
    }

    @Test
    void rightBound() {
        ArrayTabulatedFunction firstNumber = initializeUsingTwoArrays();
        assertEquals(firstNumber.rightBound(), 13, PRECISION);
        ArrayTabulatedFunction secondNumber = initializeUsingMathFunction();
        assertEquals(secondNumber.rightBound(), 10, PRECISION);
    }

    @Test
    void indexOfX() {
    }

    @Test
    void indexOfY() {
    }

    @Test
    void floorIndexOfX() {
        ArrayTabulatedFunction firstNumber = initializeUsingTwoArrays();
        assertEquals(firstNumber.floorIndexOfX(4.1), 1, PRECISION);
        assertEquals(firstNumber.floorIndexOfX(1.2), 0, PRECISION);
        ArrayTabulatedFunction secondNumber = initializeUsingMathFunction();
        assertEquals(secondNumber.floorIndexOfX(0.3), 0, PRECISION);
        assertEquals(secondNumber.floorIndexOfX(1.2), 1, PRECISION);
    }

    @Test
    void extrapolateLeft() {
    }

    @Test
    void extrapolateRight() {
    }

    @Test
    void interpolate() {
        ArrayTabulatedFunction firstNumber = initializeUsingTwoArrays();
        assertEquals(firstNumber.interpolate(2.5, 0), 5, PRECISION);
        assertEquals(firstNumber.interpolate(2.6, 0), 5, PRECISION);
        ArrayTabulatedFunction secondNumber = initializeUsingMathFunction();
        assertEquals(secondNumber.interpolate(1.5, 1), 2.5, PRECISION);
        assertEquals(secondNumber.interpolate(1.6, 1), 2.8, PRECISION);
    }
}