package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.entity.Farm;

/**
 * Class: Farm Creation Dto.
 */
public record FarmCreationDto(String name, Double size) {

  /**
   * Method: Constructor Farm Creation Dto.
   */
  public Farm toEntity() {
    return new Farm(name, size);
  }
}
