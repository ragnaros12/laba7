package org.example.io.Console;

import org.example.io.Readable;

import java.util.Scanner;

public class ConsoleReadable implements Readable<String> {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public String read() {
        return scanner.next();
    }

    @Override
    public void close() {

    }
}
