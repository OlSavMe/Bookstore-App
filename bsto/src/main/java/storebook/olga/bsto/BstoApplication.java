package storebook.olga.bsto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import storebook.olga.bsto.domain.Sbook;
import storebook.olga.bsto.domain.SbookRepository;

@SpringBootApplication
public class BstoApplication {
	private static final Logger log = LoggerFactory.getLogger(BstoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BstoApplication.class, args);
	}
	
	
	
	
	@Bean
	public CommandLineRunner sbookDe(SbookRepository repository) {
		return (args) -> {
		
			repository.save(new Sbook ("One Book", "Some Authour", "1910", "129345", 33));
			repository.save(new Sbook("Another Book", "Another Auhour", "1999", "123987", 55));	
			
			log.info("fetch all books");
			for (Sbook sbook : repository.findAll()) {
				log.info(sbook.toString());
			}

		};

}
	
	
}
