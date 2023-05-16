package ru.quassbottle.vacationcalculator.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.quassbottle.vacationcalculator.models.VacationPayment;
import ru.quassbottle.vacationcalculator.services.CalculatorService;

import java.time.LocalDate;

@RestController
public class CalculatorController {
    private CalculatorService _service;

    @Autowired
    public CalculatorController(CalculatorService service) {
        _service = service;
    }

    @GetMapping("/calculate")
    public ResponseEntity<VacationPayment> getVacationPayment(@RequestParam(value = "averageSalary") float averageSalary,
                                                              @RequestParam(value = "days") int days,
                                                              @RequestParam(value = "startDate", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate startDate) {
        try {
            return new ResponseEntity<>(_service.getVacationPayment(averageSalary, days, startDate), HttpStatus.OK);
        } catch(IllegalArgumentException e) {
            return new ResponseEntity<>(new VacationPayment(), HttpStatus.BAD_REQUEST);
        }
    }
}
