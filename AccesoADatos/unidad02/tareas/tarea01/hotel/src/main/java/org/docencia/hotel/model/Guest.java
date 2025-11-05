package org.docencia.hotel.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "guests")
public class Guest {

    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Column(name = "full_name", nullable = false)
    @NotBlank
    private String fullName;

    @Column(name = "email", nullable = false)
    @NotBlank
    private String email;

    @Column(name = "phone_number", nullable = false)
    @NotBlank
    private String phoneNumber;


    public Guest() {
    }

    public Guest(int id, @NotBlank String fullName, @NotBlank String email, @NotBlank String phoneNumber) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
