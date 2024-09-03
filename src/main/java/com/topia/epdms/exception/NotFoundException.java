package com.topia.epdms.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
public class NotFoundException extends Exception {
    private final String message;
    private final String field;
}
