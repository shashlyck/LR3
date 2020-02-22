package com.shashlyck.functions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTabulatedFunctionTest {

    private double[] xValues = new double[]{1., 4., 7., 10., 13.};
    private double[] yValues = new double[]{4., 6., 8., 10., 12.};
    private double PRECISION = 0.1;

    private MathFunction Function = new IdentityFunction();

    private LinkedListTabulatedFunction initializeUsingArrays() {
        return new LinkedListTabulatedFunction(xValues, yValues);
    }
    private LinkedListTabulatedFunction initializeUsingMathFunction() {
        return new LinkedListTabulatedFunction(Function, 1, 5, 11);
    }

    @Test
    public void addNode() {
        LinkedListTabulatedFunction firstNumber = initializeUsingArrays();
        firstNumber.addNode(5, 14);
        assertEquals(firstNumber.rightBound(), 5, PRECISION);
    }

    @Test
    public void getCount() {
        LinkedListTabulatedFunction firstNumber = initializeUsingArrays();
        assertEquals(firstNumber.getCount(), 5, PRECISION);
        LinkedListTabulatedFunction secondNumber = initializeUsingMathFunction();
        assertEquals(secondNumber.getCount(), 11, PRECISION);
    }

    @Test
    public void leftBound() {
        LinkedListTabulatedFunction firstList = initializeUsingArrays();
        assertEquals(firstList.leftBound(), 1, PRECISION);
        LinkedListTabulatedFunction secondNumber = initializeUsingMathFunction();
        assertEquals(secondNumber.leftBound(), 1, PRECISION);
    }

    @Test
    public void rightBound() {
        LinkedListTabulatedFunction firstList = initializeUsingArrays();
        assertEquals(firstList.rightBound(), 13, PRECISION);
        LinkedListTabulatedFunction secondNumber = initializeUsingMathFunction();
        assertEquals(secondNumber.rightBound(), 5, PRECISION);
    }

    @Test
    public void getX() {
        LinkedListTabulatedFunction firstNumber = initializeUsingArrays();
        LinkedListTabulatedFunction secondNumber = initializeUsingMathFunction();
        assertEquals(secondNumber.getX(2), 1.8, PRECISION);
        for (int i = 0; i < 5; i++) {
            assertEquals(firstNumber.getX(i), 1 + 3 * i, PRECISION);
        }
    }

    @Test
    public void getY() {
        LinkedListTabulatedFunction firstNumber = initializeUsingArrays();
        assertEquals(firstNumber.getY(0), 4, PRECISION);
        LinkedListTabulatedFunction secondNumber = initializeUsingMathFunction();
        assertEquals(secondNumber.getY(3), 4.6, PRECISION);
    }

    @Test
    public void setY() {
        LinkedListTabulatedFunction firstNumber = initializeUsingArrays();
        firstNumber.setY(3, 16);
        assertEquals(firstNumber.getY(3), 16, PRECISION);
        LinkedListTabulatedFunction secondNumber = initializeUsingMathFunction();
        secondNumber.setY(7, 3);
        assertEquals(secondNumber.getY(7), 3, PRECISION);
    }

    @Test
    public void apply() {
        LinkedListTabulatedFunction firstNumber = initializeUsingArrays();
        assertEquals(firstNumber.apply(0), 3.3, PRECISION);
        assertEquals(firstNumber.apply(8), 8.7, PRECISION);
        assertEquals(firstNumber.apply(4.2), firstNumber.interpolate(4.2, 1), PRECISION);
    }

    @Test
    public void indexOfX() {
        LinkedListTabulatedFunction firstNumber = initializeUsingArrays();
        assertEquals(firstNumber.indexOfX(4), 1, PRECISION);
        assertEquals(firstNumber.indexOfX(-1), -1, PRECISION);
        LinkedListTabulatedFunction secondNumber = initializeUsingMathFunction();
        assertEquals(secondNumber.indexOfX(1), 0, PRECISION);
        assertEquals(secondNumber.indexOfX(-1), -1, PRECISION);
    }

    @Test
    public void indexOfY() {
        LinkedListTabulatedFunction firstNumber = initializeUsingArrays();
        assertEquals(firstNumber.indexOfY(4), 0, PRECISION);
        assertEquals(firstNumber.indexOfY(-1), -1, PRECISION);
        LinkedListTabulatedFunction secondNumber = initializeUsingMathFunction();
        assertEquals(secondNumber.indexOfY(2.2), -1, PRECISION);
        assertEquals(secondNumber.indexOfY(-1), -1, PRECISION);
    }

    @Test
    public void floorIndexOfX() {
        LinkedListTabulatedFunction firstNumber = initializeUsingArrays();
        assertEquals(firstNumber.floorIndexOfX(4), 0, PRECISION);
        assertEquals(firstNumber.floorIndexOfX(1.2), 0, PRECISION);
        LinkedListTabulatedFunction secondNumber = initializeUsingMathFunction();
        assertEquals(secondNumber.floorIndexOfX(1.8), 2, PRECISION);
        assertEquals(secondNumber.floorIndexOfX(2.3), 3, PRECISION);
    }

    @Test
    public void extrapolateLeft() {
        LinkedListTabulatedFunction firstNumber = initializeUsingArrays();
        LinkedListTabulatedFunction secondNumber = initializeUsingMathFunction();
        assertEquals(firstNumber.extrapolateLeft(0), 3.3, PRECISION);
        assertEquals(firstNumber.extrapolateLeft(1), 4, PRECISION);
        assertEquals(secondNumber.extrapolateLeft(1.8), 2.8, PRECISION);
        assertEquals(secondNumber.extrapolateLeft(2.2), 3.4, PRECISION);
    }

    @Test
    public void extrapolateRight() {
        LinkedListTabulatedFunction firstNumber = initializeUsingArrays();
        assertEquals(firstNumber.extrapolateRight(6), 7.3, PRECISION);
        assertEquals(firstNumber.extrapolateRight(5), 6.7, PRECISION);
        LinkedListTabulatedFunction secondNumber = initializeUsingMathFunction();
        assertEquals(secondNumber.extrapolateRight(4.6), 49.7, PRECISION);
        assertEquals(secondNumber.extrapolateRight(5), 74.2, PRECISION);
    }

    @Test
    public void interpolate() {
        LinkedListTabulatedFunction firstNumber = initializeUsingArrays();
        assertEquals(firstNumber.interpolate(5, 1), 6.7, PRECISION);
        assertEquals(firstNumber.interpolate(7, 2), 8, PRECISION);
        LinkedListTabulatedFunction secondNumber = initializeUsingMathFunction();
        assertEquals(secondNumber.interpolate(1.5, 1), 2.4, PRECISION);
        assertEquals(secondNumber.interpolate(1.7, 1), 2.9, PRECISION);
    }
}