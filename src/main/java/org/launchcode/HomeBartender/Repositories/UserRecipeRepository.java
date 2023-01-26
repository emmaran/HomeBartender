package org.launchcode.HomeBartender.Repositories;

import org.launchcode.HomeBartender.models.UserRecipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRecipeRepository extends CrudRepository<UserRecipe, Integer> {
}
