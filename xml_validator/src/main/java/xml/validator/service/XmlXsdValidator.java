package xml.validator.service;

import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;
import java.util.List;

import static xml.validator.util.XmlUtils.createSchemaFactory;

public class XmlXsdValidator {

    private final SchemaFactory schemaFactory;
    private final XmlErrorHandler xmlErrorHandler = new XmlErrorHandler();

    public XmlXsdValidator() {
        schemaFactory = createSchemaFactory();
    }

    public boolean isXmlFileValid(String xsdPath, String xmlPath) {
        Validator validator = getXmlValidator(xsdPath);

        try {
            File xmlFile = new File(xmlPath);
            validator.validate(new StreamSource(xmlFile));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (SAXException ex) {
            throw new RuntimeException(ex);
        }

        if (xmlErrorHandler.isEmpty()) {
            return true;
        } else {
            printExceptions();
            xmlErrorHandler.clear();
            return false;
        }
    }

    private void printExceptions() {
        xmlErrorHandler.getExceptions().entrySet().stream()
                .map(entry -> {
                    String messagePattern = "[%s] %s";
                    return entry.getValue()
                            .stream().map(ex -> String.format(messagePattern, entry.getKey(), ex.getMessage()))
                            .toList();
                })
                .flatMap(List::stream)
                .forEach(System.err::println);
    }

    private Validator getXmlValidator(String xsdFilePath) {
        File xmlFile = new File(xsdFilePath);
        Source schemaFile = new StreamSource(xmlFile);

        Validator validator;
        try {
            Schema schema = schemaFactory.newSchema(schemaFile);
            validator = schema.newValidator();
        } catch (SAXException ex) {
            throw new RuntimeException(ex);
        }

        validator.setErrorHandler(xmlErrorHandler);
        return validator;
    }
}
