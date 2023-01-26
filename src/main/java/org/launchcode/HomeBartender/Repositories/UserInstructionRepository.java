package org.launchcode.HomeBartender.Repositories;

import org.launchcode.HomeBartender.models.UserInstruction;
import org.springframework.data.repository.CrudRepository;

public interface UserInstructionRepository extends CrudRepository<UserInstruction, Integer> {
}
