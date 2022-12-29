package com.task.rtjava7;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {
    private static final String template = "国名：%s 建国記念日：%s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/country")
    public Country getCountryInfo(
            @RequestParam(value = "country") String country,
            @RequestParam(value="nationalFoundationDay") String nationalFoundationDay
    ) {
        return new Country(counter.incrementAndGet(), String.format(template, country,nationalFoundationDay));
    }

    // @PostMapping("/country")

    // @PatchMapping("/country")

    // @DeleteMapping("/country")
}
