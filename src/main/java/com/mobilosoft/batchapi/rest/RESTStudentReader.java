package com.mobilosoft.batchapi.rest;

import com.mobilosoft.batchapi.student.StudentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


class RESTStudentReader implements ItemReader<StudentDTO> {

    private static final Logger LOGGER = LoggerFactory.getLogger(RESTStudentReader.class);

    //private final String apiUrl;
    //private final RestTemplate restTemplate;

    private int nextStudentIndex;
    private List<StudentDTO> studentData;

    /*RESTStudentReader(String apiUrl, RestTemplate restTemplate) {
        this.apiUrl = apiUrl;
        this.restTemplate = restTemplate;
        nextStudentIndex = 0;
    }*/

    @Override
    public StudentDTO read() throws Exception {
        LOGGER.info("Reading the information of the next student");

        if (studentDataIsNotInitialized()) {
            studentData = fetchStudentDataFromAPI();
        }

        StudentDTO nextStudent = null;

        if (nextStudentIndex < studentData.size()) {
            nextStudent = studentData.get(nextStudentIndex);
            nextStudentIndex++;
        }

        LOGGER.info("Found student: {}", nextStudent);

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