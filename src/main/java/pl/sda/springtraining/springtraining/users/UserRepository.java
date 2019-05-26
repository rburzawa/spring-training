package pl.sda.springtraining.springtraining.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query
    boolean existsByUsername(String username);
}
