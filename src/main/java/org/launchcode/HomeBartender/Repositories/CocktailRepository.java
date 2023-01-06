package org.launchcode.HomeBartender.Repositories;

import org.launchcode.HomeBartender.models.Cocktails;
import org.springframework.data.repository.CrudRepository;

public interface CocktailRepository extends CrudRepository<Cocktails, Integer> {
}

