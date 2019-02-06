package com.softserve.itacademy.dp_153.util.converters;

import com.softserve.itacademy.dp_153.model.User;
import com.softserve.itacademy.dp_153.util.dto.UserDto;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class UserConverterTest {

    @Test
    public void asListUser() {
        String name = "aaa";
        String email = "sss";
        String pass = "ddd";
        UserConverter converter = new UserConverter();

        UserDto dto1 = new UserDto();
        dto1.setUserName(name);
        dto1.setEmail(email);
        dto1.setPassword(pass);

        UserDto dto2 = new UserDto();
        dto2.setUserName(name);
        dto2.setEmail(email);
        dto2.setPassword(pass);

        List<UserDto> dtos = new ArrayList<>();
        dtos.add(dto1);
        dtos.add(dto2);

        List<User> users = converter.asListUser(dtos);

        Assert.assertEquals(2, users.size());

    }
}
