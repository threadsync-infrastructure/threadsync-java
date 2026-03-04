package io.threadsync.sdk;

import java.util.Map;

public class ConnectionsAPI {
    private final ThreadSync client;

    ConnectionsAPI(ThreadSync client) { this.client = client; }

    public Connection create(String provider) throws Exception {
        String json = client.request("POST", "/connections", Map.of("provider", provider));
        return client.gson().fromJson(json, Connection.class);
    }

    public Connection get(String id) throws Exception {
        String json = client.request("GET", "/connections/" + id, null);
        return client.gson().fromJson(json, Connection.class);
    }
}
