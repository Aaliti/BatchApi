//package com.mobilosoft.batchapi.rest;
//
//
//import com.mobilosoft.batchapi.student.StudentDTO;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.w3c.dom.stylesheets.LinkStyle;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/student")
//public class RESTController {
//
//    @GetMapping
//    public List<StudentDTO> getStudents(){
//        List<StudentDTO> students = new ArrayList<StudentDTO>() {{
//            add(new StudentDTO("tony.tester@gmail.com",
//                    "Tony Tester",
//                    "master"));
//            add(new StudentDTO("nick.newbie@gmail.com",
//                    "Nick Newbie",
//                    "starter"));
//            add(new StudentDTO("test@gmail.com",
//                    "test",
//                    "advanced"));
//            add(new StudentDTO("souhaila@gmail.com",
//                    "Souhaila",
//                    "starter"));
//            add(new StudentDTO("asmae@gmail.com",
//                    "Asmae",
//                    "master"));
//            add(new StudentDTO("ian.intermediate@gmail.com",
//                    "Ian Intermediate",
//                    "intermediate"));
//        }};
//
//        return students;
//    }
//
//
//}
