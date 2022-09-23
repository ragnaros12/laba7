package org.example.objects.builders;

import org.example.io.Readable;
import org.example.io.Writeable;
import org.example.objects.Car;
import org.example.objects.HumanBeing;

public class CarBuilder extends Builder<Car>{

    public CarBuilder(Readable<String> reader, Writeable<String> writer) {
        super(reader, writer);
        value = new Car();
    }

    public Car build(){

        value.setCool(Boolean.parseBoolean(PrintField("cool", true)));
        return value;
    }
}
