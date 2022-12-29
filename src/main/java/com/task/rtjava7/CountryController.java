package com.task.rtjava7;

import java.util.concurrent.atomic.AtomicLong;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Validated
@RestController
public class CountryController {

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/countries")
    public Country getCountryInfo(
            @RequestParam(value="name")
            @Valid
            @NotEmpty
            @Size(min = 1, max = 20)
            String name,
            @RequestParam(value="foundationDay")
            @Valid
            @NotEmpty
            @Pattern(regexp = "^[0-9]{4}\\/(0[1-9]|1[0-2])\\/(0[1-9]|[12][0-9]|3[01])$")
            String foundationDay
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
