package com.robin.rapidexcel.elements;

import com.robin.rapidexcel.writer.XMLWriter;

import java.io.IOException;
import java.util.zip.ZipEntry;


public interface IWriteableElements {
    void writeOut(XMLWriter writer) throws IOException;
    default void beginPart(XMLWriter writer,String partName) throws IOException{
        writer.getZipOutputStream().putNextEntry(new ZipEntry(partName));
    }
    default void closePart(XMLWriter writer) throws IOException{
        writer.getZipOutputStream().closeEntry();
    }
}
