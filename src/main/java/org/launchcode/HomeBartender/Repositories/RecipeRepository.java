package org.launchcode.HomeBartender.Repositories;

import org.launchcode.HomeBartender.models.Recipes;
import org.springframework.data.repository.CrudRepository;

public interface RecipeRepository extends CrudRepository<Recipes, Integer> {
}

