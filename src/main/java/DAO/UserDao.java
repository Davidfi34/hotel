package DAO;

import models.User;
import javax.persistence.EntityManager;
import java.util.List;

public class UserDao {

    private EntityManager em;

    public UserDao(EntityManager entityManager) {

        this.em = entityManager;
    }


    public User create(User user) {
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user;
    }

    public User getById(int id) {
        try {
            return em.find(User.class, id);
        } finally {
            em.close();
        }
    }

    public List<User> getAll(){
        String jpql = "SELECT u FROM users AS u";
        return em.createQuery(jpql, User.class).getResultList();
    }

    public void save(User user){
        this.em.persist(user);
    }

    public void update(User user){
        this.em.merge(user);
    }
}
