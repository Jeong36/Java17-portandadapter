package com.example.java17sample.shared;

import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;

/**
 * Java record 객체를 new 로 생성할 때 유효성을 검증하기 위한 용도로 구현된 클래스입니다.
 * record 가 아닌 경우에는 사용하지 않는 것을 권장합니다.
 * 필수가 아닌 필요한 경우에만 사용하는 것을 권장합니다.
 *
 * @param <T> record type
 */
public class RecordValidator<T> {

    public void validateSelf(T that) {
        try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
            final var violations = factory.getValidator()
                .validate(that);

            if (!violations.isEmpty()) {
                throw new ConstraintViolationException(violations);
            }
        }
    }
}
