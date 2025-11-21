package daniel.shortLink.utils.validation.impl;

import daniel.shortLink.repository.LinkRepository;
import daniel.shortLink.utils.validation.UniqueColumn;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueCustomValidator implements ConstraintValidator<UniqueColumn, String> {
    private final LinkRepository repository;

    public UniqueCustomValidator(LinkRepository repository) {
        this.repository = repository;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return !repository.existsByUrl(value);
    }
}
