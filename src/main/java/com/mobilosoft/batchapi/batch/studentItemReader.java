package com.mobilosoft.batchapi.batch;

import com.mobilosoft.batchapi.BatchapiApplication;
import com.mobilosoft.batchapi.batch.JobLuancherController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
class studentItemReader implements ItemReader<StudentDTO> {


    private List<StudentDTO> studentData;

    @Override
    public StudentDTO read() throws Exception {
        log.info("Reading the information of the next student");

        if (studentDataIsNotInitialized()) {
            studentData = fetchStudentDataFromAPI();
        }

        StudentDTO nextStudent = null;

        if (JobLuancherController.indexLocation < studentData.size()) {
            nextStudent = studentData.get(JobLuancherController.indexLocation);
            JobLuancherController.indexLocation++;
        }

        log.info("Found student: {}", nextStudent);

        return nextStudent;
    }

    private boolean studentDataIsNotInitialized() {
        return this.studentData == null;
    }

    private List<StudentDTO> fetchStudentDataFromAPI() {

            List<StudentDTO> students = new ArrayList<StudentDTO>() {{
                add(new StudentDTO("tony.tester@gmail.com",
                        "Tony Tester",
                        "master"));
                add(new StudentDTO("nick.newbie@gmail.com",
                        "Nick Newbie",
                        "starter"));
                add(new StudentDTO("test@gmail.com",
                        "test",
                        "advanced"));
                add(new StudentDTO("souhaila@gmail.com",
                        "Souhaila",
                        "starter"));
                add(new StudentDTO("asmae@gmail.com",
                        "Asmae",
                        "master"));
                add(new StudentDTO("ian.intermediate@gmail.com",
                        "Ian Intermediate",
                        "intermediate"));
            }};

            return students;
        }

}