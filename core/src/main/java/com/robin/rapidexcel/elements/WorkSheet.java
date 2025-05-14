package com.robin.rapidexcel.elements;

import com.robin.rapidexcel.exception.ExcelException;
import com.robin.rapidexcel.utils.OPCPackage;
import org.springframework.util.ObjectUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class WorkSheet {
    private String id;
    private int index;
    private String name;
    private String sheetId;
    private SheetVisibility visibility;
    private WorkBook workBook;

    private List<Cell[]> rows;
    private final Set<Integer> hiddenRows = new HashSet<>();

    private final Set<Integer> hiddenColumns = new HashSet<>();
    private final Map<Integer, Double> colWidths = new HashMap<>();

    private final Map<Integer, Column> colStyles = new HashMap<>();

    private Boolean fitToPage = false;
    private Boolean autoPageBreaks = false;
    private Cell[] currentCells;
    private int currentRowNum=1;

    public WorkSheet(WorkBook workBook,int index,String id,String sheetId,String name,SheetVisibility visibility){
        this.index=index;
        this.id=id;
        this.name=name;
        this.visibility=visibility;
        this.sheetId=sheetId;
        this.workBook=workBook;
    }
    public WorkSheet(WorkBook workBook,String name){
        this.workBook=workBook;
        this.name=name;
    }
    public void beginWrite(){

    }
    public void writeHeader(OutputStream outputStream) throws IOException {

        int index = workBook.getIndex(this);
        StringBuilder builder=new StringBuilder();
        //workBook.beginPart("xl/worksheets/sheet" + index + ".xml");
        builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        builder.append("<worksheet xmlns=\"http://schemas.openxmlformats.org/spreadsheetml/2006/main\" xmlns:r=\"http://schemas.openxmlformats.org/officeDocument/2006/relationships\">");
        builder.append("<sheetPr filterMode=\"" + "false" + "\">");

        builder.append("<pageSetUpPr fitToPage=\"" + fitToPage + "\" " + "autoPageBreaks=\"" + autoPageBreaks + "\"/></sheetPr>");
        builder.append("<dimension ref=\"A1\"/>");
        builder.append("<sheetViews><sheetView workbookViewId=\"0\"");
        builder.append("</sheetView>");
        builder.append("</sheetViews><sheetFormatPr defaultRowHeight=\"15.0\"/>");
        outputStream.write(builder.toString().getBytes(StandardCharsets.UTF_8));

    }
    public Cell getCell(int col){
        if(currentCells ==null){
            currentCells =new Cell[workBook.getSheetProp().getColumnPropList().size()];
            for(int i=0;i<workBook.getSheetProp().getColumnPropList().size();i++){
                Cell cell=new Cell(workBook, OPCPackage.parseCellType(workBook.getSheetProp().getColumnPropList().get(i)),new CellAddress(currentRowNum,i));
                currentCells[i]=cell;
            }
        }
        if(col<=workBook.getSheetProp().getColumnPropList().size()) {
            return currentCells[col];
        }else{
            throw new ExcelException("row over excel define columns");
        }
    }
    public void writeRow(Map<String,Object> valueMap){
        OutputStream outputStream=workBook.sheetTmpStreamMap.get(getIndex());
        if(!ObjectUtils.isEmpty(outputStream)){

        }
    }
    private void mergeCell(CellAddress begin,CellAddress end,Object value){

    }

    public String getId() {
        return id;
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
        return name;
    }
}
