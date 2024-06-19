package com.betrybe.agrix.repository;


import com.betrybe.agrix.entity.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Class: Crop Repository.
 */
@Repository
public interface CropRepository extends JpaRepository<Crop, Long> {
}
