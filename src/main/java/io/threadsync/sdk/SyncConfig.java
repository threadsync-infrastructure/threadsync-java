package io.threadsync.sdk;

public class SyncConfig {
    private Endpoint source;
    private Endpoint destination;
    private String schedule;

    private SyncConfig(Builder builder) {
        this.source = builder.source;
        this.destination = builder.destination;
        this.schedule = builder.schedule;
    }

    public Endpoint getSource() { return source; }
    public Endpoint getDestination() { return destination; }
    public String getSchedule() { return schedule; }

    public static Builder builder() { return new Builder(); }

    public static class Builder {
        private Endpoint source;
        private Endpoint destination;
        private String schedule;

        public Builder source(Endpoint source) { this.source = source; return this; }
        public Builder destination(Endpoint destination) { this.destination = destination; return this; }
        public Builder schedule(String schedule) { this.schedule = schedule; return this; }

        public SyncConfig build() {
            if (source == null) throw new IllegalStateException("source is required");
            if (destination == null) throw new IllegalStateException("destination is required");
            return new SyncConfig(this);
        }
    }

    @Override
    public String toString() {
        return "SyncConfig{source=" + source + ", destination=" + destination + ", schedule='" + schedule + "'}";
    }
}
