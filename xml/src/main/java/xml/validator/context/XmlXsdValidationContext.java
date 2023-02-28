package xml.validator.context;

import lombok.Builder;
import lombok.Getter;

import javax.xml.validation.Validator;
import java.io.InputStream;

@Getter
@Builder
public class XmlXsdValidationContext {

    private final InputStream xmlFileInputstream;
    private final Validator validator;

    public XmlXsdValidationContext(InputStream xmlFileInputstream, Validator validator) {
        this.xmlFileInputstream = xmlFileInputstream;
        this.validator = validator;
    }

}
