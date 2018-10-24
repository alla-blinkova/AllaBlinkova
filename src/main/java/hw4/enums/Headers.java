package hw4.enums;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum Headers {

    TITLE("Home Page");

    public String text;

    Headers(String text) {
        this.text = text;
    }

    public static List<String> getServiceCategories() {
        return new ArrayList<>(
                Arrays.asList(
                        "Support",
                        "Dates",
                        "Complex Table",
                        "Simple Table",
                        "Table With Pages",
                        "Different Elements")
        );
    }

}
