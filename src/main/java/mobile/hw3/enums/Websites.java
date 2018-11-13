package mobile.hw3.enums;

public enum Websites {
    IANA("www.iana.org", "Internet Assigned Numbers Authority");

    Websites(String sut, String title) {
        this.sut = sut;
        this.title = title;
    }

    public String sut;
    public String title;
}
