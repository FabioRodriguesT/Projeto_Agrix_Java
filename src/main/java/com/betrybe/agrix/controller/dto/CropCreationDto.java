package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.entity.Crop;
import java.time.LocalDate;

/**
 * Class: Crop Creation Dto.
 */
public record CropCreationDto(
        String name,
        Double plantedArea,
        LocalDate plantedDate,
        LocalDate harvestDate
) {
  /**
   * Method: Constructor Crop Creation Dto.
   */
  public Crop toEntity() {
    return new Crop(name, plantedArea, plantedDate, harvestDate);
  }
}
