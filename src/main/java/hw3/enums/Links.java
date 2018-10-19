package hw3.enums;

public enum Links {
    HOME_PAGE ("https://epam.github.io/JDI/"),
    GITHUB ("https://github.com/epam/JDI");

    public String link;

    Links(String link) {
        this.link = link;
    }

}
