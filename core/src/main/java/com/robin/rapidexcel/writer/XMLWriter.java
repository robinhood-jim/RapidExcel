package com.robin.rapidexcel.writer;

import com.robin.rapidexcel.utils.XmlEscapeHelper;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class XMLWriter {
    private final OutputStream outputStream;
    private StringBuilder sb;
    XMLWriter(OutputStream outputStream){
        this.outputStream=outputStream;
        this.sb=new StringBuilder(512*1024);
    }
    private XMLWriter append(String s, boolean escape) throws IOException {
        if (escape) {
            sb.append(XmlEscapeHelper.escape(s));
        } else {
            sb.append(s);
        }
        check();
        return this;
    }
    private void check() throws IOException {
        if (sb.capacity() - sb.length() < 1024) {
            flush();
        }
    }
    void flush() throws IOException {
        outputStream.write(sb.toString().getBytes(StandardCharsets.UTF_8));
        sb.setLength(0);
    }
}
