package webservices.rezeptapp.database.models;

import lombok.Data;
import webservices.rezeptapp.enums.Evaluation;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.List;


@Entity
@Data
public class Rezept {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	
	@ManyToOne
	private Author author;
	
	private String description;
	
	@OneToOne
	private MyImage thumbnail;
	
	private Evaluation evaluation;
	
	private String videoLink;
	
	@ManyToMany
	private List<Cathegory> cathegorys;
	
	@ManyToMany
	private List<Ingredients> ingredients;
	
	@OneToMany
	private List<Step> steps;
	
	@OneToMany
	private List<Comment> comments;
	
	
}
