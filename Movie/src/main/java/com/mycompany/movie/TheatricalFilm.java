package com.mycompany.movie;

import java.util.Date;

public class TheatricalFilm extends Movie {
    private double filmLength;
    private double boxOfficeRevenue;

    public TheatricalFilm() {
        super();
    }

    public TheatricalFilm(String id, String name, String des, double price, String type,
                          String producer, String catagories, Date release,
                          double filmLength, double boxOfficeRevenue) {
        super(id, name, des, price, type, producer, catagories, release);
        this.filmLength = filmLength;
        this.boxOfficeRevenue = boxOfficeRevenue;
    }

    public double getFilmLength() {
        return filmLength;
    }

    public void setFilmLength(double filmLength) {
        this.filmLength = filmLength;
    }

    public double getBoxOfficeRevenue() {
        return boxOfficeRevenue;
    }

    public void setBoxOfficeRevenue(double boxOfficeRevenue) {
        this.boxOfficeRevenue = boxOfficeRevenue;
    }

    @Override
    public String toString() {
        return super.toString() +
                " TheatricalFilm{filmLength=" + filmLength +
                ", boxOfficeRevenue=" + boxOfficeRevenue +
                '}';
    }
}