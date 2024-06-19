package com.betrybe.agrix.service;

import com.betrybe.agrix.entity.Crop;
import com.betrybe.agrix.entity.Farm;
import com.betrybe.agrix.repository.CropRepository;
import com.betrybe.agrix.repository.FarmRepository;
import com.betrybe.agrix.service.exception.FarmNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class: Farm Service.
 */
@Service
public class FarmService {
  private final FarmRepository farmRepository;
  private final CropRepository cropRepository;

  @Autowired
  public FarmService(FarmRepository farmRepository, CropRepository cropRepository) {
    this.farmRepository = farmRepository;
    this.cropRepository = cropRepository;
  }

  /**
   * Method: Find All Farms.
   */
  public List<Farm> findAll() {
    return farmRepository.findAll();
  }

  /**
   * Method: Create Farm.
   */
  public Farm create(Farm farm) {
    return farmRepository.save(farm);
  }


  /**
   * Method: Find Farm By Id.
   */
  public Farm findById(Long id) throws FarmNotFoundException {
    return farmRepository.findById(id)
            .orElseThrow(FarmNotFoundException::new);
  }

  /**
   * Method: Get Crop By Farm Id.
   */
  public List<Crop> findAllCropsByFarmId(Long farmId) throws FarmNotFoundException {
    Farm farm = findById(farmId);

    return cropRepository.findAll().stream()
            .filter(crop -> farmId.equals(crop.getFarm().getId()))
            .toList();
  }

  /**
   * Method: Create Crop By Farm Id.
   */
  public Crop createCropByFarmId(Long farmId, Crop crop) throws FarmNotFoundException {
    Farm farm = findById(farmId);

    crop.setFarm(farm);

    return cropRepository.save(crop);
  }

  /**
   * Method: Update Farm.
   */
  public Farm update(Long id, Farm farm) throws FarmNotFoundException {
    Farm farmFromDb = findById(id);

    farmFromDb.setName(farm.getName());
    farmFromDb.setSize(farm.getSize());

    return farmRepository.save(farmFromDb);
  }

  /**
   * Method: Delete Farm By Id.
   */
  public Farm deleteById(Long id) throws FarmNotFoundException {
    // Pegamoas a entidade, caso não exista jogue uma exceção, se existir delete e devolva a farm.
    Farm farm = findById(id);

    farmRepository.deleteById(id);

    return farm;
  }
}
