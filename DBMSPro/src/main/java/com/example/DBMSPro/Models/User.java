package com.example.DBMSPro.Models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import javax.crypto.KeyGenerator;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

public class User {
    private Long  id;
    private String fname;
    private String lname;
    private String username;
    private String email;
    private String password;
    private Role role=new Role();
    private String city;
    private String street;
    private Long pin;
    private String user_type ;
    private LocalDate dob;
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        if (id == 0) id = (long) UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
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
    public String getUser_type() {
        return user_type;
    }
    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }
    public LocalDate getDob() {
        return dob;
    }
    public void setDob(LocalDate dob) {
        this.dob = dob;
    }



    public User(Long id, String fname, String lname, String username, String email, String password, Role role, String city, String street, Long pin, String user_type, LocalDate dob) {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.city = city;
        this.street = street;
        this.pin = pin;
        this.user_type = user_type;
        this.dob = dob;
    }

    public User() {
        setId(0L);
    }

    public User(String fname, String lname, String username, String email, String password, Role role, String city, String street, Long pin, String user_type, LocalDate dob) {
        this.id=(long) UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
        this.fname = fname;
        this.lname = lname;
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = role;
        this.city = city;
        this.street = street;
        this.pin = pin;
        this.user_type = user_type;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                ", pin=" + pin +
                ", user_type='" + user_type + '\'' +
                ", dob=" + dob +
                '}';
    }
}

