package uz.d4uranbek.tacos.domains;

import lombok.*;

import java.util.List;

/**
 * @author D4uranbek
 * @since 08.06.2022
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
@RequiredArgsConstructor
public class TacoOrder {

    private String deliveryName;

    private String deliveryStreet;

    private String deliveryCity;

    private String deliveryState;

    private String deliveryZip;

    private String ccNumber;

    private String ccExpiration;

    private String ccCVV;

    private List<Taco> tacos;

    public void addTaco(Taco taco) {
        this.tacos.add( taco );
    }
}
