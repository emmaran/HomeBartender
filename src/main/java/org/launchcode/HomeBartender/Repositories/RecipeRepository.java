package org.launchcode.HomeBartender.Repositories;

import org.launchcode.HomeBartender.models.Recipes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface RecipeRepository extends CrudRepository<Recipes, Integer> {
}

