package org.example.objects.builders;

import org.example.Util;
import org.example.io.Readable;
import org.example.io.Writeable;
import org.example.objects.Coordinates;
import org.example.objects.Mood;

public class CoordinateBuilder extends Builder<Coordinates> {
    public CoordinateBuilder(Readable<String> reader, Writeable<String> writer) {
        super(reader, writer);
        value = new Coordinates();
    }

    public Coordinates build(){
        Double x = null;
        boolean isNext = false;
        boolean isF = false;
        while (!isNext) {
            try {
                String str = PrintField("x", !isF);
                x = str.equals("") ? null : Double.parseDouble(str);
                isNext = true;
            } catch (Exception ignored) {}
            isF = true;
        }

        int y = Integer.parseInt(PrintField("y", true));

        value.setX(x);
        value.setY(y);

        return value;
    }
}
