package com.mobilosoft.batchapi.batch;


import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@StepScope
public class ProjectItemProcessor implements ItemProcessor<ProjectDTO, ProjectDTO> {

//
//    @Value("#{jobParameters[siteName]}")
//    private String siteName;
//
    @Value("${site}")
    private String siteName;

    @Override
    public ProjectDTO process(ProjectDTO item) throws Exception {

        ProjectDTO project = new ProjectDTO();
        project.setTitle(item.getTitle()+siteName);
        project.setDescription(item.getDescription());
        log.info("Processing project information: {}", project);
        return project;
    }
}