package io.github.wesleyosantos91.controller;

import io.github.wesleyosantos91.request.Person;
import io.github.wesleyosantos91.service.S3Service;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;

@Controller
@RequestMapping("/persons")
public class PersonController {

    private final S3Service service;

    public PersonController(S3Service service) {
        this.service = service;
    }

    @PostMapping
    public void salve(@RequestBody Person person) throws IOException {
        service.convertAndUpload(person, "person-bucket");
    }
}
