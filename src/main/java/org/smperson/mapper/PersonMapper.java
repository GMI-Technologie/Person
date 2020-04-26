package org.smperson.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.smperson.dto.PersonDTO;
import org.smperson.entities.Person;
import org.smperson.froms.PersonForm;

@Mapper(componentModel = "spring")
public interface PersonMapper {

    PersonMapper INSTANCE = Mappers.getMapper(PersonMapper.class);

   
            public   PersonDTO persontoPersonDTO(Person person);

            public   Person personFormtoPerson(PersonForm personForm);


            public   PersonForm persontoPersonForm(Person person);

}
