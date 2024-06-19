package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.ebytr.staff.entity.Person;
import com.betrybe.agrix.ebytr.staff.security.Role;

/**
 * Class: Person Dto.
 */
public record PersonDto(Long id, String username, Role role) {

  /**
   * Method: Constructor Person Dto.
   */
  public static PersonDto fromEntity(Person person) {
    return new PersonDto(
            person.getId(),
            person.getUsername(),
            person.getRole()
    );
  }
}
