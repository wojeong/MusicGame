package com.example.musicgame;

public class KdramaInfo {

    private String title;
    private int mp3Title;
    private String image;
    private boolean available;

    public KdramaInfo(String title, int mp3Title, String image) {
        this.title = title;
        this.mp3Title = mp3Title;
        this.image = image;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public int getMp3Title() {
        return mp3Title;
    }

    public String getImage() {
        return image;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
