package DTO;


import models.Huesped;
import models.Reserva;

import java.time.LocalDate;

public class HuespedDto {

    private Long id;
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private String nationality;
    private String phone;
    private ReservaDto reserva;

    public HuespedDto(){

    }
    public HuespedDto(Long id,String name, String lastName, LocalDate dateOfBirth,
                      String nationality, String phone, ReservaDto reserva) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.phone = phone;
        this.reserva = reserva;
    }


    public Huesped toHuesped() {
        return new Huesped( id,name, lastName, dateOfBirth, nationality, phone,  reserva.toReserva());
    }

    public Huesped createHuesped() {
        Huesped h = new Huesped();
        h.setName(name);
        h.setLastName(lastName);
        h.setDateOfBirth(dateOfBirth);
        h.setNationality(nationality);
        h.setPhone(phone);
        h.setReserva(reserva.createReserva());
        return h;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public ReservaDto getReserva() {
        return reserva;
    }

    public void setReserva(ReservaDto reservaDto) {
        this.reserva = reservaDto;
    }
}
