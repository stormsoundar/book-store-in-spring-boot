package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "book")

public class Book{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "decription")
    private String decription;

    @Column(name = "year_of_publication")
    private Integer yearOfPublication;

    @Column(name = "book_type")
    private String bookType;

    @Column(name = "price")
    private Integer price;

    public Book() {

    }
    public Book(Long id,
                String name,
                String decription,
                Integer yearOfPublication,
                String bookType,
                Integer price) {
        this.id = id;
        this.name = name;
        this.decription = decription;
        this.yearOfPublication = yearOfPublication;
        this.bookType = bookType;
        this.price = price;
    }

    public Long getId() { return id; }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public Integer getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(Integer yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
