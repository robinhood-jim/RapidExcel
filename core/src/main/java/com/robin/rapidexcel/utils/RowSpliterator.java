package com.robin.rapidexcel.utils;

import com.robin.comm.util.xls.ExcelSheetProp;
import com.robin.rapidexcel.elements.Cell;
import com.robin.rapidexcel.elements.CellAddress;
import com.robin.rapidexcel.elements.Row;
import com.robin.rapidexcel.elements.WorkBook;

import javax.xml.stream.XMLStreamException;
import java.io.InputStream;
import java.util.ArrayList;

public class RowSpliterator extends BaseSpliterator<Row> {

    private Row row;

    public RowSpliterator(WorkBook workBook, InputStream stream,ExcelSheetProp prop) throws XMLStreamException {
        super(workBook, stream, prop);
    }


    @Override
    void initCells() {
        cells=new ArrayList<>(prop.getColumnList().size());
        prop.getColumnPropList().forEach(f->cells.add(null));
    }

    @Override
    void processCell(int trackedColIndex) throws XMLStreamException {
        Cell cell = parseCell(trackedColIndex,prop.isStreamMode());
        CellAddress addr = cell.getAddress();
        cells.set(addr.getColumn(), cell);
    }


    @Override
    Row constructReturn() {
        if(!prop.isStreamMode() || row==null){
            row=new Row(cells);
        }else{
            row.setCells(cells);
        }
        return row;
    }
}
