package com.topia.epdms.service;

import reactor.core.publisher.Mono;

public interface UtilityService {
    Mono<Boolean> checkDBHealth();
    Mono<Integer> deleteTestDataByMoveId(int moveId, int currentPersonId);
    Mono<Integer> deleteTestDataByTaskId(int taskId, int currentPersonId);
}
