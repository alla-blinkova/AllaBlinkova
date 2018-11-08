package mobile.hw2.setup;

import mobile.hw2.enums.PropertyFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {
    Properties currentProps = new Properties();

    Properties getCurrentProps(PropertyFiles file) throws IOException {
        FileInputStream in = new FileInputStream(file.path);
        currentProps.load(in);
        in.close();
        return currentProps;
    }

    protected String getProp(String propKey) {
        return currentProps.getProperty(propKey, null);
    }
}
