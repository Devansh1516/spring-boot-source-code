package entity;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

    private Long authorId; 

    private String content;

    private LocalDate CreatedAt;

	public post(long id, Long authorId, String content, LocalDate createdAt) {
		super();
		this.id = id;
		this.authorId = authorId;
		this.content = content;
		this.CreatedAt = createdAt;
	}

	public post() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setCreatedAt(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}
}


