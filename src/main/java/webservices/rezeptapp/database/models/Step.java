package webservices.rezeptapp.database.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
public class Step {
	
	@Id
	private Integer stepNr;
	
	@ManyToOne
	private Rezept rezept;
	
	private String text;
	
	@OneToMany
	private List<MyImage> images;
	
}
