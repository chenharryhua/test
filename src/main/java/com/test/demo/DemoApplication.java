package com.test.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@SpringBootApplication
@RestController
public class DemoApplication {
    private PhoneNumberDao phoneNumberDao;

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/phoneNumbers")
    public Set<PhoneNumber> getAllPhoneNumber() {
        return phoneNumberDao.getAllPhoneNumber();
    }

    @GetMapping("/customer/{id}")
    public Set<PhoneNumber> getPhoneNumbers(@PathVariable Customer id) {
        return phoneNumberDao.getPhoneNumbers(id);
    }

    @GetMapping("/phoneNumbers/{id}")
    public boolean activate(@PathVariable PhoneNumber id) {
        return phoneNumberDao.activate(id);
    }

}
