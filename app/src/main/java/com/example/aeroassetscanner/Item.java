package com.example.aeroassetscanner;

public class Item {

    private String title, content, location ,updated;

    public Item(String title, String content, String location, String updated) {
        this.title = title;
        this.content = content;
        this.location = location;
        this.updated = updated;
    }

    public Item() {


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

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
