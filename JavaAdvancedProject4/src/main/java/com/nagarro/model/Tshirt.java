package com.nagarro.model;


import jakarta.persistence.*;

@Entity
@Table(name = "shirt_detail")
public class Tshirt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "color")
    private String color;
    @Column(name = "gender")
    private String gender;
    @Column(name = "size")
    private String size;
    @Column(name = "price")
    private Double price;
    @Column(name = "rating")
    private Double rating;
    @Column(name = "availability")
    private String availability;

    public Tshirt(){

    }
    public Tshirt(String id, String name, String color,
                  String gender, String size, Double price,
                  Double rating, String availability) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.gender = gender;
        this.size = size;
        this.price = price;
        this.rating = rating;
        this.availability = availability;
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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public String toString() {
        return "Tshirt{" +
                "pid=" + pid +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", gender='" + gender + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", availability='" + availability + '\'' +
                '}';
    }
}
