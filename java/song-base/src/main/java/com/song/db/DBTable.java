package com.song.db;import java.util.ArrayList;import java.util.List;/** * description: * author:          song * createDate:      2017/10/25 */public class DBTable {    private String code;    private String name;    private String comment;    private List<DBColumn> dbColumns = new ArrayList<DBColumn>();    public String getCode() {        return code;    }    public void setCode(String code) {        this.code = code;    }    public String getName() {        return name;    }    public void setName(String name) {        this.name = name;    }    public String getComment() {        return comment;    }    public void setComment(String comment) {        this.comment = comment;    }    public List<DBColumn> getDbColumns() {        return dbColumns;    }    public void setDbColumns(List<DBColumn> dbColumns) {        this.dbColumns = dbColumns;    }}