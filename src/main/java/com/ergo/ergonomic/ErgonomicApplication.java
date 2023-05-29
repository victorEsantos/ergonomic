package com.ergo.ergonomic;

import com.ergo.ergonomic.security.auth.AuthenticationService;
import com.ergo.ergonomic.security.auth.RegisterRequest;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static com.ergo.ergonomic.usuario.domain.Role.ADMIN;
import static com.ergo.ergonomic.usuario.domain.Role.MANAGER;

@SpringBootApplication
public class ErgonomicApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErgonomicApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service
    ) {
        return args -> {
            var admin = RegisterRequest.builder()
                    .name("Admin")
                    .email("admin@mail.com")
                    .password("password")
                    .role(ADMIN)
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());

            var manager = RegisterRequest.builder()
                    .name("Manager")
                    .email("manager@mail.com")
                    .password("password")
                    .role(MANAGER)
                    .build();
            System.out.println("Manager token: " + service.register(manager).getAccessToken());

        };

    }
}
