package xml.parser.sax.handler;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;
import xml.parser.sax.constant.StudentTag;
import xml.parser.sax.context.StudentClassHandlerContext;
import xml.parser.sax.model.Student;
import xml.parser.sax.model.StudentClass;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;

import static xml.parser.sax.constant.StudentTag.*;

public class StudentClassHandler extends DefaultHandler {

    private final StringBuilder currentValue = new StringBuilder();
    private StudentClass result;
    private Student currentStudent;

    private static final Map<StudentTag, Consumer<StudentClassHandlerContext>> HANDLERS_MAP = new EnumMap<>(StudentTag.class);

    static {
        HANDLERS_MAP.put(FIRST_NAME_TAG, StudentClassHandlers::handleFirstname);
        HANDLERS_MAP.put(LAST_NAME_TAG, xml.parser.sax.handler.StudentClassHandlers::handleLastname);
        HANDLERS_MAP.put(NICKNAME_TAG, xml.parser.sax.handler.StudentClassHandlers::handleNickname);
        HANDLERS_MAP.put(MARKS_TAG, xml.parser.sax.handler.StudentClassHandlers::handleMarks);
    }

    @Override
    public void startDocument() {
        result = StudentClass.createEmptyStudentClass();
    }

    @Override
    public void startElement(String uri, String localName, String qualifierName, Attributes attributes) {
        currentValue.setLength(0);

        String studentTagTitle = STUDENT_TAG.getTitle();
        if (qualifierName.equalsIgnoreCase(studentTagTitle)) {
            currentStudent = new Student();

            String rollNumberAttributeTitle = ROLL_NUMBER_ATTRIBUTE.getTitle();
            String rollNumberRaw = attributes.getValue(rollNumberAttributeTitle);
            int rollNumber = Integer.parseInt(rollNumberRaw);
            currentStudent.setRollNumber(rollNumber);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qualifierName) {
        String qualifierLowerCase = qualifierName.toLowerCase();
        boolean isHandlerExists = getAllTitles().contains(qualifierLowerCase);
        if (isHandlerExists) {
            handleTag(qualifierName);
        }

        String studentTagTitle = STUDENT_TAG.getTitle();
        if (qualifierLowerCase.equals(studentTagTitle)) {
            result.addStudent(currentStudent);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        currentValue.append(ch, start, length);
    }

    private void handleTag(String qualifierName) {
        String value = currentValue.toString();

        StudentClassHandlerContext context = StudentClassHandlerContext.builder()
                .student(currentStudent)
                .value(value)
                .build();

        StudentTag studentTag = StudentTag.fromTitle(qualifierName);
        Optional.ofNullable(HANDLERS_MAP.get(studentTag)).ifPresent(handler -> handler.accept(context));
    }

    public StudentClass getResult() {
        return result;
    }

}
