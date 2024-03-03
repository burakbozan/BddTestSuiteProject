package com.ing.suiteapi.service.impl;

import com.ing.suiteapi.persistence.entity.Feature;
import com.ing.suiteapi.persistence.repository.FeatureRepository;
import com.ing.suiteapi.service.FeatureService;
import com.ing.suiteapi.service.dto.FeatureDto;
import com.ing.suiteapi.util.GherkinUtils;
import java.time.LocalDateTime;
import org.springframework.stereotype.Service;

@Service
public class FeatureServiceImpl implements FeatureService {

    private final FeatureRepository featureRepository;

    public FeatureServiceImpl(FeatureRepository featureRepository) {
        this.featureRepository = featureRepository;
    }

    @Override
    public void createFeature(FeatureDto featureDto) {
        Feature feature = new Feature();
        feature.setTitle(featureDto.title());
        feature.setDescription(featureDto.description());
        feature.setAuthor(featureDto.author());
        feature.setText(featureDto.text());
        feature.setScenarioCount(GherkinUtils.countScenarios(featureDto.text()));
        feature.setCreatedAt(LocalDateTime.now());
        featureRepository.save(feature);
    }

}
