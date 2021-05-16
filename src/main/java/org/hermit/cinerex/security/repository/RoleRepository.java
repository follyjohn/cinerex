package org.hermit.cinerex.security.repository;

import java.util.Optional;

import org.hermit.cinerex.security.models.ERole;
import org.hermit.cinerex.security.models.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
    Optional<Role> findByName(ERole name);
}
