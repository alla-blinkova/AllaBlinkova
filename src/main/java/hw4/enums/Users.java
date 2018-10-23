package hw4.enums;

public enum Users {

    PITER_CHAILOVSKII("epam", "1234", "Piter Chailovskii");

    public String login;
    public String password;
    public String fullName;

    Users(String login, String password, String fullName) {
        this.login = login;
        this.password = password;
        this.fullName = fullName;
    }
}
