package ru.mail.migus_nikita.dealerstat.service;

import java.util.List;

import ru.mail.migus_nikita.dealerstat.dto.UserDto;
import ru.mail.migus_nikita.dealerstat.model.User;

public interface UserService {

    User getUserById(int id);

    User findByUserName(String userName);

    void addUser(UserDto userDto);

    List<User> getAllUsers();

    void updateUser(User user);

}
