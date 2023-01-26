package org.launchcode.HomeBartender.Repositories;

import org.launchcode.HomeBartender.models.Favorites;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface FavoriteRepository extends CrudRepository<Favorites, Integer> {
}
