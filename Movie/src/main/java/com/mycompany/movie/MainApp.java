package com.mycompany.movie;

import java.util.Date;

public class MainApp {
    public static void main(String[] args) {
        // Movie giờ là abstract nên không new Movie(...) trực tiếp được nữa
        Movie tvSeries = new TVSeries("1", "Vinh Da Kieu", "Phim co trang Trung Quoc", 50000,
                "TVSeries", "Dai truyen hinh Ho Nam", "Tam ly", new Date(),
                40, 45);

        Movie theatricalFilm = new TheatricalFilm("2", "Avengers", "Phim sieu anh hung", 80000,
                "TheatricalFilm", "Marvel Studios", "Hanh dong", new Date(),
                150, 2000000);

        System.out.println(tvSeries.toString());
        System.out.println("Gia sau tinh toan: " + tvSeries.calculatePrice());
        System.out.println("Mau tieu de: " + tvSeries.toTitleColor());

        System.out.println();

        System.out.println(theatricalFilm.toString());
        System.out.println("Gia sau tinh toan: " + theatricalFilm.calculatePrice());
        System.out.println("Mau tieu de: " + theatricalFilm.toTitleColor());
    }
}