package ru.quassbottle.vacationcalculator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.quassbottle.vacationcalculator.controllers.CalculatorController;
import ru.quassbottle.vacationcalculator.feignclients.IsDayOffFeignClient;
import ru.quassbottle.vacationcalculator.models.VacationPayment;

import java.time.LocalDate;

@Service
public class CalculatorService {
    private final float AVERAGE_MONTH_LENGTH = 29.3f;
    private final IsDayOffFeignClient _isDayOffFeignClient;

    @Autowired
    public CalculatorService(IsDayOffFeignClient client) {
        _isDayOffFeignClient = client;
    }

    public VacationPayment getVacationPayment(float averageSalary, int days, LocalDate startDate) {
        if (averageSalary <= 0 || days <= 0)
            throw new IllegalArgumentException();
        if (startDate == null) {
            return new VacationPayment(averageSalary, days, averageSalary / AVERAGE_MONTH_LENGTH * days);
        }
        return null;
    }
}
