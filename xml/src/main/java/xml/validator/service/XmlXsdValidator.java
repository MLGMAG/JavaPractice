package xml.validator.service;

import xml.validator.context.XmlXsdValidationContext;
import xml.validator.context.XmlXsdValidatorCreationContext;
import xml.validator.util.XmlUtils;

import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class XmlXsdValidator {

    private final SchemaFactory schemaFactory;
    private final XmlErrorHandler xmlErrorHandler = new XmlErrorHandler();

    public XmlXsdValidator() {
        schemaFactory = XmlUtils.createSchemaFactory();
    }

    public boolean isXmlFileValid(String xsdPath, String xmlPath) {
        try (
                FileInputStream xsdFileInputStream = new FileInputStream(xsdPath);
                FileInputStream xmlFileInputStream = new FileInputStream(xmlPath)
        ) {
            return isXmlFileValid(xsdFileInputStream, xmlFileInputStream);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public boolean isXmlFileValid(InputStream xsdInputStream, InputStream xmlInputStream) {
        XmlXsdValidatorCreationContext creationContext = XmlXsdValidatorCreationContext.builder()
                .xsdFileInputstream(xsdInputStream)
                .xmlErrorHandler(xmlErrorHandler)
                .schemaFactory(schemaFactory)
                .build();
        Validator validator = XmlUtils.createXmlValidator(creationContext);

        XmlXsdValidationContext xmlXsdValidationContext = XmlXsdValidationContext.builder()
                .xmlFileInputstream(xmlInputStream)
                .validator(validator)
                .build();
        XmlUtils.validate(xmlXsdValidationContext);

        boolean isValid = xmlErrorHandler.isEmpty();

        if (!isValid) {
            xmlErrorHandler.printExceptions();
        }

        xmlErrorHandler.clear();

        return isValid;
    }
}
