package uk.co.empyrean.hexagon;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.lang.reflect.Type;
import java.util.Set;

public abstract class SelfValidating<T> {

  private Validator validator;

  public SelfValidating() {
    ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    validator = factory.getValidator();
  }

  /**
   * Evaluates all Bean Validations on the attributes of this instance.
   */
  protected void validateSelf(T instance) {
    Set<ConstraintViolation<T>> violations = validator.validate(instance);
    if (!violations.isEmpty()) {
      throw new ConstraintViolationException(violations);
    }
  }

  private static <T> boolean isInstanceOf(Class<T> clazz, Class<T> targetClass) {
    return clazz.isInstance(targetClass);
  }
}
