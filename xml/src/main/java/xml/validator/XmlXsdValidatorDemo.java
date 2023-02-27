package xml.validator;

import xml.validator.service.XmlXsdValidator;
import xml.validator.util.XmlUtils;

import static xml.validator.constant.XmlConstants.XML_FILEPATH_CLASSPATH;
import static xml.validator.constant.XmlConstants.XSD_FILEPATH_CLASSPATH;

public class XmlXsdValidatorDemo {

    public static void main(String[] args) {
        XmlXsdValidator xmlXsdValidator = new XmlXsdValidator();

        String xsdPath = XmlUtils.getPathFromClasspath(XSD_FILEPATH_CLASSPATH);
        String xmlPath = XmlUtils.getPathFromClasspath(XML_FILEPATH_CLASSPATH);
        boolean isXmlFileValid = xmlXsdValidator.isXmlFileValid(xsdPath, xmlPath);

        String messagePattern = "XSD file: '%s'\nXML file: '%s'\nIs Valid: '%b'\n";
        String message = String.format(messagePattern, xsdPath, xmlPath, isXmlFileValid);
        System.out.print(message);
    }
}
