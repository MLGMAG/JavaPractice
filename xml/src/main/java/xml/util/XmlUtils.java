package xml.util;

import xml.validator.util.XmlXsdValidatorUtils;

import java.io.InputStream;
import java.util.Objects;

public class XmlUtils {

    private XmlUtils() {
    }

    public static InputStream getStreamFromClasspath(String filepath) {
        InputStream resource = XmlXsdValidatorUtils.class.getResourceAsStream(filepath);

        if (Objects.isNull(resource)) {
            String messagePattern = "Resource '%s' is empty";
            String message = String.format(messagePattern, filepath);
            throw new RuntimeException(message);
        }

        return resource;
    }

}
