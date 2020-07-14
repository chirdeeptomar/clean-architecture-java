package uk.co.empyrean.hexagon;

import javax.validation.*;
import java.util.Set;

public abstract class SelfValidating<T> {

    private final Validator validator;

    public SelfValidating() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    private static <T> boolean isInstanceOf(Class<T> clazz, Class<T> targetClass) {
        return clazz.isInstance(targetClass);
    }

    /**
     * Evaluates all Bean Validations on the attributes of this instance.
     */
    protected void validateSelf(T instance) throws ConstraintViolationException {
        Set<ConstraintViolation<T>> violations = validator.validate(instance);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }

    public abstract void validate();
}
