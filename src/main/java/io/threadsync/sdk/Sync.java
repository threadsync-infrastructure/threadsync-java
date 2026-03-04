package io.threadsync.sdk;

public class Sync {
    private String id;
    private String status;
    private int recordsSynced;

    public Sync() {}

    public Sync(String id, String status, int recordsSynced) {
        this.id = id;
        this.status = status;
        this.recordsSynced = recordsSynced;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public int getRecordsSynced() { return recordsSynced; }
    public void setRecordsSynced(int recordsSynced) { this.recordsSynced = recordsSynced; }

    @Override
    public String toString() {
        return "Sync{id='" + id + "', status='" + status + "', recordsSynced=" + recordsSynced + "}";
    }
}
