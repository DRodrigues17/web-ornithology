package com.br.puc.startdb.webornithology;

import com.br.puc.startdb.webornithology.model.Passaro;
import com.br.puc.startdb.webornithology.repository.PassaroRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class WebOrnithologyApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebOrnithologyApplication.class, args);
	}


	 @Bean
	  CommandLineRunner run(PassaroRepository repository) {
		 return args -> {
			 repository.save(new Passaro(null, "https://s1.static.brasilescola.uol.com.br/be/conteudo/images/arara-azul.jpg",
					 "Arara-azul-grande", "Blue Arara", "Anodorhynchus hyacinthinus",
					 "100 cm", "Anodorhynchus", "Azul", "Psittacidae",
					 "tropical"));

			 repository.save(new Passaro(null, "https://s2.static.brasilescola.uol.com.br/be/2021/12/tucano-toco.jpg",
					 "Tucano", "Toucan", "Ramphastidae", "61 cm",
					 "Ramphastidae", "Preto", "Ramphastidae",
					 "matas de galeria, cerrado e capões"));

			 repository.save(new Passaro(null, "https://upload.wikimedia.org/wikipedia/commons/3/36/Woodpecker_20040529_151837_1c.jpeg",
					 "Pica Pau", "Woodpecker", "Campephilus melanoleucos malherbii",
					 "36 cm", "Picides", "Preto", "Picidae", "tropical"));


			 repository.save(new Passaro(null, "https://s3.amazonaws.com/media.wikiaves.com.br/images/0721/1270591g_6ab6166e946550bd953a5e271ef70c1e.jpg",
					 "cabeça-seca", "Wood Stork", "Mycteria americana Linnaeus", "65cm",
					 "indeterminado", "branco", "Família Ciconiidae",
					 "campo alagado, campo úmido, várzeas alagadas, banhado com espelho d’água"));

			 repository.save(new Passaro(null, "https://s3.amazonaws.com/media.wikiaves.com.br/images/7505/5057168g_b0e8a72ac401be29c56c91b085e9114b.jpg",
					 "joão-grande", "Maguari Stork", "Ciconia maguar", "85cm",
					 "indeterminado", "branco", "Família Ciconiidae",
					 "campo alagado, campo úmido, várzeas alagadas, banhado com espelho d’água"));
			 repository.save(new Passaro(null, "https://s3.amazonaws.com/media.wikiaves.com.br/images/6005/5006384g_bf025625d3572b322238722a2894b094.jpg",
					 "cisne-de-pescoço-preto", "Black-necked-swan", "Cygnus melancoryphus", "80cm",
					 "Indeterminado", "branco", "Família Anatidae",
					 "campo alagado, campo úmido, várzeas alagadas, banhado com espelho d’água"));
			 repository.save(new Passaro(null, "https://s3.amazonaws.com/media.wikiaves.com.br/images/3505/5053290g_ce4f005d8d44f55fdffa65308b564397.jpg",
					 "capororoca", "Coscoroba Swan", "Cosocoroba coscoroba", "65cm",
					 "Indeterminado", "branco", "Família Anatidae",
					 "campo alagado, campo úmido, várzeas alagadas, banhado com espelho d’água"));
			 repository.save(new Passaro(null, "https://s3.amazonaws.com/media.wikiaves.com.br/images/4605/5064595_ab0881bb6d108ec1669743ff8b9af9fa.jpg",
					 "Great Egret", "Great Egret", "Ardea Alba", "65cm",
					 "Indeterminado", "branco", "Família Ardeidae",
					 "campo alagado, campo úmido, várzeas alagadas, banhado com espelho d’água"));

		 };
	 }

}
