package com.ztrzaska.task;

import com.ztrzaska.model.types.BatchProcessType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class BatchProcessExecutor {

    private final Map<BatchProcessType, SchedulableTask> schedulableTasks;

    public void execute(BatchProcessType batchProcessType) {
        SchedulableTask schedulableTask = schedulableTasks.get(batchProcessType);
        if (schedulableTask != null) {
            schedulableTask.execute(null);
        }
    }
}
