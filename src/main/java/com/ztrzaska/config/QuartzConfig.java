package com.ztrzaska.config;

import com.ztrzaska.model.BatchProcess;
import com.ztrzaska.model.types.BatchProcessType;
import com.ztrzaska.repository.BatchProcessRepository;
import com.ztrzaska.task.SchedulableTask;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Configuration
@ConditionalOnProperty(name = "quartz.enabled")
public class QuartzConfig {

    @Autowired
    private Scheduler scheduler;

    @Autowired
    private Map<BatchProcessType, SchedulableTask> schedulableTasks;

    @Autowired
    private BatchProcessRepository batchProcessRepository;

    @PostConstruct
    public void init() throws SchedulerException {
        List<BatchProcess> batchProcesses = batchProcessRepository.findAll();
        for (BatchProcess batchProcess : batchProcesses) {
            SchedulableTask task = schedulableTasks.get(batchProcess.getType());
            if (task != null) {
                Class<? extends SchedulableTask> jobClass = task.getClass();

                JobDetail jobDetail = createJobDetail(jobClass);
                CronTrigger jobTrigger = createJobTrigger(batchProcess, jobClass, jobDetail);
                scheduler.scheduleJob(jobDetail, jobTrigger);
            }
        }
    }

    private JobDetail createJobDetail(Class<? extends SchedulableTask> jobClass) {
        return JobBuilder
                .newJob(jobClass)
                .withIdentity(jobClass.getName())
                .storeDurably()
                .build();
    }

    private CronTrigger createJobTrigger(BatchProcess batchProcess, Class<? extends SchedulableTask> jobClass,
                                         JobDetail jobDetail) {
        return TriggerBuilder.newTrigger().forJob(jobDetail)
                .withIdentity(jobClass.getName() + "Trigger")
                .withSchedule(CronScheduleBuilder.cronSchedule(batchProcess.getCrone()))
                .build();
    }
}
