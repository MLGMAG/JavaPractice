package xml.parser.sax.service;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import xml.parser.sax.util.XmlSaxParserUtils;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.io.InputStream;

public class XmlSaxParser {

    public void parse(InputStream xmlInputStream, DefaultHandler handler) {
        SAXParserFactory factory = XmlSaxParserUtils.createSAXParserFactory();

        try {
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(xmlInputStream, handler);
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            throw new RuntimeException(ex);
        }
    }

}
