package xml.parser.sax.handler;

import xml.parser.sax.context.StudentClassHandlerContext;
import xml.parser.sax.model.Student;

public class StudentClassHandlers {

    private StudentClassHandlers() {
    }

    public static void handleFirstname(StudentClassHandlerContext context) {
        String value = context.getValue();
        Student student = context.getStudent();
        student.setFirstname(value);
    }

    public static void handleLastname(StudentClassHandlerContext context) {
        String value = context.getValue();
        Student student = context.getStudent();
        student.setLastname(value);
    }

    public static void handleNickname(StudentClassHandlerContext context) {
        String value = context.getValue();
        Student student = context.getStudent();
        student.setNickname(value);
    }

    public static void handleMarks(StudentClassHandlerContext context) {
        String value = context.getValue();
        Student student = context.getStudent();

        int marks = Integer.parseInt(value);
        student.setMarks(marks);
    }
}
