package uz.d4uranbek.tacos.controllers_test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import uz.d4uranbek.tacos.controllers.HomeController;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * @author D4uranbek
 * @since 08.06.2022
 */
@WebMvcTest( HomeController.class )
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHomePage() throws Exception {
        mockMvc.perform( MockMvcRequestBuilders.get( "/" ) )
                .andExpect( status().isOk() )
                .andExpect( view().name( "home" ) )
                .andExpect( content().string( containsString( "Welcome to..." ) ) );
    }
}
