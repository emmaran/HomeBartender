package org.launchcode.HomeBartender.data;

import org.launchcode.HomeBartender.models.UserIngredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserIngredientRepository extends CrudRepository<UserIngredient, Integer> {
}
