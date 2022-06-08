package uz.d4uranbek.tacos.domains;

import lombok.*;

/**
 * @author D4uranbek
 * @since 08.06.2022
 */
public record Ingredient(
        String id,
        String name,
        Type type) {

    @Getter
    public enum Type {
        WRAP,
        PROTEIN,
        VEGGIES,
        CHEESE,
        SAUCE
    }
}
