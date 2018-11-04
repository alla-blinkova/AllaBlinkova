package hw5.enums;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum ServiceCategories {

    SUPPORT("Support"),
    DATES("Dates"),
    COMPLEX_TABLE("Complex Table"),
    SIMPLE_TABLE("Simple Table"),
    TABLE_WITH_PAGES("Table With Pages"),
    DIFFERENT_ELEMENTS("Different Elements");

    public String categoryName;

    ServiceCategories(String categoryName) {
        this.categoryName = categoryName;
    }

    public static List<String> getCategories() {
        return Arrays.stream(ServiceCategories.values()).map(x -> x.categoryName).collect(Collectors.toList());
    }
}
