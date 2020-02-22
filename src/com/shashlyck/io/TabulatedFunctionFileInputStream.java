package com.shashlyck.io;

import com.shashlyck.functions.ArrayTabulatedFunction;
import com.shashlyck.functions.factory.ArrayTFFactory;
import com.shashlyck.functions.factory.LinkedListTFFactory;
import com.shashlyck.operations.TabulatedDifferentialOperator;

import java.io.*;

public class TabulatedFunctionFileInputStream {

    public static void main(String[] args) {

        try {
            BufferedInputStream inputStream = new BufferedInputStream(
                    new FileInputStream("input"+File.separator+"arrayFunction.bin"));
            ArrayTabulatedFunction arrayTabulatedFunction = (ArrayTabulatedFunction) FunctionsIO.readTabulatedFunction(inputStream, new ArrayTFFactory());
            System.out.println(arrayTabulatedFunction.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("Введите размер и значения функции:");
            BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
            TabulatedDifferentialOperator operator = new TabulatedDifferentialOperator();
            System.out.println(operator.derive(FunctionsIO.readTabulatedFunction(read, new LinkedListTFFactory())).toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
