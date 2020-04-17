package com.mobilosoft.batchapi.common;

import com.mobilosoft.batchapi.student.StudentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;

/**
 * This custom {@code ItemProcessor} simply writes the information of the
 * processed student to the log and returns the processed object.

 */
public class LoggingStudentProcessor implements ItemProcessor<StudentDTO, StudentDTO> {

    @Value("${sitename}")
    private String siteName;
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingStudentProcessor.class);

    @Override
    public StudentDTO process(StudentDTO item) throws Exception {

        StudentDTO student = new StudentDTO();
        student.setName(item.getName()+siteName);
        student.setEmailAddress(item.getEmailAddress());
        student.setPurchasedPackage(item.getPurchasedPackage());
        LOGGER.info("Processing student information: {}", student);
        return student;
    }
}
