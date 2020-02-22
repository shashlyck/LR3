package com.shashlyck.io;

import com.shashlyck.functions.Point;
import com.shashlyck.functions.TabulatedFunction;
import com.shashlyck.functions.factory.TabulatedFunctionFactory;

import java.io.*;

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

    public static TabulatedFunction readTabulatedFunction(BufferedInputStream bis, TabulatedFunctionFactory factory)
            throws IOException
    {
        DataInputStream dis = new DataInputStream(bis);
        int count = dis.readInt();
        double[] xValues = new double[count];
        double[] yValues = new double[count];
        for (int i = 0; i < count; i++) {
            xValues[i] = dis.readDouble();
            yValues[i] = dis.readDouble();
        }
        return factory.create(xValues, yValues);
    }
}
