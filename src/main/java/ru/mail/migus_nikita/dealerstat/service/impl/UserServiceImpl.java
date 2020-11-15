package ru.mail.migus_nikita.dealerstat.service.impl;

import org.springframework.stereotype.Service;
import ru.mail.migus_nikita.dealerstat.dictionary.UserRole;
import ru.mail.migus_nikita.dealerstat.dto.UserDto;
import ru.mail.migus_nikita.dealerstat.model.User;
import ru.mail.migus_nikita.dealerstat.repository.UserRepository;
import ru.mail.migus_nikita.dealerstat.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User getUserById(int id) {
        userRepository.getUserById(id);
        return
    }

    @Override
    public User findByUserName(String author) {
        return null;
    }

    @Override
    public void addUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setUserRole(UserRole.TRADER);

    }

}
