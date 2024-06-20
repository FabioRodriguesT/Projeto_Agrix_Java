package com.betrybe.agrix.controller;


import com.betrybe.agrix.controller.dto.FertilizersCreationDto;
import com.betrybe.agrix.controller.dto.FertilizersDto;
import com.betrybe.agrix.entity.Fertilizer;
import com.betrybe.agrix.service.FertilizersService;
import com.betrybe.agrix.service.exception.FertilizerNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Fertilizers Controller class.
 */
@RestController
@RequestMapping(value = "/fertilizers")
public class FertilizersController {
  private final FertilizersService fertilizersService;

  @Autowired
  public FertilizersController(FertilizersService fertilizersService) {
    this.fertilizersService = fertilizersService;
  }

  /**
   * Method: Create Fertilizers.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public FertilizersDto createFertilizers(
          @RequestBody FertilizersCreationDto fertilizersCreationDto
  ) {
    return FertilizersDto.fromEntity(
            fertilizersService.create(fertilizersCreationDto.toEntity())
    );
  }

  /**
   * Method: Get All Fertilizers.
   */
  @GetMapping
  @PreAuthorize("hasRole('ADMIN')")
  public List<FertilizersDto> getAllFertilizers() {
    List<Fertilizer> allFertilizers = fertilizersService.findAll();

    return allFertilizers.stream()
            .map(FertilizersDto::fromEntity)
            .toList();
  }

  /**
   * Method: Get Fertilizers By Id.
   */
  @GetMapping("/{id}")
  public FertilizersDto getFertilizerById(@PathVariable Long id)
          throws FertilizerNotFoundException {
    return FertilizersDto.fromEntity(
          fertilizersService.findById(id)
    );
  }
}
