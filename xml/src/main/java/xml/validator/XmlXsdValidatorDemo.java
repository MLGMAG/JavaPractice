package xml.validator;

import xml.util.XmlUtils;
import xml.validator.service.XmlXsdValidator;

import java.io.InputStream;

public class XmlXsdValidatorDemo {

    public static final String XSD_FILEPATH_CLASSPATH = "/students.xsd";
    public static final String XML_FILEPATH_CLASSPATH = "/students.xml";

    public static void main(String[] args) {
        XmlXsdValidator xmlXsdValidator = new XmlXsdValidator();

        InputStream xsdInputStream = XmlUtils.getStreamFromClasspath(XSD_FILEPATH_CLASSPATH);
        InputStream xmlInputStream = XmlUtils.getStreamFromClasspath(XML_FILEPATH_CLASSPATH);

        boolean isXmlFileValid = xmlXsdValidator.isXmlFileValid(xsdInputStream, xmlInputStream);

        String messagePattern = "XSD file: '%s'\nXML file: '%s'\nIs Valid: '%b'\n";
        String message = String.format(messagePattern, XSD_FILEPATH_CLASSPATH, XML_FILEPATH_CLASSPATH, isXmlFileValid);
        System.out.print(message);
    }
}
