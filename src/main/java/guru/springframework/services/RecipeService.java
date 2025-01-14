package guru.springframework.services;

import guru.springframework.commands.RecipeCommand;
import guru.springframework.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> findAll();
    Recipe findById(Long id);

    void deleteById(Long id);

    RecipeCommand findCommandById( Long id);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
}
