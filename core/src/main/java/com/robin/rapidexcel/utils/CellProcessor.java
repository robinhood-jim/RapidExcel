package com.robin.rapidexcel.utils;

import com.robin.rapidexcel.elements.CellAddress;
import com.robin.rapidexcel.elements.CellType;
import com.robin.rapidexcel.elements.WorkBook;
import com.robin.rapidexcel.reader.XMLReader;
import lombok.Getter;
import lombok.Setter;

import java.io.Closeable;
import java.io.IOException;

@Getter
@Setter
public class CellProcessor implements Closeable {
    String type ;
    String styleString ;
    String formatId = null;
    String formatString = null;
    CellAddress address;
    Object value = null;
    String formula = null;
    String rawValue = null;
    CellType cellType;
    String dataFormatId;
    String dataFormatString;


    public CellProcessor(){

    }
    public void setValue(XMLReader r, WorkBook workBook,CellAddress address){
        type = r.getOptionalAttribute("t").orElse("n");
        styleString = r.getAttribute("s");
        this.address=address;

        if (styleString != null) {
            int index = Integer.parseInt(styleString);
            if (index < workBook.getFormats().size()) {
                formatId = workBook.getFormats().get(index);
                formatString = workBook.getNumFmtMap().get(formatId);
            }
        }
    }



    @Override
    public void close() throws IOException {

    }
}
