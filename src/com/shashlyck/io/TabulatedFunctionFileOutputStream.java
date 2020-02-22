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
        ArrayTabulatedFunction arrayTF = new ArrayTabulatedFunction(xValues, yValues);
        LinkedListTabulatedFunction linkedListTF = new LinkedListTabulatedFunction(xValues, yValues);
        try {
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(
                            new File("output"+ File.separator+"arrayFunction.bin")));
            FunctionsIO.writeTabulatedFunction(stream, arrayTF);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedOutputStream stream =
                    new BufferedOutputStream(new FileOutputStream(
                            new File("output"+File.separator+"linkedListFunction.bin")));
            FunctionsIO.writeTabulatedFunction(stream, linkedListTF);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
