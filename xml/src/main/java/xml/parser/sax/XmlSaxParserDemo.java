package xml.parser.sax;

import xml.parser.sax.handler.StudentClassHandler;
import xml.parser.sax.model.StudentClass;
import xml.parser.sax.service.XmlSaxParser;
import xml.util.XmlUtils;

import java.io.InputStream;
import java.util.stream.Collectors;

class XmlSaxParserDemo {

    private static final String XML_FILEPATH_CLASSPATH = "/students.xml";

    public static void main(String[] args) {
        XmlSaxParser xmlSaxParser = new XmlSaxParser();

        InputStream xmlInputStream = XmlUtils.getStreamFromClasspath(XML_FILEPATH_CLASSPATH);
        StudentClassHandler studentClassHandler = new StudentClassHandler();

        xmlSaxParser.parse(xmlInputStream, studentClassHandler);

        StudentClass studentClass = studentClassHandler.getResult();
        String result = studentClass.getStudents()
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));

        String messagePattern = "XML file: '%s'\nResult:\n%s";
        String message = messagePattern.formatted(XML_FILEPATH_CLASSPATH, result);
        System.out.println(message);
    }
}
