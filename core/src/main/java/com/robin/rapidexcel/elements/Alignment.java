package com.robin.rapidexcel.elements;

import com.robin.rapidexcel.writer.XMLWriter;

import java.io.IOException;
import java.util.Objects;

public class Alignment implements IWriteableElements{
    private final String horizontal;
    private final String vertical;
    private final boolean wrapText;
    private final int rotation;
    private final int indent;
    Alignment(String horizontal, String vertical, boolean wrapText, int rotation, int indent) {
        this.horizontal = horizontal;
        this.vertical = vertical;
        this.wrapText = wrapText;
        this.rotation = rotation;
        this.indent = indent;
    }
    @Override
    public int hashCode() {
        return Objects.hash(horizontal, vertical, wrapText);
    }

    @Override
    public void writeOut(XMLWriter w) throws IOException {
        w.append("<alignment");
        if (horizontal != null) {
            w.append(" horizontal=\"").append(horizontal).append('\"');
        }
        if (vertical != null) {
            w.append(" vertical=\"").append(vertical).append('\"');
        }
        if (rotation != 0) {
            w.append(" textRotation=\"").append(rotation).append('\"');
        }
        if (indent != 0) {
            w.append(" indent=\"").append(indent).append('\"');
        }
        if (wrapText) {
            w.append(" wrapText=\"true\"");
        }
        w.append("/>");
    }
}
