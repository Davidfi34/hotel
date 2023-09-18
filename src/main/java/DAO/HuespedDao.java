package DAO;


import models.Huesped;
import javax.persistence.EntityManager;
import java.util.List;

public class HuespedDao {

    private EntityManager em;

    public HuespedDao(EntityManager entityManager) {
        this.em = entityManager;
    }


    public Huesped create(Huesped huesped) {
        em.getTransaction().begin();
        em.persist(huesped);
        em.getTransaction().commit();
        return huesped;
    }


    public Huesped getById(Long id) {
        try {
            return em.find(Huesped.class, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



    public List<Huesped> getAll(){
        String jpql = "SELECT H FROM huespedes AS H";
        return em.createQuery(jpql, Huesped.class).getResultList();
    }

    public void save(Huesped huesped){
        this.em.persist(huesped);
    }

    public void update(Huesped huesped){
        try {
            this.em.getTransaction().begin();
            this.em.merge(huesped);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public void delete(Huesped huesped){
        try {
            em.getTransaction().begin();
            huesped = em.merge(huesped);
            em.remove(huesped);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    /**
     * GET HUESPED POR NUEMERO DE RESERVA
     */
    public Huesped consultReservaHuesped(Long id){
        String jpql = "SELECT h FROM huespedes h JOIN h.reserva r WHERE r.id = :id";

        return em.createQuery(jpql,Huesped.class).
                setParameter("id",id).getSingleResult();

    }


    /**
     * GET HUESPED POR NUEMERO DE RESERVA
     */
    public Huesped getByLastName(String lastName){
        String jpql = "SELECT h FROM huespedes AS h WHERE h.lastName = :lastName";
        return em.createQuery(jpql,Huesped.class).
                setParameter("lastName",lastName).getSingleResult();

    }




}
