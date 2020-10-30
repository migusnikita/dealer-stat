package ru.mail.migus_nikita.dealerstat.repository.impl;

import java.util.List;



import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.migus_nikita.dealerstat.model.User;
import ru.mail.migus_nikita.dealerstat.repository.UserRepository;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    private SessionFactory sessionFactory;

//    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public void updateUser(User user) {

    }

}
