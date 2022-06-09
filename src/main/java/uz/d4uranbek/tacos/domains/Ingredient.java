package uz.d4uranbek.tacos.domains;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

/**
 * @author D4uranbek
 * @since 08.06.2022
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor( access = AccessLevel.PRIVATE, force = true )
@AllArgsConstructor
@Table( "ingredients" )
public final class Ingredient {

    @PrimaryKey
    private String id;

    private String name;

    private Type type;

    public enum Type {
        WRAP,
        PROTEIN,
        VEGGIES,
        CHEESE,
        SAUCE
    }
}
