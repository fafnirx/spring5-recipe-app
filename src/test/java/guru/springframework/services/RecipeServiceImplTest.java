package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RecipeServiceImplTest {

    @Mock
    RecipeRepository recipeRepository;
    @InjectMocks
    RecipeServiceImpl recipeService;

    @BeforeEach
    void setUp() {
    }

    @Test
    void findAll() {
        Recipe recipe = new Recipe();
        Set<Recipe> recipeData = new HashSet<>();
        recipeData.add(recipe);
        when(recipeRepository.findAll()).thenReturn(recipeData);

        Set<Recipe> recipes = recipeService.findAll();
        assertEquals(1,recipes.size());

        verify(recipeRepository, times(1)).findAll();
    }

    @Test
    void findById() {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        when(recipeRepository.findById(anyLong())).thenReturn(Optional.of(recipe));

        Recipe searchedRecipe = recipeService.findById(1L);
        assertNotNull(searchedRecipe);
        verify(recipeRepository).findById(anyLong());
    }

    @Test
    void deleteById() {
        recipeService.deleteById( 1L );

        verify(recipeRepository).deleteById(anyLong());
    }
}