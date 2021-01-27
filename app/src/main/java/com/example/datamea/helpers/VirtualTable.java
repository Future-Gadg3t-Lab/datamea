package com.example.datamea.helpers;

import java.util.ArrayList;

/* Creating a virtual table object */

class VirtualTable {
    private String Name;
    private ArrayList<String> columns;
    private ArrayList<VirtualRow> rows;

    /* Initial Virtual Table with Table name and table columns */
    VirtualTable (String n, ArrayList<String> col) {
        columns = col;
        Name = n;
        rows = new ArrayList<VirtualRow>();
    }

    /* Initial Virtual Table with Table name and table columns */
    VirtualTable (String n) {
        columns = new ArrayList<String>();
        Name = n;
        rows = new ArrayList<VirtualRow>();
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

    public ArrayList<VirtualRow> getRows() {
        return rows;
    }

    /* Method to insert a row into the table
     *      Returns true on success
     *      Returns false on failure
     */
    Boolean addRow (VirtualRow row) {
        if (row.getColSize() != getColumnCount())
            return false;
        rows.add(row);
        return true;
    }

    Boolean removeRow (VirtualRow row) {
        for (int i = 0; i < rows.size(); i++) {
            if (rows.get(i).getId() == row.getId()) {
                rows.remove(i);
                return true;
            }
        }
        return false;
    }

}
