package xml.validator.context;

import lombok.Builder;
import lombok.Getter;
import xml.validator.service.XmlErrorHandler;

import javax.xml.validation.SchemaFactory;
import java.io.InputStream;

@Getter
@Builder
public class XmlXsdValidatorCreationContext {

    private final InputStream xsdFileInputstream;
    private final XmlErrorHandler xmlErrorHandler;
    private final SchemaFactory schemaFactory;

    public XmlXsdValidatorCreationContext(InputStream xsdFileInputstream, XmlErrorHandler xmlErrorHandler, SchemaFactory schemaFactory) {
        this.xsdFileInputstream = xsdFileInputstream;
        this.xmlErrorHandler = xmlErrorHandler;
        this.schemaFactory = schemaFactory;
    }

}
