package com.mobilosoft.batchapi.batch;


//import com.mobilosoft.batchapi.batch.JobLuancherController;
import lombok.extern.slf4j.Slf4j;
        import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class ProjecttemReader implements ItemReader<ProjectDTO> {


//    @Value("#{jobParameters[siteName]}")
//    private String siteName;
    private List<ProjectDTO> projectData;

    @Override
    public ProjectDTO read() throws Exception {
        log.info("Reading the information of the next project");

        if (projectDataIsNotInitialized()) {
            projectData = fetchProjectDataFromAPI();
        }

        ProjectDTO nextProject = null;

        if (JobLuancherController.indexLocation < projectData.size()) {
            nextProject = projectData.get(JobLuancherController.indexLocation);
            JobLuancherController.indexLocation++;
        }

        log.info("Found project: {}", nextProject);

        return nextProject;
    }

    private boolean projectDataIsNotInitialized() {
        return this.projectData == null;
    }

    private List<ProjectDTO> fetchProjectDataFromAPI() {

        List<ProjectDTO> projects = new ArrayList<ProjectDTO>() {{
            add(new ProjectDTO("project1",
                    "Descrition1"));
            add(new ProjectDTO("project2",
                    "Descrition2"));
            add(new ProjectDTO("project3",
                    "Descrition3"));
            add(new ProjectDTO("project4",
                    "Descrition4"));
            add(new ProjectDTO("project5",
                    "Descrition5"));

        }};

        return projects;
    }









}
