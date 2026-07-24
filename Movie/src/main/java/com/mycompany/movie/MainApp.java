package com.mycompany.movie;

import java.util.Date;

public class MainApp {
    public static void main(String[] args) {

        // ---- Trường hợp 1: dữ liệu hợp lệ ----
        try {
            Movie tvSeries = new TVSeries("1", "Vinh Da Kieu", "Phim co trang Trung Quoc", 50000,
                    "TVSeries", "Dai truyen hinh Ho Nam", "Tam ly", new Date(),
                    40, 45);

            System.out.println(tvSeries.toString());
            System.out.println("Gia sau tinh toan: " + tvSeries.calculatePrice());
            System.out.println("Mau tieu de: " + tvSeries.toTitleColor());

        } catch (Movievalidationexception e) {
            System.out.println("Loi du lieu phim: " + e.getMessage());
        }

        System.out.println();
        try {
            Movie phimLoi = new TheatricalFilm("2", "Avengers", "Phim sieu anh hung", -80000,
                    "TheatricalFilm", "Marvel Studios", "Hanh dong", new Date(),
                    150, 2000000);

            System.out.println(phimLoi.toString());

        } catch (Movievalidationexception e) {
            System.out.println("Loi du lieu phim: " + e.getMessage());
        }

        System.out.println();

        try {
            Movie phimLoi2 = new TheatricalFilm("3", "Avatar 3", "Phim khoa hoc vien tuong", 80000,
                    "TheatricalFilm", "Hanh dong", "20th Century Studios", new Date(),
                    0, 2000000); 

            System.out.println(phimLoi2.toString());

        } catch (Movievalidationexception e) {
            System.out.println("Loi du lieu phim: " + e.getMessage());
        }

        try {
            Movie tvLoi = new TVSeries("4", "", "Phim test", 10000,
                    "TVSeries", "Test Studio", "Test", new Date(), 10, 30);
        } catch (Movievalidationexception e) {
            System.out.println("Loi du lieu phim: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Loi khong xac dinh: " + e.getMessage());
        }
    }
}