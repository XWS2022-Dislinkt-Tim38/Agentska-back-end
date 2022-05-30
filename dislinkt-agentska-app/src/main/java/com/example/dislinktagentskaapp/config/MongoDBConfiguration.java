package com.example.dislinktagentskaapp.config;

import com.example.dislinktagentskaapp.repository.UserRepository;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = UserRepository.class)
@Configuration
public class MongoDBConfiguration {

   /* @Bean
    CommandLineRunner commandLineRunner(UserRepository userRepository){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                User user1 = new User("Imenko", "Prezimic", true, "imenko99", "test", Gender.male, new Date(),
                        "+381642238212", "iodum99@email.com", "Negde daleko, Novi Sad", new UserProfile());
                User user2 = new User("Soraya", "Montenegro", true, "malditalisiada65", "test", Gender.female, new Date(),
                        "+381644244412", "crazyespana@email.com", "Mexico", new UserProfile());
                User user3 = new User("Zorica", "Markovic", false, "nisajanisamjatvojSrobot", "test", Gender.female, new Date(),
                        "+381642555512", "zora@email.com", "Kosjeric", new UserProfile());
                userRepository.save(user1);
                userRepository.save(user2);
                userRepository.save(user3);
            }
        };
    }
    */

}
