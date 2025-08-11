package com.adtu.model;

import java.time.LocalDate;

public class Comment {
    private int commentID;
    private int pID;
    private String uID;
    private String content;
    LocalDate date ;

    public Comment() {
    }

    public Comment(int commentID, int pID, String uID, String content, LocalDate date) {
        this.commentID = commentID;
        this.pID = pID;
        this.uID = uID;
        this.content = content;
        this.date = date;
    }

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getpID() {
        return pID;
    }

    public void setpID(int pID) {
        this.pID = pID;
    }

    public String getuID() {
        return uID;
    }

    public void setuID(String uID) {
        this.uID = uID;
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
}
