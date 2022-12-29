package com.task.rtjava7;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.*;

@RestController
public class CountryController {
    private static final String template = "国名：%s 建国記念日：%s";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/countries")
    public Country getCountryInfo(
            @RequestParam(value="name")  String name,
            @RequestParam(value="foundationDay") String foundationDay
    ) {
        return new Country(counter.incrementAndGet(), name, foundationDay);
    }

    @PostMapping("/countries")
    public CreateResponse createCountryInfo(@RequestBody CreateForm form) {
        return new CreateResponse(counter.incrementAndGet(), "Country Information are successfully created");
    }

    @PatchMapping("/countries/{id}")
    public CreateResponse updateCountryInfo(@PathVariable("id") long id, @RequestBody UpdateForm form){
        return new CreateResponse(id, "Country Information are successfully updated");
     }

    @DeleteMapping("/countries/{id}")
    public CreateResponse deleteCountryInfo(@PathVariable("id") long id) {
        return new CreateResponse(id, "Country Information are successfully deleted");
    }
}
