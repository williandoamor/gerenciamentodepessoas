package br.com.loadti.gerenciamentodepessoa.controller;

import br.com.loadti.gerenciamentodepessoa.dto.MessageResponseDTO;
import br.com.loadti.gerenciamentodepessoa.entity.Person;
import br.com.loadti.gerenciamentodepessoa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PersonContoller {

    private PersonRepository repository;

    @Autowired
    public PersonContoller(PersonRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public String createPerson(@RequestBody Person person) {
        Person p =   repository.save(person);
        return new MessageResponseDTO()

                .build;
    }

}
