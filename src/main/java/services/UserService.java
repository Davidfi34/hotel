package services;

import DAO.UserDao;
import DTO.UserDto;
import models.User;
import util.JPAUtils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UserService {
    private EntityManager entityManager;
    private UserDao userDao;

    public UserService() {

        entityManager = JPAUtils.getEntityManger();

        userDao = new UserDao(entityManager);
    }

    public User createUser(User user) {
        return userDao.create(user);
    }

    public User getByIdUser(int id){
        return userDao.getById(id);
    }

    public void updateUser(User user){
        userDao.update(user);
    }

    public boolean ValidateUser(String Username, String UserPassword) {
        List<User> listUsers = userDao.getAll();
        for( User user : listUsers){
            if (user.getUsername().equals(Username)) {
                if (user.getPassword().equals(UserPassword)) return true;
            }
        }
        return false;
    }


}
