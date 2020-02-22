package com.shashlyck.io;

import com.shashlyck.functions.ArrayTabulatedFunction;
import com.shashlyck.functions.LinkedListTabulatedFunction;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class TabulatedFunctionFileOutputStream {
    public static void main(String[] args) {
        double[] xValues = {1, 2, 3};
        double[] yValues = {1, 2, 3};
        ArrayTabulatedFunction arrayTabulatedFunction = new ArrayTabulatedFunction(xValues, yValues);
        LinkedListTabulatedFunction linkedListTabulatedFunction = new LinkedListTabulatedFunction(xValues, yValues);
        try (BufferedOutputStream outputStreamArrayTabulatedFunction = new BufferedOutputStream(new FileOutputStream(new File("output\\arrayFunction.bin")))) {
            FunctionsIO.writeTabulatedFunction(outputStreamArrayTabulatedFunction, arrayTabulatedFunction);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedOutputStream outputStreamLinkedListTabulatedFunction = new BufferedOutputStream(new FileOutputStream(new File("output\\linkedListFunction.bin")))) {
            FunctionsIO.writeTabulatedFunction(outputStreamLinkedListTabulatedFunction, linkedListTabulatedFunction);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
