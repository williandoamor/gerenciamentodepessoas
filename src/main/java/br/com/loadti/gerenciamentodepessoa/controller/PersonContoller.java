package br.com.loadti.gerenciamentodepessoa.controller;

import br.com.loadti.gerenciamentodepessoa.dto.MessageResponseDTO;
import br.com.loadti.gerenciamentodepessoa.dto.PersonDTO;
import br.com.loadti.gerenciamentodepessoa.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/people")
public class PersonContoller {

    private PersonService personService;

    @Autowired
    public PersonContoller(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {

        return personService.createPerson(personDTO);
    }

}
