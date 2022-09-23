package org.example.objects.builders;

import org.example.io.Readable;
import org.example.io.Writeable;

import java.util.Arrays;

public abstract class Builder<T> {

    T value;
    protected final Readable<String> reader;
    protected final Writeable<String> writer;

    public Builder(Readable<String> reader, Writeable<String> writer) {
        this.reader = reader;
        this.writer = writer;
    }

    abstract T build();

    protected String PrintField(String name, boolean isFirst){
        if(isFirst)
            writer.Write("введеите поле - " + name);
        else
            writer.Write("повторите попытку ввода поля - " + name);

        return reader.read();
    }

    protected String PrintField(String name, Class<? extends Enum> e, boolean isFirst){
        if(isFirst)
            writer.Write("введеите поле - " + name);
        else
            writer.Write("повторите попытку ввода поля - " + name);
        writer.Write("готовые константы: " + Arrays.toString(e.getEnumConstants()));
        return reader.read();
    }
}
