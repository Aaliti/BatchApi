package com.mobilosoft.batchapi.batch;

import lombok.Data;
import lombok.ToString;

@Data @ToString
public class ProjectDTO {

    private String title;
    private String description;

    public ProjectDTO(String title, String description) {
        this.title = title;
        this.description = description;
    }


    public ProjectDTO() {}
}
