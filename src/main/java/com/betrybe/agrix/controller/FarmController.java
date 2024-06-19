package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.CropCreationDto;
import com.betrybe.agrix.controller.dto.CropDto;
import com.betrybe.agrix.controller.dto.FarmCreationDto;
import com.betrybe.agrix.controller.dto.FarmDto;
import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.entity.Farm;
import com.betrybe.agrix.service.FarmService;
import com.betrybe.agrix.service.exception.FarmNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Farm Controller class.
 */
@RestController
@RequestMapping(value = "/farms")
public class FarmController {

  private final FarmService farmService;

  @Autowired
  public FarmController(FarmService farmService) {
    this.farmService = farmService;
  }

  /**
   * Method: Get Farm By Id.
   */
  @GetMapping("/{id}")
  public FarmDto getFarmById(@PathVariable Long id) throws FarmNotFoundException {
    return FarmDto.fromEntity(
            farmService.findById(id)
    );
  }

  /**
   * Method: Get All Farms.
   */
  @GetMapping
  public List<FarmDto> getAllFarms() {
    List<Farm> allFarms = farmService.findAll();

    return allFarms.stream()
            .map(FarmDto::fromEntity)
            .toList();
  }

  /**
   * Method: Create Farm.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FarmDto createFarm(@RequestBody FarmCreationDto farmCreationDto) {
    return FarmDto.fromEntity(
            farmService.create(farmCreationDto.toEntity())
    );
  }

  /**
   * Method: Get Crop By Farm Id.
   */
  @GetMapping("/{farmId}/crops")
  public List<CropDto> findAllCropsByFarmId(
          @PathVariable Long farmId
  ) throws FarmNotFoundException {
    List<Crop> allCrops = farmService.findAllCropsByFarmId(farmId);

    return allCrops.stream()
            .map(CropDto::fromEntity)
            .toList();
  }

  /**
   * Method: Create Crop By Farm Id.
   */
  @PostMapping("/{farmId}/crops")
  @ResponseStatus(HttpStatus.CREATED)
  public CropDto createCropByFarmId(
          @PathVariable Long farmId,
          @RequestBody CropCreationDto cropCreationDto) throws FarmNotFoundException {
    return CropDto.fromEntity(
            farmService.createCropByFarmId(farmId, cropCreationDto.toEntity())
    );
  }

  /**
   * Method: Update Farm.
   */
  @PutMapping("/{id}")
  public FarmDto updateFarm(@PathVariable Long id,
      @RequestBody FarmCreationDto farmCreationDto) throws FarmNotFoundException {
    return FarmDto.fromEntity(
            farmService.update(id, farmCreationDto.toEntity())
    );
  }

  /**
   * Method: Delete Farm.
   */
  @DeleteMapping("/{id}")
  public FarmDto deleteFarmById(@PathVariable Long id) throws FarmNotFoundException {
    return FarmDto.fromEntity(
            farmService.deleteById(id)
    );
  }
}
