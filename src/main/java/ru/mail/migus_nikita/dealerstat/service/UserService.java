package ru.mail.migus_nikita.dealerstat.service;

import ru.mail.migus_nikita.dealerstat.dto.UserDto;
import ru.mail.migus_nikita.dealerstat.model.User;

public interface UserService {

    User getUserById(int id);

    User findByUserName(String author);

    void addUser(UserDto userDto);

}
