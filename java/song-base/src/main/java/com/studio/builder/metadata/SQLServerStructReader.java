package com.studio.builder.metadata;import com.song.db.DBColumn;import com.song.db.DBConnectionConfig;import com.song.db.DBTable;import java.util.List;/** * description: * author:          song * createDate:      2017/10/25 */public class SQLServerStructReader extends DbStructReader {    public SQLServerStructReader(DBConnectionConfig config) {        super(config);    }    public List<String> getSystemTableNames() {        return null;    }    public List<String> getProcedureNames() {        return null;    }    public List<String> getViewNames() {        return null;    }    public List<String> getUserTableNames() {        return null;    }    public List<String> getDataTypes() {        return null;    }    public List<DBColumn> getColumns(String tableName) {        String sql = "";        return null;    }    public DBTable getTable(String tableName) {        return null;    }}