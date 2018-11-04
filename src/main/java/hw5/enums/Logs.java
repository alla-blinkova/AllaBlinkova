package hw5.enums;

public enum Logs {
    CHECKBOX("%s: condition changed to %b"),
    RADIOBUTTON("metal: value changed to %s"),
    DROPDOWN("Colors: value changed to %s"),
    TO_SLIDER("Range 2(To):%d link clicked"),
    FROM_SLIDER("Range 2(From):%d link clicked");

    public String text;

    Logs(String text) {
        this.text = text;
    }
}
