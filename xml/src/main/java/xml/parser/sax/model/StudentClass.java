package xml.parser.sax.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class StudentClass {

    private final List<Student> students;

    public StudentClass(List<Student> students) {
        if (Objects.isNull(students)) {
            students = new ArrayList<>();
        }

        this.students = students;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public static StudentClass createEmptyStudentClass() {
        List<Student> studentList = new ArrayList<>();
        return new StudentClass(studentList);
    }
}
