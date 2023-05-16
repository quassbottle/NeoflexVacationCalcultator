package ru.quassbottle.vacationcalculator.models;

import java.time.LocalDate;

public class VacationPayment {
    private float _payment;

    public VacationPayment(float payment) {
        _payment = payment;
    }

    public VacationPayment() {

    }

    public float getPayment() {
        return _payment;
    }
}

