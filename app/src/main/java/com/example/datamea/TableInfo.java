package com.example.datamea;


public class TableInfo {
    private String name;
    private int nr_rows;

    TableInfo(String name)
    {
        this.name = name;
        this.nr_rows = 0;
    }

    public void setNr_rows(int rows)
    {
        nr_rows = rows;
    }


    public int getNr_rows()
    {
        return nr_rows;
    }

    public String  getName()
    {
        return name;
    }
}