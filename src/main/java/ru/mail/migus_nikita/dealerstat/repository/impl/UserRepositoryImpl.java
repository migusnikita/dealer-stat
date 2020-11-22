package ru.mail.migus_nikita.dealerstat.repository.impl;

import java.util.List;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.mail.migus_nikita.dealerstat.model.User;
import ru.mail.migus_nikita.dealerstat.repository.UserRepository;

@Repository
@Transactional
public class UserRepositoryImpl implements UserRepository {

    private final EntityManager entityManager;

    @Autowired
    public UserRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager
                .createNamedQuery("User.findAll", User.class).getResultList();
    }

    @Override
    public User getUserById(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void addUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User findByUserName(String userName) {
        return (User) entityManager.createNativeQuery(
                "select distinct u.id, u.name " +
                        "from user u" +
                        "where u.name = :name", User.class)
                .setParameter("name", userName)
                .getSingleResult();
    }

}
