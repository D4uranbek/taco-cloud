package uz.d4uranbek.tacos.domains;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author D4uranbek
 * @since 09.06.2022
 */
@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String fullName;
    private String street;
    private String city;
    private String state;
    private String zip;
    private String phone;

    public User toUser(PasswordEncoder passwordEncoder) {
        return new User( username, passwordEncoder.encode( password ),
                fullName, street, city, state, zip, phone );
    }
}
