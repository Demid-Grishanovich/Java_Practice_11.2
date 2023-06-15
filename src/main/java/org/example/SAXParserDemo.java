package org.example;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.FileReader;
import java.util.List;

public class SAXParserDemo {
    public static void main(String[] args) throws Exception {
        XMLReader reader = XMLReaderFactory.createXMLReader();
        ResultHandler handler = new ResultHandler();
        reader.setContentHandler(handler);
        reader.parse(new InputSource(new FileReader("src/main/resources/results.xml")));

        List<Result> results = handler.getResults();
        for (Result result : results) {
            System.out.printf("%s;%s;%s\n" , result.getTest(), result.getStringDate(), result.getStringMark());
        }
    }
}