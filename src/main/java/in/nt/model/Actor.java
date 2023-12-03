package in.nt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "REST_ACTOR")
public class Actor {

	@GeneratedValue
	@Id
	private Integer actorId;
	private String actorName;
	private String actorCategory;
	private Long mobileNo;

}
