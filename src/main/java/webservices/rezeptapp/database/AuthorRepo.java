package webservices.rezeptapp.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webservices.rezeptapp.database.models.Author;

@Repository
public interface AuthorRepo extends CrudRepository<Author, Long> {
	
}
