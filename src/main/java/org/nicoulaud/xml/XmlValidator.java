package org.nicoulaud.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XmlValidator {

    public static void validateFile(File xmlFile, File xsdFile) throws SAXException, IOException {

        // 1. Lookup a factory for the W3C XML Schema language, version 1.1
        SchemaFactory factory = SchemaFactory.newInstance("http://www.w3.org/XML/XMLSchema/v1.1");

        // 2. Compile the schema.
        Schema schema = factory.newSchema(xsdFile);

        // 3. Get a validator from the schema.
        Validator validator = schema.newValidator();

        // 4. Parse the document you want to check.
        Source source = new StreamSource(xmlFile);

        // 5. Check the document
        try {
            validator.validate(source);
            System.out.println(xmlFile.getName() + " is valid.");
        } catch (SAXException ex) {
            System.err.println(xmlFile.getName() + " is not valid because ");
            System.err.println(ex.getMessage());
        }
    }

}