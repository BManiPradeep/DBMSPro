package com.example.DBMSPro.Models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Period;

@Entity
@Table(name="USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long  id;
    private String fname;
    private String lname;
    private String username;
    private String email;
    private String password;
    private String city;
    private String street;
    private Long pin;

    private LocalDate dob;
    @Transient
    private Integer age;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Long getPin() {
        return pin;
    }

    public void setPin(Long pin) {
        this.pin = pin;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User(Long user_id, String user_fname, String user_lname, String username, String user_email, String user_password, String city, String street, Long pin, LocalDate dob) {
        this.id = user_id;
        this.fname = user_fname;
        this.lname = user_lname;
        this.username = username;
        this.email = user_email;
        this.password = user_password;
        this.city = city;
        this.street = street;
        this.pin = pin;
        this.dob = dob;
    }

    public User() {
    }

    public User(String user_fname, String user_lname, String username, String user_email, String user_password, String city, String street, Long pin, LocalDate dob) {
        this.fname = user_fname;
        this.lname = user_lname;
        this.username = username;
        this.email = user_email;
        this.password = user_password;
        this.city = city;
        this.street = street;
        this.pin = pin;
        this.dob = dob;
    }

}
