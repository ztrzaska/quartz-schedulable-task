package com.ztrzaska.task;

import com.ztrzaska.model.types.BatchProcessType;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomersReaderTask implements SchedulableTask {

    @Override
    public void execute(JobExecutionContext context) {
        log.info("CustomersReaderTask start reads customers.");

        log.info("CustomersReaderTask end reads customers.");
    }

    @Override
    public BatchProcessType getType() {
        return BatchProcessType.READ_CUSTOMERS;
    }
}
