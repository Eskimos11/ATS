package service;

import model.User;

public class UserService {
    public User createUser(String name){
        User user = new User(name);
        return user;
    }
}
