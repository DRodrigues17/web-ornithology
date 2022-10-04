package com.br.puc.startdb.webornithology;

import com.br.puc.startdb.webornithology.model.Passaro;
import com.br.puc.startdb.webornithology.repository.PassaroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.LocalTime;

@SpringBootApplication
public class WebornithologyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebornithologyApplication.class, args);
	}
	


	 @Bean
	  CommandLineRunner run(PassaroRepository repository) {
		 return args -> {
			 repository.save(new Passaro(null, "C:\\Users\\dlar-\\Downloads\\blue.jpg",
					 "Arara-azul-grande",
					 "Anodorhynchus hyacinthinus", "100 cm", "Anodorhynchus",
					 "Azul", "Psittacidae", "tropical", "campus da pucRS",
					 LocalDate.of(2022, 9, 29), LocalTime.of(14, 33)));

			 repository.save(new Passaro(null, "C:\\Users\\dlar-\\Downloads\\tucano.jpg",
					 "Tucano", "Ramphastidae", "61 cm",
					 "Ramphastidae", "Preto", "Ramphastidae",
					 "matas de galeria, cerrado e capões", "Jardim Botânico de Porto Alegre",
					 LocalDate.of(2022, 8, 5), LocalTime.of(15, 0)));

			 repository.save(new Passaro(null, "C:\\Users\\dlar-\\Downloads\\Woodpecker.jpeg",
					 "Pica Pau",
					 "Campephilus melanoleucos malherbii", "36 cm", "Picides",
					 "Preto", "Picidae", "tropical", "Parque Redenção, Porto Alegre",
					 LocalDate.of(2022, 6, 15), LocalTime.of(16, 45)));
		 };
	 }

}
