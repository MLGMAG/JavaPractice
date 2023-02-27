package xml.validator.service.xmlXsdValidator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import xml.validator.service.XmlXsdValidator;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class XmlXsdValidatorIntegrationTest {

    private final XmlXsdValidator testInstance = new XmlXsdValidator();

    @ParameterizedTest
    @MethodSource("provideShouldCheckInvalidXmlFile")
    void shouldCheckInvalidXmlFile(XmlXsdValidatorIntegrationTestContext context) {
        boolean actual = testInstance.isXmlFileValid(context.getSchemaPath(), context.getDataPath());
        assertThat(actual).isFalse();
    }

    private static Stream<Arguments> provideShouldCheckInvalidXmlFile() {
        return XmlXsdValidatorIntegrationTestUtils.parseCases(XmlXsdValidatorIntegrationConstants.INVALID_TEST_CASES_DIR_PATH).stream().map(Arguments::of);
    }

    @ParameterizedTest
    @MethodSource("provideShouldCheckValidXmlFile")
    void shouldCheckValidXmlFile(XmlXsdValidatorIntegrationTestContext context) {
        boolean actual = testInstance.isXmlFileValid(context.getSchemaPath(), context.getDataPath());
        assertThat(actual).isTrue();
    }

    private static Stream<Arguments> provideShouldCheckValidXmlFile() {
        return XmlXsdValidatorIntegrationTestUtils.parseCases(XmlXsdValidatorIntegrationConstants.VALID_TEST_CASES_DIR_PATH).stream().map(Arguments::of);
    }
}

