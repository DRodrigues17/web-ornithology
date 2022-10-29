package com.br.puc.startdb.webornithology;

import com.br.puc.startdb.webornithology.model.Passaro;
import com.br.puc.startdb.webornithology.repository.PassaroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Arrays;


@EnableWebMvc
@SpringBootApplication

public class WebOrnithologyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebOrnithologyApplication.class, args);
	}


	@Bean
	CommandLineRunner run(PassaroRepository repository) {
		return args -> {


		};
	}


}
