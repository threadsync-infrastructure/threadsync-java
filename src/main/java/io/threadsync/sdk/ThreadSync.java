package io.threadsync.sdk;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.google.gson.Gson;

public class ThreadSync {
    private final String token;
    private final String baseUrl;
    private final HttpClient http;
    private final Gson gson;

    private ThreadSync(Builder builder) {
        this.token = builder.bearerToken;
        this.baseUrl = builder.baseUrl != null ? builder.baseUrl : "https://api.threadsync.io/v1";
        this.http = HttpClient.newHttpClient();
        this.gson = new Gson();
    }

    public static Builder builder() { return new Builder(); }

    public ConnectionsAPI connections() { return new ConnectionsAPI(this); }
    public SyncAPI sync() { return new SyncAPI(this); }

    String request(String method, String path, Object body) throws Exception {
        HttpRequest.Builder req = HttpRequest.newBuilder()
            .uri(URI.create(baseUrl + path))
            .header("Authorization", "Bearer " + token)
            .header("Content-Type", "application/json")
            .header("User-Agent", "threadsync-java/0.1.0");
        if (body != null) {
            req.method(method, HttpRequest.BodyPublishers.ofString(gson.toJson(body)));
        } else {
            req.method(method, HttpRequest.BodyPublishers.noBody());
        }
        HttpResponse<String> resp = http.send(req.build(), HttpResponse.BodyHandlers.ofString());
        if (resp.statusCode() >= 400) {
            throw new RuntimeException("ThreadSync API error " + resp.statusCode() + ": " + resp.body());
        }
        return resp.body();
    }

    Gson gson() { return gson; }

    public static class Builder {
        private String bearerToken;
        private String baseUrl;

        public Builder bearerToken(String token) { this.bearerToken = token; return this; }
        public Builder baseUrl(String url) { this.baseUrl = url; return this; }
        public ThreadSync build() { return new ThreadSync(this); }
    }
}
