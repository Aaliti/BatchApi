package com.mobilosoft.batchapi.rest;

import com.mobilosoft.batchapi.common.LoggingStudentProcessor;
import com.mobilosoft.batchapi.common.LoggingStudentWriter;
import com.mobilosoft.batchapi.student.StudentDTO;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RESTStudentJobConfig {

    //private static final String PROPERTY_REST_API_URL = "rest.api.to.database.job.api.url";

    @Bean
    ItemReader<StudentDTO> restStudentReader() {
        return new RESTStudentReader();
    }

    @Bean
    ItemProcessor<StudentDTO, StudentDTO> restStudentProcessor() {
        return new LoggingStudentProcessor();
    }

    @Bean
    ItemWriter<StudentDTO> restStudentWriter() {
        return new LoggingStudentWriter();
    }

    @Bean
    Step restStudentStep(ItemReader<StudentDTO> restStudentReader,
                         ItemProcessor<StudentDTO, StudentDTO> restStudentProcessor,
                         ItemWriter<StudentDTO> restStudentWriter,
                         StepBuilderFactory stepBuilderFactory) {
        return stepBuilderFactory.get("restStudentStep")
                .<StudentDTO, StudentDTO>chunk(1)
                .reader(restStudentReader)
                .processor(restStudentProcessor)
                .writer(restStudentWriter)
                .build();
    }

    @Bean
    Job restStudentJob(JobBuilderFactory jobBuilderFactory,
                       @Qualifier("restStudentStep") Step restStudentStep) {
        return jobBuilderFactory.get("restStudentJob")
                .incrementer(new RunIdIncrementer())
                .flow(restStudentStep)
                .end()
                .build();
    }
}
