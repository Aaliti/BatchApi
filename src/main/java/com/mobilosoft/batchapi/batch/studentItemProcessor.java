package com.mobilosoft.batchapi.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class studentItemProcessor implements ItemProcessor<StudentDTO, StudentDTO> {

    @Value("${site}")
    private String siteName;

    @Override
    public StudentDTO process(StudentDTO item) throws Exception {

        StudentDTO student = new StudentDTO();
        student.setName(item.getName()+siteName);
        student.setEmailAddress(item.getEmailAddress());
        student.setPurchasedPackage(item.getPurchasedPackage());
        log.info("Processing student information: {}", student);
        return student;
    }
}
