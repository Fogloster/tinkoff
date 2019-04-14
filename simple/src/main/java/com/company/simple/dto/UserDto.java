package com.company.simple.dto;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserDto implements Serializable {

    @SerializedName("lname")
    private String lastName;

    @SerializedName("fname")
    private String firstName;

    @SerializedName("patronymic")
    private String patronymic;

    @SerializedName("date")
    private String date;

    @SerializedName("city")
    private String city;

    @SerializedName("street")
    private String street;

    @SerializedName("house")
    private Integer house;

    @SerializedName("apartment")
    private Integer apartment;

    @SerializedName("phone")
    private String phone;

    public UserDto() {
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
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

    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public Integer getApartment() {
        return apartment;
    }

    public void setApartment(Integer apartment) {
        this.apartment = apartment;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
