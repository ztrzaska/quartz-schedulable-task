package com.ztrzaska;

import com.ztrzaska.model.types.BatchProcessType;
import com.ztrzaska.task.SchedulableTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class SchedulableTaskApplication {

	@Autowired
	private List<SchedulableTask> schedulableTasks;

	@Bean
	public Map<BatchProcessType, SchedulableTask> schedulableTaskMap() {
		Map<BatchProcessType, SchedulableTask> schedulableTaskMap = new HashMap<>();
		for (SchedulableTask converter : schedulableTasks) {
			schedulableTaskMap.put(converter.getType(), converter);
		}
		return schedulableTaskMap;
	}

	public static void main(String[] args) {
		SpringApplication.run(SchedulableTaskApplication.class, args);
	}

}
