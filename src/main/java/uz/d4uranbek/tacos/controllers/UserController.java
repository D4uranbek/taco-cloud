package uz.d4uranbek.tacos.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uz.d4uranbek.tacos.domains.RegistrationForm;
import uz.d4uranbek.tacos.repositories.UserRepository;

/**
 * @author D4uranbek
 * @since 09.06.2022
 */
@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping( "/register" )
public class UserController {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping
    public String registerForm() {
        return "registration";
    }

    @PostMapping
    public String processRegistration(RegistrationForm form) {
        userRepository.save( form.toUser( passwordEncoder ) );
        return "redirect:/login";
    }

}
