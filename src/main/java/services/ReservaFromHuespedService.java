package services;

import DAO.HuespedDao;
import DAO.ReservaDao;
import DTO.HuespedDto;
import DTO.ReservaDto;
import models.Huesped;
import models.Reserva;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReservaFromHuespedService {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private ReservaDao reservaDao;
    private HuespedDao huespedDao;

    public ReservaFromHuespedService() {
        entityManagerFactory = Persistence.createEntityManagerFactory("hotel");
        entityManager = entityManagerFactory.createEntityManager();
        reservaDao = new ReservaDao(entityManager);
        huespedDao = new HuespedDao(entityManager);

    }


    public long createReserveFromHuesped(ReservaDto reservaDto, HuespedDto huespedDto){

        Reserva reserva = reservaDto.createReserva();
        Huesped huesped = huespedDto.createHuesped();

        try {
            entityManager.getTransaction().begin();
            reservaDao.save(reserva);
            huesped.setReserva(reserva);
            huespedDao.save(huesped);
            entityManager.getTransaction().commit();
            return reserva.getId();
        } catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return 0;
    }



}
