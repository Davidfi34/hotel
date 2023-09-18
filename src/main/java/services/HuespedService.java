package services;

import DAO.HuespedDao;
import DTO.HuespedDto;
import DTO.ReservaDto;
import models.Huesped;
import models.Reserva;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

public class HuespedService {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;
    private HuespedDao huespedDao;

    public HuespedService() {
        entityManagerFactory = Persistence.createEntityManagerFactory("hotel");
        entityManager = entityManagerFactory.createEntityManager();
        huespedDao = new HuespedDao(entityManager);
    }

    public List<HuespedDto> getAllHuesped(){
        List<Huesped> listHuespedes = huespedDao.getAll();
        List<HuespedDto> listHuespedesDto = new ArrayList<>();

        for (Huesped huesped : listHuespedes) {
            HuespedDto huespedDto = new HuespedDto(huesped.getId(), huesped.getName(), huesped.getLastName(),
                    huesped.getDateOfBirth(), huesped.getNationality(), huesped.getPhone(),
                    new ReservaDto(
                                huesped.getReserva().getId(),
                                huesped.getReserva().getCheckInDate(),
                                huesped.getReserva().getCheckOutDate(),
                                huesped.getReserva().getPrice(),
                                huesped.getReserva().getTypeOfPayment()));
            listHuespedesDto.add(huespedDto);
        }
        return listHuespedesDto;
    }

    public Huesped createHuesped(Huesped huesped) {
        return huespedDao.create(huesped);
    }

    public void saveHuesped(Huesped huesped){
        huespedDao.save(huesped);
    }


    /**
     * Get huesped x id
     * @param id
     * @return
     */
    public HuespedDto getByIdHuesped(long id){
        Huesped result = huespedDao.getById(id);
        HuespedDto huesped = new HuespedDto(
                result.getId(),result.getName(),result.getLastName(),result.getDateOfBirth(),
                result.getNationality(),result.getPhone(),
                        new ReservaDto(result.getReserva().getId(),result.getReserva().getCheckInDate(),
                            result.getReserva().getCheckOutDate(),
                            result.getReserva().getPrice(),
                            result.getReserva().getTypeOfPayment()));
        return huesped;

    }


    public HuespedDto getByIdReservaHuesped(long id){

        Huesped huesped = huespedDao.consultReservaHuesped(id);
        return new HuespedDto(huesped.getId(),huesped.getName(),
                huesped.getLastName(),huesped.getDateOfBirth(),huesped.getNationality(),
                huesped.getPhone(),
                new ReservaDto(huesped.getReserva().getId(),
                huesped.getReserva().getCheckInDate(),huesped.getReserva().getCheckOutDate(),
                huesped.getReserva().getPrice(),huesped.getReserva().getTypeOfPayment()));
    }


    public HuespedDto getHuespedBylastName( String lastName){
        Huesped h = huespedDao.getByLastName(lastName);

        return new HuespedDto(h.getId(),h.getName(),h.getLastName(),
                h.getDateOfBirth(),h.getNationality(),h.getPhone(),
                new ReservaDto(h.getReserva().getId(),h.getReserva().getCheckInDate(),
                        h.getReserva().getCheckOutDate(),
                        h.getReserva().getPrice(),
                        h.getReserva().getTypeOfPayment()));

    }



    public void updateHuesped(HuespedDto huespedDto){
        huespedDao.update(huespedDto.toHuesped());
    }


    public void deleteHuesped(HuespedDto huespedDto) {
        huespedDao.delete(huespedDto.toHuesped());
    }
}
