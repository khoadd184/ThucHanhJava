package com.mycompany.movie;

import javax.swing.SwingUtilities;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainApp {
    public static void main(String[] args) {

        List<Movie> danhSachPhim = new ArrayList<>();
        try {
            Movie tvSeries = new TVSeries("1", "Vinh Da Kieu", "Phim co trang Trung Quoc", 50000,
                    "TVSeries", "Dai truyen hinh Ho Nam", "Tam ly", new Date(),
                    40, 45);
            danhSachPhim.add(tvSeries);
        } catch (Movievalidationexception e) {
            System.out.println("Loi du lieu phim: " + e.getMessage());
        }

        try {
            Movie theatricalFilm = new TheatricalFilm("2", "Avengers", "Phim sieu anh hung", 80000,
                    "TheatricalFilm", "Marvel Studios", "Hanh dong", new Date(),
                    150, 2000000);
            danhSachPhim.add(theatricalFilm);
        } catch (Movievalidationexception e) {
            System.out.println("Loi du lieu phim: " + e.getMessage());
        }
        try {
            Movie phimLoi = new TheatricalFilm("3", "Avatar 3", "Phim khoa hoc vien tuong", -80000,
                    "TheatricalFilm", "20th Century Studios", "Hanh dong", new Date(),
                    150, 2000000);
            danhSachPhim.add(phimLoi);
        } catch (Movievalidationexception e) {
            System.out.println("Loi du lieu phim (bo qua, khong hien thi): " + e.getMessage());
        }

        SwingUtilities.invokeLater(() -> new MovieFrame(danhSachPhim).setVisible(true));
    }
}