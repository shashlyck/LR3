package com.shashlyck.io;

import com.shashlyck.functions.LinkedListTabulatedFunction;
import com.shashlyck.functions.TabulatedFunction;
import com.shashlyck.functions.factory.LinkedListTFFactory;
import com.shashlyck.operations.TabulatedDifferentialOperator;

import java.io.*;

import static com.shashlyck.io.FunctionsIO.deserialize;

public class LinkedListTabulatedFunctionSerialization {
    public static void main(String[] args) {
        double[] xValues = {1, 2, 3};
        double[] yValues = {1, 2, 3};
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(xValues, yValues);
        TabulatedDifferentialOperator differentialOperator = new TabulatedDifferentialOperator(new LinkedListTFFactory());
        TabulatedFunction firstDerive = differentialOperator.derive(function);
        TabulatedFunction secondDerive = differentialOperator.derive(firstDerive);
        try {
            BufferedOutputStream outputStream = new BufferedOutputStream(
                    new FileOutputStream("output"+File.separator+"serializedLinkedListFunctions.bin"));
            FunctionsIO.serialize(outputStream, function);
            FunctionsIO.serialize(outputStream, firstDerive);
            FunctionsIO.serialize(outputStream, secondDerive);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            BufferedInputStream inPutStream = new BufferedInputStream(
                    new FileInputStream("output"+File.separator+"serializedLinkedListFunctions.bin"));
            System.out.println(deserialize(inPutStream).toString()
                    +'\n'
                    +deserialize(inPutStream).toString()
                    +'\n'
                    +deserialize(inPutStream).toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
