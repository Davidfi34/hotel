package services;

import DAO.ReservaDao;
import DTO.HuespedDto;
import DTO.ReservaDto;
import models.Huesped;
import models.Reserva;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class ReservaService {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private ReservaDao reservaDao;

    public ReservaService() {
        entityManagerFactory = Persistence.createEntityManagerFactory("hotel");
        entityManager = entityManagerFactory.createEntityManager();
        reservaDao = new ReservaDao(entityManager);
    }

    public ReservaDto createReserva(Reserva reserva) {
        Reserva r = reservaDao.create(reserva);
        return new ReservaDto(r.getId(),r.getCheckInDate(),
                r.getCheckOutDate(),r.getPrice(),r.getTypeOfPayment());
    }



    public List<ReservaDto> getAllReservas(){
        List<Reserva> listReservas = reservaDao.getAll();
        List<ReservaDto> listReservasDto = new ArrayList<>();

        for (Reserva reserva : listReservas) {
            ReservaDto reservaDto = new ReservaDto(reserva.getId(), reserva.getCheckInDate(), reserva.getCheckOutDate(),
                    reserva.getPrice(), reserva.getTypeOfPayment());
            listReservasDto.add(reservaDto);
        }
        return listReservasDto;
    }



    public void saveReserva(Reserva reserva){
        reservaDao.save(reserva);
    }

    public ReservaDto getByIdReserva(long id){
        Reserva reserva = reservaDao.getById(id);
        return  new ReservaDto(
                reserva.getId(),reserva.getCheckInDate(),
                reserva.getCheckOutDate(),
                reserva.getPrice(),reserva.getTypeOfPayment()
        );
    }


    public void updateReserva(Reserva reserva){
        reservaDao.update(reserva);
    }

    public void deleteReserva(ReservaDto reservaDto){
        reservaDao.delete(reservaDto.toReserva());
    }


}
