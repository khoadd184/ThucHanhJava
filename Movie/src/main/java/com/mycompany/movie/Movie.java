package com.mycompany.movie;

import java.util.Date;

public abstract class Movie implements Imovieaction {
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
        String loi = layLoiValidation();
        if (loi != null) {
            throw new Movievalidationexception(loi);
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

    protected String layLoiValidation() {
        if (name == null || name.trim().isEmpty()) {
            return "Ten phim khong duoc de trong.";
        }
        if (price < 0) {
            return "Gia phim khong duoc am.";
        }
        return null; 
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

    @Override
    public abstract double calculatePrice();

    @Override
    public abstract String toTitleColor();
}