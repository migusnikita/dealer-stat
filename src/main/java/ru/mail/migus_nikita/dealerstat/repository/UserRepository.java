package ru.mail.migus_nikita.dealerstat.repository;

import java.util.List;

import ru.mail.migus_nikita.dealerstat.model.User;

public interface UserRepository {

    List<User> getAllUsers();

    User getById(int id);

    void addUser(User user);

    void updateUser(User user);

}
