package mobile.hw3.enums;

public enum PropertyTypes {
    NATIVE_FARM("native_farm"),
    WEB_FARM("web_farm"),
    NATIVE_EMULATOR("native_emulator"),
    WEB_EMULATOR("web_emulator");

    public String type;

    PropertyTypes(String type) {
        this.type = type;
    }
}