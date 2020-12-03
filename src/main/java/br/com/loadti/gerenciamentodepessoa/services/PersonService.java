package br.com.loadti.gerenciamentodepessoa.services;

import br.com.loadti.gerenciamentodepessoa.dto.MessageResponseDTO;
import br.com.loadti.gerenciamentodepessoa.entity.Person;
import br.com.loadti.gerenciamentodepessoa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonService {

    private PersonRepository repository;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public MessageResponseDTO createPerson(Person person) {
        Person savedPerson =   repository.save(person);
        return MessageResponseDTO
                .builder()
                .message("Pessoal criada com o id " + savedPerson.getId())
                .build();
    }
}
