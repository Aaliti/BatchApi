package com.mobilosoft.batchapi;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;


//@EnableTask
//@EnableBatchProcessing
//@EnableScheduling
@SpringBootApplication
@Slf4j
public class BatchapiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BatchapiApplication.class, args);
    }

}
