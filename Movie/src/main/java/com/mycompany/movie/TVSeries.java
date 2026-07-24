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