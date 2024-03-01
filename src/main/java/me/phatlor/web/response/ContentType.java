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

    public static ContentType fromString(String value) {
        for (ContentType contentType : ContentType.values()) {
            if (contentType.value.equals(value)) {
                return contentType;
            }
        }
        return null;
    }
}
