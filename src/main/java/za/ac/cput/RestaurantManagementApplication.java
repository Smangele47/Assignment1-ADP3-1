package za.ac.cput;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication
public class RestaurantManagementApplication {
    public static void main(String[] args) {

        SpringApplication.run(RestaurantManagementApplication.class, args);

    }
}
