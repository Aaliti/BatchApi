package com.mobilosoft.batchapi.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * Controller which execute our Job
 */

@Slf4j
//@Controller
//@RequestMapping("/import")
@Component
public class JobLuancherController /*extends AbstractAdminController*/ {
    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;

     public static int indexLocation;
//     @Value("${sitename}")
//     private String siteName;



    //@GetMapping("/sites/{siteName}/locations")
    //@GetMapping("/locations")
    public void importSiteFromGoogleTest(/*@PathVariable("siteName") String siteName,*/ ) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
        indexLocation = 0;




            JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
            //jobParametersBuilder.addString("siteName", siteName);
            jobParametersBuilder.addDate("time", new Date());
            JobParameters jobParameters = jobParametersBuilder.toJobParameters();
            JobExecution execution = jobLauncher.run(job, jobParameters);
            log.info(".............. {}", execution.getStatus());
            log.info("\n");





    }
}




