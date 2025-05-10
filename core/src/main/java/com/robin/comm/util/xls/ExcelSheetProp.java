
package com.robin.comm.util.xls;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class ExcelSheetProp {
	private String[] headerName;
	private String[] columnName;
	private List<Map<String,Object>> columnList= new ArrayList<>();
	private List<ExcelColumnProp> columnPropList=new ArrayList<>();
	private String fileExt ="xlsx";
	private String[] columnType;
	private String sheetName;
	private int startRow=2;
	private int startCol=1;  
	private Integer tableId;
	// using SXSSFWorkbook with streamingWrite
	private boolean streamMode =false;
	private Integer streamRows=100;
	private int sheetNum=0;
	private boolean fillHeader=true;
	private String templateFile;
	public ExcelSheetProp(){

	}
	public ExcelSheetProp(String[] headerName, String[] columnName, String fileExt){
		this.headerName=headerName;
		this.columnName=columnName;
		this.fileExt=fileExt;
	}
	public ExcelSheetProp(String fileExt, boolean fillHeader){
		this.fileExt=fileExt;
		this.fillHeader=fillHeader;
	}
	public ExcelSheetProp(String fileExt){
		this.fileExt=fileExt;
	}

	public void addColumnProp(ExcelColumnProp prop){
		getColumnPropList().add(prop);
	}
	public List<ExcelColumnProp> getColumnPropList() {
		return columnPropList;
	}



}
