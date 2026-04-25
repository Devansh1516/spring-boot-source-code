package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class bot {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
private String name;
private String persona_description;
public bot(long id, String name, String persona_description) {
	super();
	this.id = id;
	this.name = name;
	this.persona_description = persona_description;
}
public bot() {
	super();
	// TODO Auto-generated constructor stub
}
}
