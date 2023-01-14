package org.launchcode.HomeBartender.data;

import org.launchcode.HomeBartender.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername (String Username);
}
