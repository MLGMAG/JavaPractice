package xml.validator.util;

import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

import javax.xml.XMLConstants;
import javax.xml.validation.SchemaFactory;
import java.net.URL;
import java.util.Objects;

public class XmlUtils {

    private XmlUtils() {
    }

    public static SchemaFactory createSchemaFactory() {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        try {
            schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_DTD, "");
            schemaFactory.setProperty(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        } catch (SAXNotRecognizedException ex) {
            throw new RuntimeException(ex);
        } catch (SAXNotSupportedException ex) {
            throw new RuntimeException(ex);
        }
        return schemaFactory;
    }

    public static String getPathFromClasspath(String filepath) {
        URL resource = XmlUtils.class.getResource(filepath);

        if (Objects.isNull(resource)) {
            String messagePattern = "Resource '%s' is empty";
            String message = String.format(messagePattern, filepath);
            throw new RuntimeException(message);
        }

        return resource.getPath();
    }
}
