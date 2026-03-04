package io.threadsync.sdk;

public class SyncAPI {
    private final ThreadSync client;

    SyncAPI(ThreadSync client) { this.client = client; }

    public Sync create(SyncConfig config) throws Exception {
        String json = client.request("POST", "/syncs", config);
        return client.gson().fromJson(json, Sync.class);
    }

    public Sync get(String id) throws Exception {
        String json = client.request("GET", "/syncs/" + id, null);
        return client.gson().fromJson(json, Sync.class);
    }
}
