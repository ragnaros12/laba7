package org.example.io;

public interface Readable<T> {
    T read();
    void close();
}
