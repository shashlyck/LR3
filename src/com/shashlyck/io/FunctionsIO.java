package com.shashlyck.io;

import com.shashlyck.functions.Point;
import com.shashlyck.functions.TabulatedFunction;
import com.shashlyck.functions.factory.TabulatedFunctionFactory;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public final class FunctionsIO {

    private FunctionsIO() {
        throw new UnsupportedOperationException();
    }

    public static void writeTabulatedFunction(BufferedOutputStream outputStream, TabulatedFunction function) throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeInt(function.getCount());
        for (Point point : function) {
            dataOutputStream.writeDouble(point.x);
            dataOutputStream.writeDouble(point.y);
        }
        dataOutputStream.flush();
    }

    public static TabulatedFunction readTabulatedFunction(BufferedInputStream inputStream, TabulatedFunctionFactory factory) throws IOException {
        DataInputStream inPut = new DataInputStream(inputStream);
        int count = inPut.readInt();
        double[] xValues = new double[count];
        double[] yValues = new double[count];
        for (int i = 0; i < count; i++) {
            xValues[i] = inPut.readDouble();
            yValues[i] = inPut.readDouble();
        }
        return factory.create(xValues, yValues);
    }

    static TabulatedFunction readTabulatedFunction(BufferedReader reader, TabulatedFunctionFactory factory) throws IOException {
        int count;
        try {
            count = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException nf) {
            throw new IOException(nf);
        }
        double[] xValues = new double[count];
        double[] yValues = new double[count];
        NumberFormat formatter = NumberFormat.getInstance(Locale.forLanguageTag("ru"));
        String tempString;
        for (int i = 0; i < count; i++) {
            tempString = reader.readLine();
            try {
                xValues[i] = formatter.parse(tempString.split(" ")[0]).doubleValue();
                yValues[i] = formatter.parse(tempString.split(" ")[1]).doubleValue();
            } catch (ParseException p) {
                throw new IOException(p);
            }
        }
        return factory.create(xValues, yValues);
    }
}
