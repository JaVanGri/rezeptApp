package webservices.rezeptapp.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webservices.rezeptapp.database.models.Ingredients;

@Repository
public interface IngredientsRepo extends CrudRepository<Ingredients, Long> {
	
}
