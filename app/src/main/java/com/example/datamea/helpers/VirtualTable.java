package com.example.datamea.helpers;

import java.util.ArrayList;

/* Creating a virtual table object */

class VirtualTable {
    private String Name;
    private ArrayList<String> columns;
    private ArrayList<ArrayList<String>> rows;

    /* Initial Virtaul Table with Table name and table columns */
    VirtualTable (String n, ArrayList<String> col) {
        columns = col;
        Name = n;
        rows = new ArrayList<ArrayList<String>>();
    }

    public String getName() {
        return Name;
    }

    int getColumnCount() {
        return columns.size();
    }

    int getRowCount() {
        return rows.size();
    }

    public ArrayList<String> getColumns() {
        return columns;
    }

    public ArrayList<ArrayList<String>> getRows() {
        return rows;
    }

    /* Method to insert a row into the table
     *      Returns true on success
     *      Returns false on failure
     */
    Boolean addRow (ArrayList<String> row) {
        if (row.size() != getColumnCount())
            return false;
        rows.add(row);
        return true;
    }


}
