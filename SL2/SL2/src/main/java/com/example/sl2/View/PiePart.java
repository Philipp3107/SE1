package com.example.sl2.View;

public class PiePart {
    private String s;
    private Integer i;
    public PiePart(String s, Integer i){
        this.s = s;
        this.i = i;
    }
    public String getKey(){
       return s;
    }
    public Integer getValue(){
        return i;
    }
}
