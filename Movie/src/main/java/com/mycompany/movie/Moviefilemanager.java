package com.mycompany.movie;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Moviefilemanager {

    private static final String NGAN_CACH = "\\|";
    private static final SimpleDateFormat DINH_DANG_NGAY = new SimpleDateFormat("dd/MM/yyyy");

    public static void ghiFile(String duongDan, List<Movie> danhSachPhim, boolean tiepNoi) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(duongDan, tiepNoi)) {

            for (Movie m : danhSachPhim) {
                String dong = taoDongText(m);
                if (dong == null) continue; 

                byte[] bytes = (dong + System.lineSeparator()).getBytes("UTF-8");
                fos.write(bytes);
            }
        }
    }

    private static String taoDongText(Movie m) {
        StringBuilder sb = new StringBuilder();

        if (m instanceof TVSeries tv) {
            sb.append("TVSeries|")
              .append(tv.getId()).append("|")
              .append(tv.getName()).append("|")
              .append(tv.getDes()).append("|")
              .append(tv.getPrice()).append("|")
              .append(tv.getType()).append("|")
              .append(tv.getProducerId()).append("|")
              .append(tv.getCatagories()).append("|")
              .append(DINH_DANG_NGAY.format(tv.getRelease())).append("|")
              .append(tv.getEpisodes()).append("|")
              .append(tv.getAvgEpisodeLength());

        } else if (m instanceof TheatricalFilm tf) {
            sb.append("TheatricalFilm|")
              .append(tf.getId()).append("|")
              .append(tf.getName()).append("|")
              .append(tf.getDes()).append("|")
              .append(tf.getPrice()).append("|")
              .append(tf.getType()).append("|")
              .append(tf.getProducerId()).append("|")
              .append(tf.getCatagories()).append("|")
              .append(DINH_DANG_NGAY.format(tf.getRelease())).append("|")
              .append(tf.getFilmLength()).append("|")
              .append(tf.getBoxOfficeRevenue());
        } else {
            return null;
        }
        return sb.toString();
    }

    public static List<Movie> docFile(String duongDan) throws IOException, ParseException {
        List<Movie> ketQua = new ArrayList<>();

        byte[] toanBoByte;
        try (FileInputStream fis = new FileInputStream(duongDan)) {
            toanBoByte = fis.readAllBytes(); 
        }

        String noiDung = new String(toanBoByte, "UTF-8");
        String[] cacDong = noiDung.split("\\r?\\n");

        int soDong = 0;
        for (String dong : cacDong) {
            soDong++;
            if (dong.trim().isEmpty()) continue;

            String[] cot = dong.split(NGAN_CACH, -1);

            try {
                String loai = cot[0];
                String id = cot[1];
                String name = cot[2];
                String des = cot[3];
                double price = Double.parseDouble(cot[4]);
                String type = cot[5];
                String producer = cot[6];
                String catagories = cot[7];
                Date release = DINH_DANG_NGAY.parse(cot[8]);

                if ("TVSeries".equals(loai)) {
                    int episodes = Integer.parseInt(cot[9]);
                    double avgEpisodeLength = Double.parseDouble(cot[10]);
                    ketQua.add(new TVSeries(id, name, des, price, type, producer,
                            catagories, release, episodes, avgEpisodeLength));

                } else if ("TheatricalFilm".equals(loai)) {
                    double filmLength = Double.parseDouble(cot[9]);
                    double boxOfficeRevenue = Double.parseDouble(cot[10]);
                    ketQua.add(new TheatricalFilm(id, name, des, price, type, producer,
                            catagories, release, filmLength, boxOfficeRevenue));
                }

            } catch (Movievalidationexception | NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.out.println("Bo qua dong " + soDong + " do loi: " + e.getMessage());
            }
        }

        return ketQua;
    }
}