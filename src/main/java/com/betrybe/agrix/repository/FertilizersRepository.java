package com.betrybe.agrix.repository;

import com.betrybe.agrix.entity.Fertilizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Class: Fertilizers Repository.
 */
@Repository
public interface FertilizersRepository extends JpaRepository<Fertilizer, Long> {
}
