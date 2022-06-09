package uz.d4uranbek.tacos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.d4uranbek.tacos.domains.TacoOrder;

import java.util.UUID;

/**
 * @author D4uranbek
 * @since 09.06.2022
 */
@Repository
public interface OrderRepository extends CrudRepository<TacoOrder, UUID> {
}
