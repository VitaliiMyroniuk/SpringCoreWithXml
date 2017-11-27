package com.epam.myroniuk.entity;

import java.text.DateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author Vitalii Myroniuk
 */
public class Event {
    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, String msg, DateFormat df) {
        this.id = new Random().nextInt(100);
        this.msg = msg;
        this.date = date;
        this.df = df;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}';
    }
}
