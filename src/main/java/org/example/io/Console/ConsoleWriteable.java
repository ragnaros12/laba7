package org.example.io.Console;

import org.example.io.Writeable;

public class ConsoleWriteable implements Writeable<String> {
    @Override
    public void Write(String s) {
        System.out.println(s);
    }

    @Override
    public void close() {

    }
}
