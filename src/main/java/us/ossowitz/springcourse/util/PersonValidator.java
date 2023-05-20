package us.ossowitz.springcourse.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import us.ossowitz.springcourse.models.Person;

public class PersonValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return Person.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Person person = (Person) target;

        // посмотреть, есть ли человек с таким же email'ом в БД //
    }
}
