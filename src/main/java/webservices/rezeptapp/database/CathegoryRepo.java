package webservices.rezeptapp.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webservices.rezeptapp.database.models.Cathegory;

@Repository
public interface CathegoryRepo extends CrudRepository<Cathegory, Long> {
	
}
