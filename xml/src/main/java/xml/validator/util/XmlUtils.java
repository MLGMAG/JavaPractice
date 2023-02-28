package xml.validator.util;

import org.xml.sax.SAXException;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;
import xml.validator.context.XmlXsdValidationContext;
import xml.validator.context.XmlXsdValidatorCreationContext;
import xml.validator.service.XmlErrorHandler;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;
import java.io.InputStream;
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

    public static InputStream getStreamFromClasspath(String filepath) {
        InputStream resource = XmlUtils.class.getResourceAsStream(filepath);

        if (Objects.isNull(resource)) {
            String messagePattern = "Resource '%s' is empty";
            String message = String.format(messagePattern, filepath);
            throw new RuntimeException(message);
        }

        return resource;
    }

    public static Validator createXmlValidator(XmlXsdValidatorCreationContext creationContext) {
        InputStream xsdFileInputstream = creationContext.getXsdFileInputstream();
        Source schemaFile = new StreamSource(xsdFileInputstream);

        Validator validator;
        try {
            SchemaFactory schemaFactory = creationContext.getSchemaFactory();
            Schema schema = schemaFactory.newSchema(schemaFile);
            validator = schema.newValidator();
        } catch (SAXException ex) {
            throw new RuntimeException(ex);
        }

        XmlErrorHandler xmlErrorHandler = creationContext.getXmlErrorHandler();
        validator.setErrorHandler(xmlErrorHandler);
        return validator;
    }

    public static void validate(XmlXsdValidationContext validationContext) {
        Validator validator = validationContext.getValidator();
        InputStream xmlFileInputstream = validationContext.getXmlFileInputstream();
        try {
            StreamSource source = new StreamSource(xmlFileInputstream);
            validator.validate(source);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (SAXException ex) {
            throw new RuntimeException(ex);
        }
    }
}
