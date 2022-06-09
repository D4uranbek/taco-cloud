package uz.d4uranbek.tacos.UDTs;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;
import uz.d4uranbek.tacos.domains.Ingredient;

/**
 * @author D4uranbek
 * @since 09.06.2022
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Builder
@RequiredArgsConstructor
@NoArgsConstructor( access = AccessLevel.PRIVATE, force = true )
@UserDefinedType( "ingredient" )
public class IngredientUDT {

    private final String name;

    private final Ingredient.Type type;

}
