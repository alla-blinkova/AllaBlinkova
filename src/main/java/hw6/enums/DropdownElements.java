package hw6.enums;

public enum DropdownElements {
    RED("Red"),
    GREEN("Green"),
    BLUE("Blue"),
    YELLOW("Yellow");

    DropdownElements(String text) {
        this.text = text;
    }

    public String text;
}
