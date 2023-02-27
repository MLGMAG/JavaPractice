package xml.validator.service.xmlXsdValidator;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class XmlXsdValidatorIntegrationTestContext {
    private final String dataPath;
    private final String schemaPath;
}
