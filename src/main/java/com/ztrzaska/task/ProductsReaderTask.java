package com.ztrzaska.task;

import com.ztrzaska.model.types.BatchProcessType;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ProductsReaderTask implements SchedulableTask {

    @Override
    public void execute(JobExecutionContext context) {
        log.info("ProductsReaderTask start reads products.");
        
        log.info("ProductsReaderTask end reads products.");
    }

    @Override
    public BatchProcessType getType() {
        return BatchProcessType.READ_PRODUCTS;
    }
}
