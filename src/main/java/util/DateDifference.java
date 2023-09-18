package util;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

//DIFERENCIA DE DIAS
public class DateDifference {
    private LocalDate startDate;
    private LocalDate endDate;

    public DateDifference(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public long numberOfDays() {
        long days = ChronoUnit.DAYS.between(this.startDate, this.endDate);
        return days;
    }

    }

