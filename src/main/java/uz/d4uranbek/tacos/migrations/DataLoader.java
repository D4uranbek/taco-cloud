package uz.d4uranbek.tacos.migrations;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.d4uranbek.tacos.domains.Ingredient;
import uz.d4uranbek.tacos.domains.Ingredient.Type;
import uz.d4uranbek.tacos.domains.User;
import uz.d4uranbek.tacos.repositories.IngredientRepository;
import uz.d4uranbek.tacos.repositories.UserRepository;

import java.util.List;

/**
 * @author D4uranbek
 * @since 09.06.2022
 */
@Component
public class DataLoader {

    @Bean
    // @Profile( {"dev", "qa"} )
    @Profile( "!prod" )
    public CommandLineRunner loadDataForDevelopment(UserRepository userRepository,
                                                    PasswordEncoder passwordEncoder) {

        return args -> {
            User user = User.builder()
                    .username( "d4uranbek" )
                    .password( passwordEncoder.encode( "d4uranbek" ) )
                    .fullName( "Dauranbek Abdiganiev" )
                    .city( "Tashkent" )
                    .phoneNumber( "7654321" )
                    .build();

            userRepository.save( user );
        };
    }

    @Bean
    public ApplicationRunner loadData(IngredientRepository ingredientRepository) {
        return args -> {
            List<Ingredient> ingredients = List.of(
                    new Ingredient( "FLTO", "Flour Tortilla", Type.WRAP ),
                    new Ingredient( "COTO", "Corn Tortilla", Type.WRAP ),
                    new Ingredient( "GRBF", "Ground Beef", Type.PROTEIN ),
                    new Ingredient( "CARN", "Carnitas", Type.PROTEIN ),
                    new Ingredient( "TMTO", "Diced Tomatoes", Type.VEGGIES ),
                    new Ingredient( "LETC", "Lettuce", Type.VEGGIES ),
                    new Ingredient( "CHED", "Cheddar", Type.CHEESE ),
                    new Ingredient( "JACK", "Monterrey Jack", Type.CHEESE ),
                    new Ingredient( "SLSA", "Salsa", Type.SAUCE ),
                    new Ingredient( "SRCR", "Sour Cream", Type.SAUCE )
            );

            ingredientRepository.saveAll( ingredients );
        };
    }

}
