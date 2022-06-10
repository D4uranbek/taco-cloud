package uz.d4uranbek.tacos.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author D4uranbek
 * @since 10.06.2022
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@ConfigurationProperties( prefix = "taco.orders" )
public class OrderProperties {

    private Integer pageSize = 20;

    private String test = "another test";

}
