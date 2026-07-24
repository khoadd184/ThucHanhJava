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
        String loi = layLoiValidationRieng();
        if (loi != null) {
            throw new Movievalidationexception(loi);
        }
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
    private String layLoiValidationRieng() {
        if (filmLength <= 0) {
            return "thoi luong phim > 0.";
        }
        if (boxOfficeRevenue < 0) {
            return "Doanh thu khong am.";
        }
        return null;
    }


    @Override
    public double calculatePrice() {
        return getPrice() * 1.3;
    }

    @Override
    public String toTitleColor() {
        return "Xanh";
    }

    @Override
    public String toString() {
        return super.toString() +
                " TheatricalFilm{filmLength=" + filmLength +
                ", boxOfficeRevenue=" + boxOfficeRevenue +
                '}';
    }
}