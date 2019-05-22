package com.backstage.api;

import java.util.List;

public class datadto {
    private int total;

    public List<data> getRows() {
        return rows;
    }

    public void setRows(List<data> rows) {
        this.rows = rows;
    }

    private List<data> rows;
    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    class data {
        public String getIumac() {
            return iumac;
        }

        public void setIumac(String iumac) {
            this.iumac = iumac;
        }

        private String iumac;

    }

}
