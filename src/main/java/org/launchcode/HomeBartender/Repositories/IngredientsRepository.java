package org.launchcode.HomeBartender.Repositories;

import org.launchcode.HomeBartender.models.Ingredients;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IngredientsRepository extends CrudRepository<Ingredients,Integer> {

}

