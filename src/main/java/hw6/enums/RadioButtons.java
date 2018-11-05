package hw6.enums;

public enum RadioButtons {
    GOLD("Gold"),
    SILVER("Silver"),
    BRONZE("Bronze"),
    SELEN("Selen");

    RadioButtons(String text) {
        this.text = text;
    }

    public String text;
}
