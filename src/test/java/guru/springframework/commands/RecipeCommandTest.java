package guru.springframework.commands;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class RecipeCommandTest {

    Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void testRecipeFail() {
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setDescription("test");
        recipeCommand.setDirections("directions");
        Set<ConstraintViolation<RecipeCommand>> violations = validator.validate(recipeCommand);

        assertFalse(violations.isEmpty());
    }
    @Test
    void testRecipeOk() {
        RecipeCommand recipeCommand = new RecipeCommand();
        recipeCommand.setDescription("test");
        recipeCommand.setDirections("directions");
        recipeCommand.setUrl("https://test.de");
        Set<ConstraintViolation<RecipeCommand>> violations = validator.validate(recipeCommand);

        assertTrue(violations.isEmpty());
    }


}