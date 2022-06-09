package uz.d4uranbek.tacos.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import uz.d4uranbek.tacos.domains.TacoOrder;

import javax.validation.Valid;

/**
 * @author D4uranbek
 * @since 09.06.2022
 */
@Slf4j
@Controller
@RequestMapping( "/orders" )
@SessionAttributes( "tacoOrder" )
public class OrderController {

    @GetMapping( "/current" )
    public String getOrderForm() {
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid TacoOrder order,
                               Errors errors,
                               SessionStatus sessionStatus) {

        if ( errors.hasErrors() ) {
            return "orderForm";
        }

        log.info( "Order submitted: {}", order );
        sessionStatus.setComplete();

        return "redirect:/";
    }

}
