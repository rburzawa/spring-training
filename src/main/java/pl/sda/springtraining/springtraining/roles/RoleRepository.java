package pl.sda.springtraining.springtraining.roles;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

Role findByRoleName(String roleName);

}
