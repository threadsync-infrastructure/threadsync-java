package io.threadsync.sdk;

public class Connection {
    private String id;
    private String provider;
    private String name;
    private String status;

    public Connection() {}

    public Connection(String id, String provider, String name, String status) {
        this.id = id;
        this.provider = provider;
        this.name = name;
        this.status = status;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getProvider() { return provider; }
    public void setProvider(String provider) { this.provider = provider; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    @Override
    public String toString() {
        return "Connection{id='" + id + "', provider='" + provider + "', name='" + name + "', status='" + status + "'}";
    }
}
