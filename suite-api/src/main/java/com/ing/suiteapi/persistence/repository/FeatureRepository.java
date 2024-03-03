package com.ing.suiteapi.persistence.repository;

import com.ing.suiteapi.persistence.entity.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, Long> {
}
