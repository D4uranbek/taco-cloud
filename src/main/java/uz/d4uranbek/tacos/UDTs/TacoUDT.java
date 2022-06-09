package uz.d4uranbek.tacos.UDTs;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.List;

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
@UserDefinedType( "taco" )
public class TacoUDT {

    private final String name;

    private final List<IngredientUDT> ingredients;

}
