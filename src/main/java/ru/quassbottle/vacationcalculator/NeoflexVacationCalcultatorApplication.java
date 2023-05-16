package ru.quassbottle.vacationcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class NeoflexVacationCalcultatorApplication {

    public static void main(String[] args) {
        var context =  SpringApplication.run(NeoflexVacationCalcultatorApplication.class, args);
    }

}
