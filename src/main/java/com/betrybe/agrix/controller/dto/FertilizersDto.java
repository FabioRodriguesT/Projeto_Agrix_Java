package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.entity.Fertilizer;

/**
 * Class: Fertilizers Dto.
 */
public record FertilizersDto(Long id, String name, String brand, String composition) {

  /**
   * Method: Constructor Fertilizers Dto.
   */
  public static FertilizersDto fromEntity(Fertilizer fertilizers) {
    return new FertilizersDto(
            fertilizers.getId(),
            fertilizers.getName(),
            fertilizers.getBrand(),
            fertilizers.getComposition()
    );
  }
}
