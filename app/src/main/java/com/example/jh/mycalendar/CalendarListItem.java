package com.example.jh.mycalendar;

public class CalendarListItem {
    private boolean check;
    private String name;
    public boolean getCheck(){return check;}
    public String getName(){return name;}
    public CalendarListItem(boolean check,String name){
        this.check=check;
        this.name=name;
    }
}
