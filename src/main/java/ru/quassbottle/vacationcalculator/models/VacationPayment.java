package ru.quassbottle.vacationcalculator.models;

import java.time.LocalDate;

public class VacationPayment {
    private float _salary;
    private int _days;
    private LocalDate _vacationStart = null;
    private float _vacationSalary;

    public VacationPayment(float salary, int days, float vacationSalary) {
        _salary = salary;
        _days = days;
        _vacationSalary = vacationSalary;
    }

    public VacationPayment(float salary, int days, LocalDate vacationStart, float vacationSalary) {
        _salary = salary;
        _days = days;
        _vacationSalary = vacationSalary;
        _vacationStart = vacationStart;
    }

    public VacationPayment() {

    }

    public float getSalary() {
        return _salary;
    }

    public float getVacationSalary() {
        return _vacationSalary;
    }

    public LocalDate getVacationStart() {
        return _vacationStart;
    }

    public int getDays() {
        return _days;
    }
}

