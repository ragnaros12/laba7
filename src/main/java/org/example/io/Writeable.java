package org.example.io;

public interface Writeable<T> {
    void Write(T t);
    void close();
}
