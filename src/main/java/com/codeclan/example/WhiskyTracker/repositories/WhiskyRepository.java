package com.codeclan.example.WhiskyTracker.repositories;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface WhiskyRepository extends JpaRepository<Whisky, Long> {
    List<Whisky> findByYear(int year);

    List<Whisky> findByDistilleryIdAndAge(Long id, Integer age);

    List<Whisky> findByDistilleryId(Long id);

    List<Whisky> findByDistilleryRegionIgnoreCase(String region);
}