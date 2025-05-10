package com.robin.rapidexcel.elements;

import com.robin.rapidexcel.writer.XMLWriter;

import java.io.IOException;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public class Properties {
    private String title;
    private String subject;
    private String keywords;

    private String description;
    private String category;

    private String manager;
    private String company;
    private String hyperlinkBase;


    private Set<ICustomProperty> customProperties = Collections.synchronizedSet(new LinkedHashSet<>());
    interface ICustomProperty{
        void writeOut(XMLWriter writer,int pid) throws IOException;
    }

}
