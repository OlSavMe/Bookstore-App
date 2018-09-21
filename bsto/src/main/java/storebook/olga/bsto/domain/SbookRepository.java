package storebook.olga.bsto.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


public interface SbookRepository extends CrudRepository<Sbook, Long> {

    List<Sbook> findByIsbn(String isbn);
	
	

}
