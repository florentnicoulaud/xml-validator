package org.nicoulaud.xml;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
import org.xml.sax.SAXException;

public class TestXmlValidator {

    @Test
    public void validateXmlToXsd() throws IOException, SAXException {
        XmlValidator.validateFile(new File("src/test/resources/test.xml"), new File("src/test/resources/test.xsd"));
    }
}
