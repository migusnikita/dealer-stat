package ru.mail.migus_nikita.dealerstat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mail.migus_nikita.dealerstat.dictionary.UserRole;
import ru.mail.migus_nikita.dealerstat.dto.UserDto;
import ru.mail.migus_nikita.dealerstat.model.User;
import ru.mail.migus_nikita.dealerstat.repository.UserRepository;
import ru.mail.migus_nikita.dealerstat.service.CryptoService;
import ru.mail.migus_nikita.dealerstat.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CryptoService cryptoService;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, CryptoService cryptoService) {
        this.userRepository = userRepository;
        this.cryptoService = cryptoService;
    }

    @Override
    public User getUserById(int id) {
        return userRepository.getUserById(id);
    }

    @Override
    public User findByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public void addUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(cryptoService.encrypt(userDto.getPassword()));
        user.setUserRole(UserRole.TRADER);
        userRepository.addUser(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    @Override
    public void updateUser(User user) {
        userRepository.updateUser(user);

    }

}
