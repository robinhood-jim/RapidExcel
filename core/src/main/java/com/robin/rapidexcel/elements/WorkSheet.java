package com.robin.rapidexcel.elements;

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
