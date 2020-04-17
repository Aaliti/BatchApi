package com.mobilosoft.batchapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;

import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@EnableTask
@EnableBatchProcessing
@EnableScheduling
@SpringBootApplication
public class BatchapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchapiApplication.class, args);
    }

}
