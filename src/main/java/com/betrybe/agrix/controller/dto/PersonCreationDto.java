package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.entity.Person;
import com.betrybe.agrix.security.Role;

/**
 * Class: Person Creation Dto.
 */
public record PersonCreationDto(String username, String password, Role role) {

  /**
   * Method: Constructor Person Creation Dto.
   */
  public Person toEntity() {

    return new Person(username, password, role);
  }
}
