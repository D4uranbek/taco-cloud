package uz.d4uranbek.tacos.domains;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import uz.d4uranbek.tacos.UDTs.TacoUDT;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
@Table( "orders" )
public class TacoOrder implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @PrimaryKey
    private UUID id = Uuids.timeBased();

    private LocalDateTime placedAt = LocalDateTime.now();

    @NotBlank( message = "This field is required" )
    private String deliveryName;

    @NotBlank( message = "This field is required" )
    private String deliveryStreet;

    @NotBlank( message = "This field is required" )
    private String deliveryCity;

    @NotBlank( message = "This field is required" )
    private String deliveryState;

    @NotBlank( message = "This field is required" )
    private String deliveryZip;

    @CreditCardNumber( message = "Enter valid credit card number" )
    private String ccNumber;

    @Pattern( regexp = "^(0[1-9]|1[0-2])(/)([2-9][0-9])$", message = "Must be MM/YY" )
    private String ccExpiration;

    @Digits( integer = 3, fraction = 0, message = "Invalid CCV" )
    private String ccCVV;

    @Column( "tacos" )
    private List<TacoUDT> tacos = new ArrayList<>();

    public void addTaco(TacoUDT taco) {
        this.tacos.add( taco );
    }
}
