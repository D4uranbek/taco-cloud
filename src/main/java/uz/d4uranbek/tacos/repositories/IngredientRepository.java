package uz.d4uranbek.tacos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uz.d4uranbek.tacos.domains.Ingredient;

/**
 * @author D4uranbek
 * @since 09.06.2022
 */
@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
