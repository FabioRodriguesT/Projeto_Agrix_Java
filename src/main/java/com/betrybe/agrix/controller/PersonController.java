package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.PersonCreationDto;
import com.betrybe.agrix.controller.dto.PersonDto;
import com.betrybe.agrix.ebytr.staff.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Person Controller class.
 */
@RestController
@RequestMapping(value = "/persons")
public class PersonController {
  private final PersonService personService;

  @Autowired
  public PersonController(PersonService personService) {
    this.personService = personService;
  }

  /**
   * Method: Create Persons.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PersonDto createPerson(
          @RequestBody PersonCreationDto personCreationDto
  ) {
    return PersonDto.fromEntity(
            personService.create(personCreationDto.toEntity())
    );
  }
}
