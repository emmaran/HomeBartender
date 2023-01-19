package org.launchcode.HomeBartender.data;

import org.launchcode.HomeBartender.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRecipeRepository extends CrudRepository<Recipe, Integer> {
}
