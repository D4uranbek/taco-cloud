package uz.d4uranbek.tacos.domains;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;
import uz.d4uranbek.tacos.UDTs.IngredientUDT;
import uz.d4uranbek.tacos.utils.TacoUDRUtils;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * @author D4uranbek
 * @since 08.06.2022
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Table( "tacos" )
public class Taco {

    @PrimaryKeyColumn( type = PrimaryKeyType.PARTITIONED )
    private UUID id = Uuids.timeBased();

    @NotNull
    @Size( min = 5, message = "Name must be at least 5 characters long" )
    private String name;

    @PrimaryKeyColumn( type = PrimaryKeyType.CLUSTERED,
            ordering = Ordering.DESCENDING )
    private LocalDateTime createdAt = LocalDateTime.now();

    @Size( min = 1, message = "You must choose at least 1 ingredient" )
    @Column( "ingredients" )
    private List<IngredientUDT> ingredients;

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add( TacoUDRUtils.toIngredientUDT( ingredient ) );
    }

}
