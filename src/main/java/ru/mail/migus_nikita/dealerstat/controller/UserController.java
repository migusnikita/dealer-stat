package ru.mail.migus_nikita.dealerstat.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.mail.migus_nikita.dealerstat.dto.UserDto;
import ru.mail.migus_nikita.dealerstat.model.User;
import ru.mail.migus_nikita.dealerstat.service.UserService;

public class UserController {

    private UserService userService;

    @GetMapping("/get-user/by-id/{id}")
    public UserDto getUser(Long id) {
        User user = userService.getUserById(id);

        UserDto dto = new UserDto();
        dto.setFirstName(user.getFirstName());

        return dto;
    }

    @PostMapping("/post/add-comment")
    public void addComment(UserDto userDto) {
      userService.addUser(userDto);
    }

}
