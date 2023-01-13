package org.launchcode.HomeBartender.data;

import org.launchcode.HomeBartender.models.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserIngredientRepository extends CrudRepository<Ingredient, Integer> {
}
