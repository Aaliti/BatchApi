package com.mobilosoft.batchapi.batch;

import lombok.Data;
import lombok.ToString;

@Data @ToString
public class StudentDTO {

    private String emailAddress;
    private String name;

    public StudentDTO(String emailAddress, String name, String purchasedPackage) {
        this.emailAddress = emailAddress;
        this.name = name;
        this.purchasedPackage = purchasedPackage;
    }

    private String purchasedPackage;

    public StudentDTO() {}
}
