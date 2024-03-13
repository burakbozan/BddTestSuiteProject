package com.ing.suiteapi.service.usecase.project;

import com.ing.suiteapi.persistence.entity.Project;
import com.ing.suiteapi.persistence.repository.ProjectRepository;
import com.ing.suiteapi.service.dto.Projects;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectRetrieveApplicationService {

    private final ProjectRepository projectRepository;

    public ProjectRetrieveApplicationService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public List<Projects> retrieveProject(){
        return projectRepository.findAll().stream().map(m -> new Projects.Builder().name(m.name()).build()).toList();
    }
}
