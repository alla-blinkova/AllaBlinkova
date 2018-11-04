package hw5.enums;

public enum CheckBoxes {
    WATER("Water"),
    EARTH("Earth"),
    WIND("Wind"),
    FIRE("Fire");

    CheckBoxes(String text) {
        this.text = text;
    }

    public String text;

}
