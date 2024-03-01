package me.phatlor.web.response;

public enum ContentType {
    HTML("text/html"),
    JSON("application/json"),
    XML("application/xml"),
    TEXT("text/plain");

    private final String value;

    ContentType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
