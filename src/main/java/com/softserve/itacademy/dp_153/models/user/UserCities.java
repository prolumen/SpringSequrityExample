package com.softserve.itacademy.dp_153.models.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserCities {
    @Id
    private Integer id;

    private Integer userId;
    private Integer cityId;

    public UserCities() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
