package webservices.rezeptapp.database;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import webservices.rezeptapp.database.models.Comment;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Long> {
	
}
