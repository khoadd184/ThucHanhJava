package com.mycompany.movie;

import java.util.Date;

public class TVSeries extends Movie {
    private int episodes;
    private double avgEpisodeLength;

    public TVSeries() {
        super();
    }

    public TVSeries(String id, String name, String des, double price, String type,
                     String producer, String catagories, Date release,
                     int episodes, double avgEpisodeLength) {
        super(id, name, des, price, type, producer, catagories, release);
        this.episodes = episodes;
        this.avgEpisodeLength = avgEpisodeLength;
           String loi = layLoiValidationRieng();
        if (loi != null) {
            throw new Movievalidationexception(loi);
        }
    }

    public int getEpisodes() {
        return episodes;
    }
    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }
    public double getAvgEpisodeLength() {
        return avgEpisodeLength;
    }
    public void setAvgEpisodeLength(double avgEpisodeLength) {
        this.avgEpisodeLength = avgEpisodeLength;
    }
    private String layLoiValidationRieng() {
        if (episodes <= 0) {
            return "So tap phai lon hon 0.";
        }
        if (avgEpisodeLength <= 0) {
            return "Thoi luong moi tap phai lon hon 0.";
        }
        return null;
    }
    
    @Override
    public double calculatePrice() {
        return getPrice() * 0.7;
    }
    @Override
    public String toTitleColor() {
        return "Trắng";
    }

    @Override
    public String toString() {
        return super.toString() +
                " TVSeries{episodes=" + episodes +
                ", avgEpisodeLength=" + avgEpisodeLength +
                '}';
    }
}