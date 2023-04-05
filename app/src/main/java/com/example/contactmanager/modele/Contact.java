package com.example.contactmanager.modele;

import java.io.Serializable;

public class Contact implements Serializable {
    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
    private String phoneNumber;

    public Contact(Integer id, String firstname, String lastname, String email, String phoneNumber) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
