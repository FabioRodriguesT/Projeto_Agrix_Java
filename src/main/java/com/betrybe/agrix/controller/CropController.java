package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.CropCreationDto;
import com.betrybe.agrix.controller.dto.CropDto;
import com.betrybe.agrix.controller.dto.FertilizersDto;
import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.entity.Fertilizer;
import com.betrybe.agrix.service.CropService;
import com.betrybe.agrix.service.exception.CropNotFoundException;
import com.betrybe.agrix.service.exception.FertilizerNotFoundException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Crop Controller class.
*/
@RestController
@RequestMapping(value = "/crops")
public class CropController {

  private final CropService cropService;

  @Autowired
  public CropController(CropService cropService) {
    this.cropService = cropService;
  }

  /**
   * Method: Get Crop By Id.
  */
  @GetMapping("/{id}")
  public CropDto getCropById(@PathVariable Long id) throws CropNotFoundException {
    return CropDto.fromEntity(
            cropService.findById(id)
    );
  }

  /**
   * Method: Get By Search Terms.
   */
  @GetMapping("/search")
  public List<CropDto> searchCrop(@RequestParam LocalDate start, LocalDate end) {
    List<Crop> allCrops = cropService.findByDate(start, end);
    return allCrops.stream()
            .map(CropDto::fromEntity)
            .toList();
  }

  /**
   * Method: Get CropId with your Fertilizers.
   */
  @GetMapping("/{cropId}/fertilizers")
  public List<FertilizersDto> getCropFertilizers(@PathVariable Long cropId)
          throws CropNotFoundException {
    List<Fertilizer> fertilizersList = cropService.findByFertilizersByCropId(cropId);

    return fertilizersList.stream()
            .map(FertilizersDto::fromEntity)
            .toList();
  }

  /**
   * Method: Get All Crops.
   */
  @GetMapping
  @PreAuthorize("hasAnyRole('MANAGER', 'ADMIN')")
  public List<CropDto> getAllCrops() {
    List<Crop> allCrops = cropService.findAll();
    return allCrops.stream()
            .map(CropDto::fromEntity)
            .toList();
  }

  /**
   * Method: Create Crop.
   */
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CropDto createCrop(@RequestBody CropCreationDto cropCreationDto) {
    return CropDto.fromEntity(
            cropService.create(cropCreationDto.toEntity())
    );
  }

  /**
   * Method: Associat a Crop a Fertilizer.
   */
  @PostMapping("/{cropId}/fertilizers/{fertilizerId}")
  @ResponseStatus(HttpStatus.CREATED)
  public String addCropFertilizer(@PathVariable Long cropId,
        @PathVariable Long fertilizerId) throws CropNotFoundException, FertilizerNotFoundException {
    cropService.addCropFertilizer(cropId, fertilizerId);

    return "Fertilizante e plantação associados com sucesso!";
  }

  /**
   * Method: Update Crop.
   */
  @PutMapping("/{id}")
  public CropDto updateCrop(@PathVariable Long id,
      @RequestBody CropCreationDto cropCreationDto) throws CropNotFoundException {
    return CropDto.fromEntity(
            cropService.update(id, cropCreationDto.toEntity())
    );
  }

  /**
   * Method: Delete Crop.
   */
  @DeleteMapping("/{id}")
  public CropDto deleteCropById(@PathVariable Long id) throws CropNotFoundException {
    return CropDto.fromEntity(
            cropService.deleteById(id)
    );
  }
}
