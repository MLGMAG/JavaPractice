package xml.validator.service.xmlXsdValidator;

import xml.validator.util.XmlUtils;

import java.io.File;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class XmlXsdValidatorIntegrationTestUtils {

    private XmlXsdValidatorIntegrationTestUtils() {
    }

    public static List<XmlXsdValidatorIntegrationTestContext> parseCases(String filepath) {
        String pathFromClasspath = XmlUtils.getPathFromClasspath(filepath);

        File casesDir = new File(pathFromClasspath);

        return getInnerFiles(casesDir)
                .stream()
                .filter(file -> !getInnerFiles(file).isEmpty())
                .map(XmlXsdValidatorIntegrationTestUtils::caseFileToContext)
                .collect(Collectors.toList());
    }

    private static List<File> getInnerFiles(File file) {
        File[] files = Optional.ofNullable(file.listFiles()).orElse(new File[]{});
        return Arrays.asList(files);
    }

    private static XmlXsdValidatorIntegrationTestContext caseFileToContext(File caseFile) {
        String dataPath = Paths.get(caseFile.getPath(), XmlXsdValidatorIntegrationConstants.DATA_FILENAME).toString();
        String schemaPath = Paths.get(caseFile.getPath(), XmlXsdValidatorIntegrationConstants.SCHEMA_FILENAME).toString();
        return XmlXsdValidatorIntegrationTestContext.builder()
                .schemaPath(schemaPath)
                .dataPath(dataPath)
                .build();
    }
}
