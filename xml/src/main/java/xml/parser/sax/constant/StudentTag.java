package xml.parser.sax.constant;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum StudentTag {

    STUDENT_TAG("student"),
    FIRST_NAME_TAG("firstname"),
    LAST_NAME_TAG("lastname"),
    NICKNAME_TAG("nickname"),
    MARKS_TAG("marks"),
    ROLL_NUMBER_ATTRIBUTE("rollno");

    private final String title;
    private static final Set<String> ALL_TITLES = createAllTitles();
    private static final Map<String, StudentTag> TITLE_MAP = createTitleMap();

    StudentTag(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public static Set<String> getAllTitles() {
        return ALL_TITLES;
    }

    public static StudentTag fromTitle(String title) {
        return Optional.ofNullable(TITLE_MAP.get(title)).orElseThrow();
    }

    private static Set<String> createAllTitles() {
        return Arrays.stream(StudentTag.values())
                .map(StudentTag::getTitle)
                .collect(Collectors.toSet());
    }

    private static Map<String, StudentTag> createTitleMap() {
        return Arrays.stream(StudentTag.values())
                .collect(Collectors.toMap(StudentTag::getTitle, Function.identity()));
    }
}
