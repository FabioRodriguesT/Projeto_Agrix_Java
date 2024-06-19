package com.betrybe.agrix.controller.dto;

import com.betrybe.agrix.entity.Crop;
import java.time.LocalDate;
import java.util.List;


/**
 * Class: Crop Dto.
 */
public record CropDto(
        Long id,
        Long farmId,
        String name,
        Double plantedArea,
        LocalDate plantedDate,
        LocalDate harvestDate
) {
  /**
   * Method: Constructor Crop Dto.
   */
  public static CropDto fromEntity(Crop crop) {
    return new CropDto(
            crop.getId(),
            crop.getFarm().getId(),
            crop.getName(),
            crop.getPlantedArea(),
            crop.getPlantedDate(),
            crop.getHarvestDate()
    );
  }
}
