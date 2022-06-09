package uz.d4uranbek.tacos.utils;

import uz.d4uranbek.tacos.UDTs.IngredientUDT;
import uz.d4uranbek.tacos.UDTs.TacoUDT;
import uz.d4uranbek.tacos.domains.Ingredient;
import uz.d4uranbek.tacos.domains.Taco;

/**
 * @author D4uranbek
 * @since 09.06.2022
 */
public class TacoUDRUtils {

    public static IngredientUDT toIngredientUDT(Ingredient ingredient) {
        return IngredientUDT.builder()
                .name( ingredient.getName() )
                .type( ingredient.getType() )
                .build();
    }

    public static TacoUDT toTacoUDT(Taco taco) {
        return TacoUDT.builder()
                .name( taco.getName() )
                .ingredients( taco.getIngredients() )
                .build();
    }
}
