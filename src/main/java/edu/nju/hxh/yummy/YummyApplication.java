package edu.nju.hxh.yummy;

import edu.nju.hxh.yummy.entity.Address;
import edu.nju.hxh.yummy.entity.Restaurant;
import edu.nju.hxh.yummy.entity.User;
import edu.nju.hxh.yummy.repository.RestaurantRepository;
import edu.nju.hxh.yummy.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class YummyApplication {

    public static void main(String[] args) {
        SpringApplication.run(YummyApplication.class, args);
    }
    @Bean
    public CommandLineRunner test1(UserRepository userRepository){
        System.out.println(userRepository==null);
        if(userRepository!=null){
            User user = new User();
            Address address = new Address();
            user.addAddress(address);
            userRepository.save(user);

        }

        return args -> {

        };
    }
    @Bean
    public Integer test2(RestaurantRepository restaurantRepository){

            Restaurant restaurant = new Restaurant();
            restaurant.setName("x");
            restaurantRepository.save(restaurant);
      return 1;
    }
}

