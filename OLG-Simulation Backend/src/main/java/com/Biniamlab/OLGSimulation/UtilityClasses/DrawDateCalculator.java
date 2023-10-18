package com.Biniamlab.OLGSimulation.UtilityClasses;

import org.springframework.stereotype.Component;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

@Component
public class DrawDateCalculator {

    public LocalDate calculateDateOfDrawForLottoMax(LocalDateTime givenDate){
        LocalDate purchaseDate = givenDate.toLocalDate();
        LocalDate nextTuesday = purchaseDate.with(TemporalAdjusters.next(DayOfWeek.TUESDAY));
        LocalDate nextFriday = purchaseDate.with(TemporalAdjusters.next(DayOfWeek.FRIDAY));

        return nextTuesday.isBefore(nextFriday) ? nextTuesday : nextFriday;
    }

    public LocalDate calculateDateOfDrawForLotto649(LocalDateTime givenDate){
        LocalDate purchaseDate = givenDate.toLocalDate();
        LocalDate nextWednesday = purchaseDate.with(TemporalAdjusters.next(DayOfWeek.WEDNESDAY));
        LocalDate nextSaturday = purchaseDate.with(TemporalAdjusters.next(DayOfWeek.SATURDAY));

        return nextWednesday.isBefore(nextSaturday) ? nextWednesday : nextSaturday;
    }
}
