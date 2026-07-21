package com.mycompany.movie;
import java.util.Date;

public class Movie{
    private String id;
    private String name;
    private String des;
    private double price;
    private String type;
    private String producerid;
    private String catagories;
    private Date release;
    public Movie() {
        this.name = "A";
    }

    public Movie(String id, String name, String des, double price, String type,
                 String producer, String catagories, Date release) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.price = price;
        this.type = type;
        this.producerid = producer;
        this.catagories = catagories;
        this.release = release;
        if (!validation()) {
        throw new IllegalArgumentException("Dữ liệu Movie không hợp lệ!");
    }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getProducerId() {
        return producerid;
    }

    public void setProducer(String producer) {
        this.producerid = producer;
    }

    public String getCatagories() {
        return catagories;
    }

    public void setCatagories(String catagories) {
        this.catagories = catagories;
    }

    public Date getRelease() {
        return release;
    }

    public void setRelease(Date release) {
        this.release = release;
    }

    private boolean validation() {
        if (name == null || name.trim().isEmpty()) {
            return false;
        }
        if (price < 0) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", des='" + des + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", producer='" + producerid + '\'' +
                ", catagories='" + catagories + '\'' +
                ", release=" + release +
                '}';
    }
}