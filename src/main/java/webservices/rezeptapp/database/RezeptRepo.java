package webservices.rezeptapp.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webservices.rezeptapp.database.models.Rezept;

@Repository
public interface RezeptRepo extends CrudRepository<Rezept, Long> {
	
}
