package com.robin.rapidexcel.utils;

import com.robin.rapidexcel.writer.XMLWriter;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CellUtils {
    private static final Pattern paramPattern=Pattern.compile("\\w+(\\{P([\\+|-]?[\\d+])?\\})");
    public static  String colToString(int col){
        StringBuilder sb = new StringBuilder();
        while (col >= 0) {
            sb.append((char) ('A' + (col % 26)));
            col = (col / 26) - 1;
        }
        return sb.reverse().toString();
    }
    public static void appendEscaped(StringBuilder sb,String s) {
        sb.append(XmlEscapeHelper.escape(s));
    }
    public static String returnFormulaWithPos(String formula,int linePos){
        Matcher matcher=paramPattern.matcher(formula);
        StringBuffer buffer=new StringBuffer();
        while(matcher.find()){
            String groupStr=matcher.group();
            int pos=groupStr.indexOf("{P");
            String columnName=groupStr.substring(0,pos);
            Integer stepNum=linePos;
            if(pos+3<groupStr.length()) {
                String addPlustag = groupStr.substring(pos+2 , pos+3);
                stepNum = "+".equals(addPlustag) ? stepNum + Integer.valueOf(groupStr.substring(pos + 3, groupStr.length()-1)) : stepNum - Integer.valueOf(groupStr.substring(pos + 3, groupStr.length()-1));
            }
            matcher.appendReplacement(buffer,columnName+stepNum);
        }
        matcher.appendTail(buffer);
        return buffer.toString();
    }
}
