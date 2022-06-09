package uz.d4uranbek.tacos.domains;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
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

    @NotNull
    @Size( min = 5, message = "Name must be at least 5 characters long" )
    private String name;

    @NotNull
    @Size(min = 1, message = "You must choose at least 1 ingredient")
    private List<Ingredient> ingredients;

}
