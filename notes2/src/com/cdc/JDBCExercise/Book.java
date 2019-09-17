package com.cdc.JDBCExercise;

import java.util.Date;

/**
 * @program: notes2
 * @description: 实体类
 * @author: wujf
 * @create: 2019-08-23 11:37
 **/
public class Book {
    private int bno;
    private String bname;
    private String author;
    private String publish;
    private Date pubdate;

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bno=" + bno +
                ", bname='" + bname + '\'' +
                ", author='" + author + '\'' +
                ", publish='" + publish + '\'' +
                ", pubdate=" + pubdate +
                '}';
    }

}
