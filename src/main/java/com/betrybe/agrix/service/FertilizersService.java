package com.betrybe.agrix.service;


import com.betrybe.agrix.entity.Fertilizer;
import com.betrybe.agrix.repository.FertilizersRepository;
import com.betrybe.agrix.service.exception.FertilizerNotFoundException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Class: Fertilizer Service.
 */
@Service
public class FertilizersService {
  private final FertilizersRepository fertilizersRepository;

  @Autowired
  public FertilizersService(FertilizersRepository fertilizersRepository) {
    this.fertilizersRepository = fertilizersRepository;
  }

  /**
   * Method: Create Fertilizers.
   */
  public Fertilizer create(Fertilizer fertilizer) {
    return fertilizersRepository.save(fertilizer);
  }

  /**
   * Method: Find All Fertilizers.
   */
  public List<Fertilizer> findAll() {
    return fertilizersRepository.findAll();
  }

  /**
   * Method: Find Fertilizers By Id.
   */
  public Fertilizer findById(Long id) throws FertilizerNotFoundException {
    return fertilizersRepository.findById(id)
            .orElseThrow(FertilizerNotFoundException::new);
  }
}
