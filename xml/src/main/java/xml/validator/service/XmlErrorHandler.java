package xml.validator.service;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class XmlErrorHandler implements ErrorHandler {

    private static final String WARNING = "Warning";
    private static final String ERROR = "Error";
    private static final String FATAL_ERROR = "Fatal Error";

    private Map<String, List<SAXParseException>> exceptions;

    public XmlErrorHandler() {
        this.exceptions = getEmptyExceptions();
    }

    private static List<String> exceptionsToMessages(String exceptionType, List<SAXParseException> exceptions) {
        String messagePattern = "[%s] %s";
        return exceptions.stream()
                .map(ex -> String.format(messagePattern, exceptionType, ex.getMessage()))
                .toList();
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

    public void printExceptions() {
        exceptions.entrySet().stream()
                .map(entry -> exceptionsToMessages(entry.getKey(), entry.getValue()))
                .flatMap(List::stream)
                .forEach(System.err::println);
    }
}
