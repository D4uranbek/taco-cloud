package uz.d4uranbek.tacos.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import uz.d4uranbek.tacos.domains.Ingredient;
import uz.d4uranbek.tacos.domains.Ingredient.Type;
import uz.d4uranbek.tacos.domains.Taco;
import uz.d4uranbek.tacos.domains.TacoOrder;
import uz.d4uranbek.tacos.repositories.IngredientRepository;
import uz.d4uranbek.tacos.utils.TacoUDRUtils;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author D4uranbek
 * @since 08.06.2022
 */
@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping( "/design" )
@SessionAttributes( "tacoOrder" )
public class DesignTacoController {

    private final IngredientRepository ingredientRepository;

    @ModelAttribute
    public void addIngredientsToModel(Model model) {
        List<Ingredient> ingredients = new ArrayList<>();
        ingredientRepository.findAll().forEach( ingredients::add );

        for ( Type type : Type.values() ) {
            model.addAttribute( type.toString().toLowerCase(),
                    filterByType( ingredients, type ) );
        }
    }

    @ModelAttribute( name = "tacoOrder" )
    public TacoOrder order() {
        return new TacoOrder();
    }

    @ModelAttribute( name = "taco" )
    public Taco taco() {
        return new Taco();
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processTaco(@Valid Taco taco,
                              Errors errors,
                              @ModelAttribute TacoOrder tacoOrder) {

        if ( errors.hasErrors() ) {
            return "design";
        }

        tacoOrder.addTaco( TacoUDRUtils.toTacoUDT( taco ) );
        log.info( "Processing taco: {}", taco );

        return "redirect:/orders/current";
    }

    private Iterable<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients
                .stream()
                .filter( ingredient -> ingredient.getType().equals( type ) )
                .collect( Collectors.toList() );
    }
}
