package com.softserve.itacademy.dp_153.util.dto;

import com.softserve.itacademy.dp_153.model.City;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDto {
    private String userName;
    private String email;
    private String password;
    private String role;
    private List<City> cities;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
