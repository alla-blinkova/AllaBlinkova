package hw3.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Headers {

    TITLE("Home Page"),
    MAIN_HEADER("EPAM FRAMEWORK WISHES…"),
    SECONDARY_HEADER("LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
            "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
            "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE " +
            "IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR."),
    SUB_HEADER("JDI GITHUB");

    public String text;

    Headers(String text) {
        this.text = text;
    }

    public static List<String> getMenuHeaders() {
        return new ArrayList<>(
                Arrays.asList(
                        "HOME",
                        "CONTACT FORM",
                        "SERVICE",
                        "METALS & COLORS")
        );
    }

    public static List<String> getIconHeaders() {
        return new ArrayList<>(
                Arrays.asList(
                        "To include good practices\n" +
                                "and ideas from successful\n" +
                                "EPAM project",
                        "To be flexible and\n" +
                                "customizable",
                        "To be multiplatform",
                        "Already have good base\n" +
                                "(about 20 internal and\n" +
                                "some external projects),\n" +
                                "wish to get more…")
        );
    }

}
