package com.robin.rapidexcel.elements;

import com.robin.rapidexcel.utils.CellProcessor;
import lombok.Getter;

@Getter
public class Cell {
    private WorkBook workBook;
    private CellType type;
    private Object value;
    private CellAddress address;
    private String formula;
    private String rawValue;
    private String dataFormatId;
    private String dataFormatString;
    public Cell(WorkBook workbook, CellType type, Object value, CellAddress address, String formula, String rawValue) {
        this(workbook, type, value, address, formula, rawValue, null, null);
    }
    public Cell(WorkBook workBook, CellProcessor processor,CellAddress address){
        this(workBook,processor.getCellType(),processor.getValue(),address,processor.getFormula(),processor.getRawValue());
    }

    public Cell(WorkBook workbook, CellType type, Object value, CellAddress address, String formula, String rawValue,
         String dataFormatId, String dataFormatString) {
        this.workBook = workbook;
        this.type = type;
        this.value = value;
        this.address = address;
        this.formula = formula;
        this.rawValue = rawValue;
        this.dataFormatId = dataFormatId;
        this.dataFormatString = dataFormatString;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
