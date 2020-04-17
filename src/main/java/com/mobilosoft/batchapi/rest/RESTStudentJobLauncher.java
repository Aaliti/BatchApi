package com.mobilosoft.batchapi.rest;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
@Slf4j
public class RESTStudentJobLauncher {


    //private static final Logger LOGGER = LoggerFactory.getLogger(RESTStudentJobLauncher.class);

    private final Job job;

    private final JobLauncher jobLauncher;

    @Autowired
    RESTStudentJobLauncher(@Qualifier("restStudentJob") Job job, JobLauncher jobLauncher) {
        this.job = job;
        this.jobLauncher = jobLauncher;
    }

    //@Scheduled(cron = "${rest.api.to.database.job.cron}")
    public void launchRestApiToDatabaseJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        log.info("Starting restStudentJob job");

        jobLauncher.run(job, newExecution());

        log.info("Stopping restStudentJob job");
    }

    private JobParameters newExecution() {
        Map<String, JobParameter> parameters = new HashMap<>();

        JobParameter parameter = new JobParameter(new Date());
        parameters.put("currentTime", parameter);


       /* JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
        jobParametersBuilder.addString("siteName",siteName);
        jobParametersBuilder.addDate("currentTime", new Date());
        JobParameters jobParameters =jobParametersBuilder.toJobParameters();*/

        return new JobParameters(parameters);
        //return jobParameters;
    }
}
