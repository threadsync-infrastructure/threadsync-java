# ThreadSync Java SDK

Official Java SDK for the [ThreadSync](https://www.threadsync.io) enterprise data integration API.

![Java 11+](https://img.shields.io/badge/Java-11%2B-007396?logo=openjdk&logoColor=white)
![License: MIT](https://img.shields.io/badge/License-MIT-green)
![Version](https://img.shields.io/badge/version-0.1.0-blue)

## Installation

### Maven

```xml
<dependency>
  <groupId>io.threadsync</groupId>
  <artifactId>threadsync-sdk</artifactId>
  <version>0.1.0</version>
</dependency>
```

### Gradle

```groovy
implementation 'io.threadsync:threadsync-sdk:0.1.0'
```

## Quick Start

```java
import io.threadsync.sdk.ThreadSync;
import io.threadsync.sdk.models.*;

public class QuickStart {
    public static void main(String[] args) {
        // Initialize the client
        ThreadSync ts = ThreadSync.builder()
            .bearerToken(System.getenv("THREADSYNC_API_TOKEN"))
            .build();

        // Connect to Salesforce
        Connection sf = ts.connections().create("salesforce");

        // Connect to your data warehouse
        Connection dest = ts.connections().create("snowflake");

        // Create a real-time sync
        Sync sync = ts.sync().create(
            SyncConfig.builder()
                .source(new Endpoint(sf.getId(), "Contact"))
                .destination(new Endpoint(dest.getId(), "contacts"))
                .schedule("realtime")
                .build()
        );

        System.out.printf("Sync created: %s%n", sync.getId());
    }
}
```

## Configuration

```java
ThreadSync ts = ThreadSync.builder()
    .bearerToken("sk_test_...")        // API key or JWT from /v1/auth/token
    .baseUrl("https://api.threadsync.io") // Default
    .connectTimeout(Duration.ofSeconds(10))
    .readTimeout(Duration.ofSeconds(30))
    .build();
```

## Error Handling

```java
try {
    Connection conn = ts.connections().get("conn_nonexistent");
} catch (ThreadSyncException e) {
    System.err.println("Code: " + e.getCode());       // NOT_FOUND
    System.err.println("Message: " + e.getMessage());  // Connection not found
    System.err.println("Request ID: " + e.getRequestId()); // req_...
}
```

## Documentation

- [API Reference](https://www.threadsync.io/api-docs)
- [Developer Portal](https://www.threadsync.io/developers)

## License

MIT - see [LICENSE](LICENSE) for details.
