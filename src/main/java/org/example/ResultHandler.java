package org.example;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ResultHandler extends DefaultHandler {
    private enum ResultEnum {RESULTS, STUDENT, LOGIN, TESTS, TEST}

    private final List<Result> results = new ArrayList<>();
    private Result currentResult = null;
    private String currentLogin = null;
    private ResultEnum currentEnum = null;

    public List<Result> getResults() {
        return results;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        try {
            currentEnum = ResultEnum.valueOf(localName.toUpperCase());
        } catch (IllegalArgumentException e) {
            // Ignore unhandled tags
            currentEnum = null;
            return;
        }

        if (currentEnum == ResultEnum.TEST) {
            currentResult = new Result();
            currentResult.setLogin(currentLogin);
            currentResult.setTest(attributes.getValue("name"));
            currentResult.setDate(Date.valueOf(attributes.getValue("date")));
            // Store the mark as an integer, rounded to the nearest whole number
            String strMark = attributes.getValue("mark");
            currentResult.setMark((int) Math.round(Double.valueOf(strMark) * 10));
            results.add(currentResult);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (currentEnum == ResultEnum.LOGIN) {
            currentLogin = new String(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (localName.equalsIgnoreCase("test")) {
            currentResult = null;
        }
    }
}

