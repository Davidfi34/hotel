package DTO;

import models.Reserva;
import models.TypeOfPayment;
import java.math.BigDecimal;
import java.time.LocalDate;

public class ReservaDto {
    private Long id;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private BigDecimal price;
    private TypeOfPayment typeOfPayment;

    public ReservaDto() {
    }

    public ReservaDto( long id,LocalDate checkInDate, LocalDate checkOutDate, BigDecimal price, TypeOfPayment typeOfPayment) {
        this.id = id;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.price = price;
        this.typeOfPayment = typeOfPayment;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TypeOfPayment getTypeOfPayment() {
        return typeOfPayment;
    }

    public void setTypeOfPayment(TypeOfPayment typeOfPayment) {
        this.typeOfPayment = typeOfPayment;
    }

    public Reserva createReserva() {
       Reserva reserva = new Reserva();
       reserva.setCheckInDate(checkInDate);
       reserva.setCheckOutDate(checkOutDate);
       reserva.setPrice(price);
       reserva.setTypeOfPayment(typeOfPayment);
        return reserva;
    }
    public Reserva toReserva() {
        return new Reserva(id,checkInDate, checkOutDate, price, typeOfPayment);
    }


}
