package uz.d4uranbek.tacos.repositories;

import org.springframework.data.repository.CrudRepository;
import uz.d4uranbek.tacos.domains.User;

import java.util.Optional;
import java.util.UUID;

/**
 * @author D4uranbek
 * @since 09.06.2022
 */
public interface UserRepository extends CrudRepository<User, UUID> {

    Optional<User> findByUsername(String username);

}
