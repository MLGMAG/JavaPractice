package xml.parser.sax.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Student {

    private int rollNumber;
    private String firstname;
    private String lastname;
    private String nickname;
    private int marks;

}
