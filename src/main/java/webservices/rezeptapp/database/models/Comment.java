package webservices.rezeptapp.database.models;

import lombok.Data;
import webservices.rezeptapp.enums.Evaluation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@Data
public class Comment {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	private LocalDateTime creatTime;
	
	@ManyToOne
	private Author author;
	
	private String text;
	
	private Evaluation evaluation;
}
