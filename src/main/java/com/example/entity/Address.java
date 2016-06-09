package com.example.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;

/**
 * Created by szymon on 08.06.16.
 */
@Entity
@Table(name = "addres")
public class Address {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @NotEmpty
    @Column
    private String street;

    @NotEmpty
    @Column
    private String homeNumber;

    @NotEmpty
    @Column
    private String city;

    @NotEmpty
    @Column
    private String postalCode;

    public Long getId() {
        return id;
    }

    public Address setId(Long id) {
        this.id = id;
        return this;
    }

    public String getStreet() {
        return street;
    }

    public Address setStreet(String street) {
        this.street = street;
        return this;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public Address setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public Address setPostalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }
}
