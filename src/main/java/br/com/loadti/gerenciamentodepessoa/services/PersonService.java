package br.com.loadti.gerenciamentodepessoa.services;

import br.com.loadti.gerenciamentodepessoa.dto.MessageResponseDTO;
import br.com.loadti.gerenciamentodepessoa.dto.PersonDTO;
import br.com.loadti.gerenciamentodepessoa.entity.Person;
import br.com.loadti.gerenciamentodepessoa.mapper.PersonMapper;
import br.com.loadti.gerenciamentodepessoa.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private PersonRepository repository;

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository repository) {
        this.repository = repository;
    }

    public MessageResponseDTO createPerson(PersonDTO personDTO) {
        Person savedToSave = personMapper.toModel(personDTO);

        Person savedPerson = repository.save(savedToSave);
        return MessageResponseDTO
                .builder()
                .message("Pessoa criada com o id " + savedPerson.getId())
                .build();
    }

    public List<PersonDTO> listAll() {

        List<Person> allPeople = repository.findAll();
        return allPeople.stream().map(
                personMapper::toDTO
        ).collect(Collectors.toList());

    }
}
