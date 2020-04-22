package com.mobilosoft.batchapi.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Configuration class
 */

@Configuration
@EnableBatchProcessing
public class JobBatchConfig {
    private static final int CHUNK = 1;

    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private ItemReader<ProjectDTO> projectItemReader;
    @Autowired
    private ItemProcessor<ProjectDTO, ProjectDTO> projectItemProcessor;
    @Autowired
    private ItemWriter<ProjectDTO> projectItemWriter;

    @Autowired
    private ItemReader<StudentDTO> studentItemReader;
    @Autowired
    private ItemProcessor<StudentDTO, StudentDTO> studentItemProcessor;
    @Autowired
    private ItemWriter<StudentDTO> studentItemWriter;

    @Value("${site}")
    String site;


    @Bean
    public Step prjStep() {
        return stepBuilderFactory.get("projectStep")
                .<ProjectDTO, ProjectDTO>chunk(CHUNK)
                .reader(projectItemReader)
                .processor(projectItemProcessor)
                .writer(projectItemWriter)
                .build();
    }

    @Bean
    public Step stdStep() {
        return stepBuilderFactory.get("studentStep")
                .<StudentDTO, StudentDTO>chunk(CHUNK)
                .reader(studentItemReader)
                .processor(studentItemProcessor)
                .writer(studentItemWriter)
                .build();
    }

    @Bean
    public Job myJob() {
        if(site.equals("project")){


            return jobBuilderFactory.get(site +"-job")
                    .start(prjStep())
                    .build();

        }else if (site.equals("student")){


            return jobBuilderFactory.get(site +"-job")
                    .start(stdStep())
                    .build();
        }else {
            return null;
        }

    }

}