package com.adtu.model;

import java.time.LocalDate;
import java.util.Date;

public class Post {
    private int pid;
    private String title;
    private String content;
    private LocalDate date;
    private String uid;

    public Post() {
    }

    public Post(int pid, String title, String content, LocalDate date, String uid) {
        this.pid = pid;
        this.title = title;
        this.content = content;
        this.date = date;
        this.uid = uid;
    }


    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "Post{" +
                "pid=" + pid +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", date=" + date +
                ", uid=" + uid +
                '}';
    }

}
