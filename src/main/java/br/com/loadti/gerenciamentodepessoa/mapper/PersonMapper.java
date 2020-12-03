package br.com.loadti.gerenciamentodepessoa.mapper;

import br.com.loadti.gerenciamentodepessoa.dto.PersonDTO;
import br.com.loadti.gerenciamentodepessoa.entity.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

    @Mapping(target = "birdthDate", source = "birdthDate", dateFormat = "dd-MM-yyyy")
    Person toModel(PersonDTO personDTO);

    PersonDTO toDTO(Person person);
}
