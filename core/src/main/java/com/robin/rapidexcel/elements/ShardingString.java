package com.robin.rapidexcel.elements;

import lombok.Getter;

@Getter
public class ShardingString {
    private String value;
    private int index;
    public ShardingString(String value,int index){
        this.value=value;
        this.index=index;
    }
}
