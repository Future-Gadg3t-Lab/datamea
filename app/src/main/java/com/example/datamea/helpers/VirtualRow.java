package com.example.datamea.helpers;

import java.util.ArrayList;

public class VirtualRow {
    ArrayList<String> row;
    int colSize;
    int id;

    //
    VirtualRow(int id, ArrayList<String> r) {
        this.id = id;
        row = r;
        colSize = r.size();
    }

    // If it a new row set id to -1
    VirtualRow(ArrayList<String> r) {
        this.id = -1;
        row = r;
        colSize = r.size();
    }

    public int getId() {
        return id;
    }

    public int getColSize() {
        return colSize;
    }

    public ArrayList<String> getRow() {
        return row;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setColSize(int colSize) {
        this.colSize = colSize;
    }

    public void setRow(ArrayList<String> row) {
        this.row = row;
    }

    // Update value at row[index] to s
    public void updateRow(String s, int index) {
        row.set(index, s);
    }

    // Update the whole row
    public Boolean updateRow(ArrayList<String> arr) {
        if (arr.size() != row.size())
            return false;
        row = arr;
        return true;
    }

    /* A method to compare the rows between two Virtual Table
        and return a listen of row ids which are different
    */
    public void compareTo() {

    }
}


