package nikko.pat.webframework.util;

import nikko.pat.webframework.application.Application;

import java.io.PrintStream;

public class Logger {
    private final String name;
    private final PrintStream stream;

    private final Application app;

    public Logger(Application app, String name, PrintStream stream) {
        this.name = name;
        this.stream = stream;
        this.app = app;
    }

    public void debug(String message) {
        if (!app.isDebug()) {
            return;
        }
        stream.println("[DEBUG] " + name + ": " + message);
    }

    public void info(String message) {
        stream.println("[INFO] " + name + ": " + message);
    }

    public void error(String message) {
        stream.println("[ERROR] " + name + ": " + message);
    }

    public void error(String message, Throwable e) {
        stream.println("[ERROR] " + name + ": " + message);
        e.printStackTrace(stream);
    }
}

