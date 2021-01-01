package com.ztrzaska.controller;

import com.ztrzaska.model.types.BatchProcessType;
import com.ztrzaska.task.BatchProcessExecutor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class BatchProcessController {

    private final BatchProcessExecutor batchProcessExecutor;

    @GetMapping("/get")
    public ResponseEntity<Void> get(@RequestParam("type") BatchProcessType batchProcessType) {
        batchProcessExecutor.execute(batchProcessType);
        return ResponseEntity.ok().build();
    }

}
