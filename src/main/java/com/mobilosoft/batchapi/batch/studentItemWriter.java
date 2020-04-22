package com.mobilosoft.batchapi.batch;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class studentItemWriter implements ItemWriter<StudentDTO> {


    @Override
    public void write(List<? extends StudentDTO> items) throws Exception {
        log.info("Received the information of {} students", items.size());

        items.forEach(i -> log.debug("Received the information of a student: {}", i));
    }
}
