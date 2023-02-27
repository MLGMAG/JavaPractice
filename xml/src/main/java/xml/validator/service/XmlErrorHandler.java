package xml.validator.service;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

import java.util.*;

public class XmlErrorHandler implements ErrorHandler {

    private static final String WARNING = "Warning";
    private static final String ERROR = "Error";
    private static final String FATAL_ERROR = "Fatal Error";

    private Map<String, List<SAXParseException>> exceptions;

    public XmlErrorHandler() {
        this.exceptions = getEmptyExceptions();
    }

    public Map<String, List<SAXParseException>> getExceptions() {
        return exceptions;
    }

    @Override
    public void warning(SAXParseException exception) {
        exceptions.get(WARNING).add(exception);
    }

    @Override
    public void error(SAXParseException exception) {
        exceptions.get(ERROR).add(exception);
    }

    @Override
    public void fatalError(SAXParseException exception) {
        exceptions.get(FATAL_ERROR).add(exception);
    }

    public void clear() {
        exceptions = getEmptyExceptions();
    }

    public boolean isEmpty() {
        return exceptions.values()
                .stream()
                .allMatch(List::isEmpty);
    }

    private Map<String, List<SAXParseException>> getEmptyExceptions() {
        Map<String, List<SAXParseException>> emptyExceptions = new HashMap<>();
        emptyExceptions.put(WARNING, new ArrayList<>());
        emptyExceptions.put(ERROR, new ArrayList<>());
        emptyExceptions.put(FATAL_ERROR, new ArrayList<>());
        return emptyExceptions;
    }

}
