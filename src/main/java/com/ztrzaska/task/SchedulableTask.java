package com.ztrzaska.task;

import com.ztrzaska.model.types.BatchProcessType;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;

@DisallowConcurrentExecution
public interface SchedulableTask extends Job {

    void execute(JobExecutionContext context);

    BatchProcessType getType();
}
