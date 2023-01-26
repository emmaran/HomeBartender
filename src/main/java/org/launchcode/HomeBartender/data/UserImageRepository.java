package org.launchcode.HomeBartender.data;

import org.launchcode.HomeBartender.models.UserImageData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserImageRepository extends JpaRepository<UserImageData, Integer> {

    Optional<UserImageData> findByName(String fileName);

}
