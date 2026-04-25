package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.*;
@Data
@Entity
@Table(name="users")
public class user {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String username;
	private String ispremium;
	public user(long id, String username, String ispremium) {
		super();
		this.id = id;
		this.username = username;
		this.ispremium = ispremium;
	}
	public user() {
		super();
		// TODO Auto-generated constructor stub
	}
}
