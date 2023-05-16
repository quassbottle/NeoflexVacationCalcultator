package ru.quassbottle.vacationcalculator.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;

@FeignClient(name = "IsDayOffService", url  = "https://www.isdayoff.ru/")
public interface IsDayOffFeignClient {
    @GetMapping("/{date}")
    String getDayOff(@DateTimeFormat(pattern = "yyyy-MM-dd") @PathVariable LocalDate date);
}
