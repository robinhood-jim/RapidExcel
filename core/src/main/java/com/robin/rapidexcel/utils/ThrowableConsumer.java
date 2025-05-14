package com.robin.rapidexcel.utils;

import java.io.IOException;

@FunctionalInterface
public interface ThrowableConsumer<T> {
    void accept(T t) throws IOException;
}
