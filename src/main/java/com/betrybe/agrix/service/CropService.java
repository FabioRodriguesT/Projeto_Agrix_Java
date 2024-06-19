package com.betrybe.agrix.service;

import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.entity.Fertilizer;
import com.betrybe.agrix.repository.CropRepository;
import com.betrybe.agrix.service.exception.CropNotFoundException;
import com.betrybe.agrix.service.exception.FertilizerNotFoundException;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class: Crop Service.
 */
@Service
public class CropService {
  private final CropRepository cropRepository;
  private final FertilizersService fertilizersService;

  @Autowired
  public CropService(
          CropRepository cropRepository,
          FertilizersService fertilizersService) {
    this.cropRepository = cropRepository;
    this.fertilizersService = fertilizersService;
  }

  /**
   * Method: List All Crops.
   */
  public List<Crop> findAll() {
    return cropRepository.findAll();
  }

  /**
   * Method: Create Crop.
   */
  public Crop create(Crop crop) {
    return cropRepository.save(crop);
  }

  /**
   * Method: Find Crop By Id.
   */
  public Crop findById(Long id) throws CropNotFoundException {
    return cropRepository.findById(id)
            .orElseThrow(CropNotFoundException::new);
  }

  /**
   * Method: Find Crop By Date.
   */
  public List<Crop> findByDate(LocalDate start, LocalDate end) {
    List<Crop> allCrops = findAll();

    return allCrops.stream()
            .filter((crop) ->
                    crop.getHarvestDate().isAfter(start) && crop.getHarvestDate().isBefore(end)
            ).toList();
  }

  /**
   * Method: Find Fertilizers By CropId.
   */
  public List<Fertilizer> findByFertilizersByCropId(Long cropId) throws CropNotFoundException {
    Crop crop = findById(cropId);
    return crop.getFertilizers();
  }

  /**
   * Method: Update Crop.
   */
  public Crop update(Long id, Crop crop) throws CropNotFoundException {
    Crop cropFromDb = findById(id);

    cropFromDb.setName(crop.getName());
    cropFromDb.setPlantedArea(crop.getPlantedArea());
    cropFromDb.setFarm(crop.getFarm());

    return cropRepository.save(cropFromDb);
  }

  /**
   * Method: Delete Crop.
   */
  public Crop deleteById(Long id) throws CropNotFoundException {
    // Pegamoas a entidade, caso não exista jogue uma exceção, se existir delete e devolva a farm.
    Crop crop = findById(id);

    cropRepository.deleteById(id);

    return crop;
  }

  /**
   * Method: Add Crop a Fertilizer.
   */
  public void addCropFertilizer(Long cropId, Long fertilizerId)
      throws CropNotFoundException, FertilizerNotFoundException {
    Crop crop = findById(cropId);
    Fertilizer fertilizer = fertilizersService.findById(fertilizerId);

    crop.getFertilizers().add(fertilizer);

    cropRepository.save(crop);
  }

  /**
   * Method: Remove Crop a Fertilizer.
   */
  public void removeCropFertilizer(Long cropId, Long fertilizerId)
      throws CropNotFoundException, FertilizerNotFoundException {
    Crop crop = findById(cropId);
    Fertilizer fertilizer = fertilizersService.findById(fertilizerId);

    crop.getFertilizers().remove(fertilizer);

    cropRepository.save(crop);
  }
}
