package org.example;

import java.sql.Date;

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
        // Convert the mark to a floating-point number with one decimal place
        return String.format("%.1f", getMark() / 10.0);
    }

    @Override
    public String toString() {
        return  test + ";" + date + ";" + getStringMark();
    }
}



