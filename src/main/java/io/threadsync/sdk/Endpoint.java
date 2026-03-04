package io.threadsync.sdk;

public class Endpoint {
    private String connection;
    private String object;
    private String table;

    public Endpoint() {}

    public Endpoint(String connection, String object, String table) {
        this.connection = connection;
        this.object = object;
        this.table = table;
    }

    public String getConnection() { return connection; }
    public void setConnection(String connection) { this.connection = connection; }

    public String getObject() { return object; }
    public void setObject(String object) { this.object = object; }

    public String getTable() { return table; }
    public void setTable(String table) { this.table = table; }

    @Override
    public String toString() {
        return "Endpoint{connection='" + connection + "', object='" + object + "', table='" + table + "'}";
    }
}
