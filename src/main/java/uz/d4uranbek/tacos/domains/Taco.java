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
public class Taco {

    private String name;

    private List<Ingredient> ingredients;

}
