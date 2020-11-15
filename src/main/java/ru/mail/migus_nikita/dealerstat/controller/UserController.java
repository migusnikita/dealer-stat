package ru.mail.migus_nikita.dealerstat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import ru.mail.migus_nikita.dealerstat.dto.UserDto;
import ru.mail.migus_nikita.dealerstat.model.User;
import ru.mail.migus_nikita.dealerstat.service.UserService;

public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users/get-user/by-id/{id}")
    public UserDto getUser(@PathVariable int id) {
        User user = userService.getUserById(id);
        UserDto dto = new UserDto();
        dto.setFirstName(user.getFirstName());
        return dto;
    }

    @PostMapping("/users/post/add-user")
    public void addUser(UserDto userDto) {
        userService.addUser(userDto);
    }

    @PostMapping("/users/post/update-user")
    public void updateUser(User user) {
        userService.updateUser(user);
    }

    @PostMapping("/users/post/get-all-users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

}
