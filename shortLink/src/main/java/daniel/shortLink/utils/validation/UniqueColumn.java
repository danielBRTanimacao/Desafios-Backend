package daniel.shortLink.utils.validation;

import daniel.shortLink.utils.validation.impl.UniqueCustomValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueCustomValidator.class)
public @interface UniqueColumn {
    String message() default "Column is need to be unique";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
