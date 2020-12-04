package br.com.loadti.gerenciamentodepessoa.service;


import br.com.loadti.gerenciamentodepessoa.dto.MessageResponseDTO;
import br.com.loadti.gerenciamentodepessoa.dto.PersonDTO;
import br.com.loadti.gerenciamentodepessoa.entity.Person;
import br.com.loadti.gerenciamentodepessoa.repository.PersonRepository;
import br.com.loadti.gerenciamentodepessoa.services.PersonService;
import br.com.loadti.gerenciamentodepessoa.utils.PersonUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static br.com.loadti.gerenciamentodepessoa.utils.PersonUtils.createFakeDTO;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.any;



@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void CreateDTOReturnMessage() {

        PersonDTO personDTO = createFakeDTO();
        Person expectedSavePerson = PersonUtils.createFakeEntity();

        Mockito.when(personRepository.save(any(Person.class))).thenReturn(expectedSavePerson);

        MessageResponseDTO expectedSucessMessage = createdMessageResponse(expectedSavePerson.getId());

        MessageResponseDTO sucessMessage =  personService.createPerson(personDTO);

        assertEquals(expectedSucessMessage, sucessMessage);

    }

    private MessageResponseDTO createdMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Pessoa esperada " + id)
                .build();
    }
}
