package DTO;

import models.User;

public class UserDto {

    private  Long id;
    private String username;
    private String password;

    public Long getId() {
        return id;
    }


    public User toUser() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return user;
    }
}
