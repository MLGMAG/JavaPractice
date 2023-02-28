package xml.parser.sax.context;

import lombok.Builder;
import lombok.Getter;
import xml.parser.sax.model.Student;

@Getter
@Builder
public class StudentClassHandlerContext {

    private String value;
    private Student student;

}
