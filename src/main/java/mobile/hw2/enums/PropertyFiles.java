package mobile.hw2.enums;

public enum PropertyFiles {
    NATIVE("nativetest.properties"),
    WEB("webtest.properties");

    public String path;

    PropertyFiles(String path) {
        this.path = path;
    }
}