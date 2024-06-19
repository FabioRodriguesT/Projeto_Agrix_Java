package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.entity.Fertilizer;

/**
 * Class: Fertilizers Creation Dto.
 */
public record FertilizersCreationDto(String name, String brand, String composition) {

  /**
   * Method: Constructor Fertilizers Creation Dto.
   */
  public Fertilizer toEntity() {
    return new Fertilizer(name, brand, composition);
  }
}
