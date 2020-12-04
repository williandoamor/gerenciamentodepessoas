package br.com.loadti.gerenciamentodepessoa.services;

import br.com.loadti.gerenciamentodepessoa.dto.MessageResponseDTO;
import br.com.loadti.gerenciamentodepessoa.dto.PersonDTO;
import br.com.loadti.gerenciamentodepessoa.entity.Person;
import br.com.loadti.gerenciamentodepessoa.exception.PersonNotFoundException;
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
        return createMessageResponse(savedPerson.getId(), "Pessoal criada com o ID ");
    }

    public List<PersonDTO> listAll() {

        List<Person> allPeople = repository.findAll();
        return allPeople.stream().map(
                personMapper::toDTO
        ).collect(Collectors.toList());

    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person person = verifyExists(id);

        return personMapper.toDTO(person);
    }


    public void delete(Long id) throws PersonNotFoundException {

        verifyExists(id);

        repository.deleteById(id);
    }

    private Person verifyExists(Long id) throws PersonNotFoundException {

        return repository.findById(id)
                .orElseThrow(() -> new PersonNotFoundException(id));

    }

    public MessageResponseDTO updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {

        verifyExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);

        Person savedPerson = repository.save(personToUpdate);
        return createMessageResponse(savedPerson.getId(), "Update pessoa com id ");

    }

    private MessageResponseDTO createMessageResponse(Long id, String msg) {
        return MessageResponseDTO
                .builder()
                .message(msg + id)
                .build();
    }
}
