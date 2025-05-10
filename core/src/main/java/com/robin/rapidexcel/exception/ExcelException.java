package com.robin.rapidexcel.exception;

public class ExcelException extends RuntimeException{
    public ExcelException(Exception ex){
        super(ex);
    }
    public ExcelException(String message){
        super(message);
    }
}
