package com.topia.epdms.service.impl;

import com.topia.epdms.service.UtilityService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UtilityServiceImpl implements UtilityService {
    @Override
    public Mono<Boolean> checkDBHealth() {
        return Mono.just(Boolean.FALSE);
    }

    @Override
    public Mono<Integer> deleteTestDataByMoveId(int moveId, int currentPersonId) {
        return Mono.just(0);
    }

    @Override
    public Mono<Integer> deleteTestDataByTaskId(int taskId, int currentPersonId) {
        return Mono.just(0);
    }
}
