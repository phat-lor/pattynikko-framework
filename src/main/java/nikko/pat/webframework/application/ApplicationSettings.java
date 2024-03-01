package nikko.pat.webframework.application;

public class ApplicationSettings {
    private int port = 80;
    private boolean debug = false;

    public ApplicationSettings setPort(int port) {
        this.port = port;
        return this;
    }

    public ApplicationSettings setDebug(boolean debug) {
        this.debug = debug;
        return this;
    }

    public boolean isDebug() {
        return debug;
    }

    public int getPort() {
        return port;
    }
}
