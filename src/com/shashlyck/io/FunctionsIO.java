package com.shashlyck.io;

import com.shashlyck.functions.Point;
import com.shashlyck.functions.TabulatedFunction;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

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
}
