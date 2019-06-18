package com.example.json;

import com.google.gson.annotations.SerializedName;

public class Todo {
    private int userId;
    private int id;
    @SerializedName("title")
    private String body;
    private boolean completed;

    public Todo() {
    }

    public Todo(int userId, int id, String title, boolean completed) {
        this.userId = userId;
        this.id = id;
        this.body = title;
        this.completed = completed;
    }

    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    //    public String getTitle() {
//        return body;
//    }

    public boolean isCompleted() {
        return completed;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "userId=" + userId +
                ", id=" + id +
                ", body='" + body + '\'' +
                ", completed=" + completed +
                '}';
    }
}
