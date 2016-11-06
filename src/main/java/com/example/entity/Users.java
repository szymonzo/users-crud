package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class Users {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column
    private String name;

    @Column
    private String lastName;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String pesel;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Address address;

    public Long getId() {
        return id;
    }

    public Users setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Users setName(String name) {
        this.name = name;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public Users setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public Users setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getPesel() {
        return pesel;
    }

    public Users setPesel(String pesel) {
        this.pesel = pesel;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Users setAddress(Address address) {
        this.address = address;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public Users setEmail(String email) {
        this.email = email;
        return this;
    }
}
