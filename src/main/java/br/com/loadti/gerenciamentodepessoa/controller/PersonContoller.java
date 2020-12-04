package br.com.loadti.gerenciamentodepessoa.controller;

import br.com.loadti.gerenciamentodepessoa.dto.MessageResponseDTO;
import br.com.loadti.gerenciamentodepessoa.dto.PersonDTO;
import br.com.loadti.gerenciamentodepessoa.exception.PersonNotFoundException;
import br.com.loadti.gerenciamentodepessoa.services.PersonService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
/*Injeta o construtor automaticamente*/
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonContoller {

    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {

        return personService.createPerson(personDTO);
    }

    @GetMapping
    public List<PersonDTO> listAll() {

        return personService.listAll();
    }

    @GetMapping("/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {

        return personService.findById(id);
    }

    @GetMapping("{id}")
    public MessageResponseDTO updateByID(@PathVariable Long id, @RequestBody PersonDTO personDTO) throws PersonNotFoundException {

        return  personService.updateById(id, personDTO);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteForById(@PathVariable Long id) throws PersonNotFoundException {

        personService.delete(id);

    }
}
