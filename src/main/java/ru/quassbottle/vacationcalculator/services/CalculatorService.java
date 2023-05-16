package ru.quassbottle.vacationcalculator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.quassbottle.vacationcalculator.controllers.CalculatorController;
import ru.quassbottle.vacationcalculator.feignclients.IsDayOffFeignClient;
import ru.quassbottle.vacationcalculator.models.VacationPayment;

import java.time.LocalDate;

@Service
public class CalculatorService {
    private static final float AVERAGE_MONTH_LENGTH = 29.3f;
    private final IsDayOffFeignClient _isDayOffFeignClient;

    @Autowired
    public CalculatorService(IsDayOffFeignClient client) {
        _isDayOffFeignClient = client;
    }

    public VacationPayment getVacationPayment(float averageSalary, int days, LocalDate startDate) {
        if (averageSalary <= 0 || days <= 0)
            throw new IllegalArgumentException();
        if (startDate == null) {
            return new VacationPayment(calculateVacationSalary(averageSalary, days));
        }

        int paidDaysCount = days;
        for (int i = 0; i < days; i++) {
            if (isDayOff(startDate.plusDays(i)))
                paidDaysCount--;
        }

        return new VacationPayment(calculateVacationSalary(averageSalary, paidDaysCount));
    }

    private float calculateVacationSalary(float averageSalary, int days) {
        return averageSalary / AVERAGE_MONTH_LENGTH * days;
    }

    private boolean isDayOff(LocalDate date) {
        return _isDayOffFeignClient.getDayOff(date).equals("1") ||
                (date.getDayOfWeek().toString().equals("SATURDAY") &&
                date.getDayOfWeek().toString().equals("SUNDAY"));

    }
}
