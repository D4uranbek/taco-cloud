package uz.d4uranbek.tacos.converters;

import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import uz.d4uranbek.tacos.UDTs.IngredientUDT;
import uz.d4uranbek.tacos.domains.Ingredient;
import uz.d4uranbek.tacos.repositories.IngredientRepository;
import uz.d4uranbek.tacos.utils.TacoUDRUtils;

/**
 * @author D4uranbek
 * @since 09.06.2022
 */
@RequiredArgsConstructor
@Component
public class IngredientByIdConverter implements Converter<String, IngredientUDT> {

    private final IngredientRepository ingredientRepository;

    @Override
    public IngredientUDT convert(String id) {
        Ingredient ingredient = ingredientRepository.findById( id )
                .orElseThrow( () -> new RuntimeException( "Ingredient with this ID not found" ) );

        return TacoUDRUtils.toIngredientUDT( ingredient );
    }

}

