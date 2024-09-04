package com.topia.epdms.controller;

import com.topia.epdms.service.UtilityService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1")
public class UtilityController {

    private final UtilityService utilityService;

    public UtilityController(UtilityService utilityService) {
        this.utilityService = utilityService;
    }

    @GetMapping("/health")
    public ResponseEntity<Mono<Boolean>> checkDBHealth() {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(utilityService.checkDBHealth());
    }

    @GetMapping("/test-data/moves/{moveId}")
    public ResponseEntity<Mono<Integer>> deleteTestDataByMoveId(@PathVariable Integer moveId) {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(utilityService.deleteTestDataByMoveId(moveId,1));
    }

    @GetMapping("/test-data/tasks/{taskId}")
    public ResponseEntity<Mono<Integer>> deleteTestDataByTaskId(@PathVariable Integer taskId) {
        return ResponseEntity
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(utilityService.deleteTestDataByTaskId(taskId,0));
    }
}
