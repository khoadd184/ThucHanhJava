package com.mycompany.movie;

import java.util.Date;

public class MainApp {
    public static void main(String[] args) {
        Movie movie = new Movie("1", "Avengers", "Phim sieu anh hung", 50000,
                "Action", "Marvel Studios", "Hanh dong", new Date());

        System.out.println(movie.toString());

        movie.setPrice(60000);
        System.out.println("Gia moi: " + movie.getPrice());
    }
}