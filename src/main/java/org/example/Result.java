package org.example;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Result {
    private String login;
    private String test;
    private Date date;
    private int  mark;

    public Result() {
    }

    public Result(String login, String test, Date date, int  mark) {
        this.login = login;
        this.test = test;
        this.date = date;
        this.mark = mark;
    }

    public Result(String login, String test, String date, String  mark) {
        this.login = login;
        this.test = test;
        this.date = Date.valueOf(date);
        this.mark = Integer.parseInt(mark);
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public float getMark() {
        return mark;
    }

    public void setMark(int  mark) {
        this.mark = mark;
    }

    public void setMark(String mark) {

        this.mark = (int) (Float.parseFloat(mark) * 10);
    }

    public String getStringMark() {

        return String.format("%.1f", getMark() / 10.0);
    }

    private final static SimpleDateFormat OUTPUT_DATE_FORMAT =
            new SimpleDateFormat("dd.MM.yyyy");
    public String getStringDate() {
        return OUTPUT_DATE_FORMAT.format(date);
    }


    @Override
    public String toString() {
        return  test + ";" + getStringDate() + ";" + getStringMark();
    }
}



