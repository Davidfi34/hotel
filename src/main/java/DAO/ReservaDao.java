package DAO;

import models.Reserva;

import javax.persistence.EntityManager;
import java.util.List;

public class ReservaDao {


    private EntityManager em;

    public ReservaDao(EntityManager entityManager) {
        this.em = entityManager;
    }


    public Reserva create(Reserva reserva) {
        em.getTransaction().begin();
        em.persist(reserva);
        em.getTransaction().commit();
        return reserva;
    }

    public Reserva getById(long id) {
        try {
            return em.find(Reserva.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    public List<Reserva> getAll(){
        String jpql = "SELECT r FROM reservas AS r";
        return em.createQuery(jpql, Reserva.class).getResultList();
    }

    public void save(Reserva reserva){
        this.em.persist(reserva);
    }

    public void update(Reserva reserva){
        try {
            this.em.getTransaction().begin();
            this.em.merge(reserva);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(Reserva reserva){
        try {
            em.getTransaction().begin();
            reserva = em.merge(reserva);
            em.remove(reserva);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

}
