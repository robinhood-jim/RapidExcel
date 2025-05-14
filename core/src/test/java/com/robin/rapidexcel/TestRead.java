package com.robin.rapidexcel;

import com.robin.comm.util.xls.ExcelColumnProp;
import com.robin.comm.util.xls.ExcelSheetProp;
import com.robin.core.base.util.Const;
import com.robin.rapidexcel.elements.Row;
import com.robin.rapidexcel.elements.WorkBook;
import com.robin.rapidexcel.elements.WorkSheet;
import org.junit.Test;

import javax.xml.stream.XMLStreamException;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.stream.Stream;

public class TestRead {
    @Test
    public void testRead() throws IOException{
        new BufferedReader(new InputStreamReader(System.in)).readLine();
        ExcelSheetProp.Builder builder = ExcelSheetProp.Builder.newBuilder();
        builder.addColumnProp(new ExcelColumnProp("name", "name", Const.META_TYPE_STRING, false))
        .addColumnProp("time", "time", Const.META_TYPE_TIMESTAMP, false)
        .addColumnProp("intcol", "intcol", Const.META_TYPE_INTEGER, false)
        .addColumnProp("dval", "dval", Const.META_TYPE_DOUBLE, false)
        .addColumnProp("dval2", "dval2", Const.META_TYPE_DOUBLE, false)
        .addColumnProp(new ExcelColumnProp("diff", "diff", Const.META_TYPE_FORMULA, "(D{P}-E{P})/C{P}")).setStreamMode();
        try(WorkBook workBook=new WorkBook(new File("D:/test2.xlsx"),builder.build())){
            int sheetNum= workBook.getSheetNum();
            for(int i=0;i<sheetNum;i++){
                WorkSheet sheet=workBook.getSheet(i).get();
                Stream<Row> stream= workBook.openStream(sheet);
                Iterator<Row> iter=stream.iterator();
                int pos=0;
                while(iter.hasNext()){
                    iter.next();
                    //System.out.println(iter.next());
                    pos++;
                }
                System.out.println("sheet "+sheet.getName()+" rows "+pos);
            }

        }catch (IOException| XMLStreamException ex){
            ex.printStackTrace();
        }
        new BufferedReader(new InputStreamReader(System.in)).readLine();

    }
}
