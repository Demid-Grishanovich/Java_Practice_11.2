package org.example;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


public class ResultHandler extends DefaultHandler {
    private enum ResultEnum {
        RESULTS, STUDENT, LOGIN, TESTS, TEST
    }

    private final List<Result> results = new ArrayList<>();
    private ResultEnum currentEnum;
    private String login;

    public List<Result> getResults() {
        return results;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)  throws SAXException {
        currentEnum = ResultEnum.valueOf(localName.toUpperCase());

        if (currentEnum == ResultEnum.TEST) {
            final int TEST_INDEX = 0, DATE_INDEX = 1, MARK_INDEX = 2;
            String test = attributes.getValue(TEST_INDEX);
            String dateStr = attributes.getValue(DATE_INDEX);
            String markStr = attributes.getValue(MARK_INDEX);

            if (login != null && test != null && dateStr != null && markStr != null) {
                Date date = Date.valueOf(dateStr);
                int mark = (int) Math.round(Double.parseDouble(markStr) * 10);

                Result result = new Result();
                result.setLogin(login);
                result.setTest(test);
                result.setDate(date);
                result.setMark(mark);

                results.add(result);
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException  {
        if (currentEnum == ResultEnum.LOGIN) {
            String str = new String(ch, start, length).trim();
            if (!str.isEmpty()) {
                login = str;
            }
        }
    }
}

