package hw4.enums;

import javafx.scene.control.RadioButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum DifferentElements {

    CHECKBOX("%s: condition changed to %b"),
    RADIOBUTTON("metal: value changed to "),
    DROPDOWN("Colors: value changed to "),
    TO_SLIDER("Range 2(To):%d link clicked"),
    FROM_SLIDER("Range 2(From):%d link clicked");

    public String logText;

    DifferentElements(String logText) {
        this.logText = logText;
    }

}
