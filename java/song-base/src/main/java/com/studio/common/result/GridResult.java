package com.studio.common.result;import java.util.List;/** * description: * author:          song * createDate:      2018/1/8 */public class GridResult<T> {    public GridResult(long total, List<T> rows) {        this.total = total;        this.rows = rows;    }    public GridResult() {    }    private long total;    private List<T> rows;    public long getTotal() {        return total;    }    public void setTotal(long total) {        this.total = total;    }    public List<T> getRows() {        return rows;    }    public void setRows(List<T> rows) {        this.rows = rows;    }}