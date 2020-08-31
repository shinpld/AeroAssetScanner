package com.example.aeroassetscanner;

public class AssetItem {

    private String title, content,loca ,updated;

    public AssetItem(String title, String content, String loca, String updated) {
        this.title = title;
        this.content = content;
        this.loca = loca;
        this.updated = updated;
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

    public String getLoca() {
        return loca;
    }

    public void setLoca(String loca) {
        this.loca = loca;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }
}
