package com.mobilosoft.batchapi.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class ProjectItemWriter implements ItemWriter<ProjectDTO> {


    @Override
    public void write(List<? extends ProjectDTO> items) throws Exception {
        log.info("Received the information of {} projects", items.size());

        items.forEach(i -> log.debug("Received the information of a project: {}", i));
    }
}