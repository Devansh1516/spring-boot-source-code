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
public class comm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long postId;

    private Long authorId;

    private String content;

    private int depthLevel;

    private LocalDate createdAt;

	public comm(Long id, Long postId, Long authorId, String content, int depthLevel, LocalDate createdAt) {
		super();
		this.id = id;
		this.postId = postId;
		this.authorId = authorId;
		this.content = content;
		this.depthLevel = depthLevel;
		this.createdAt = createdAt;
	}

	public comm() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setCreatedAt(LocalDateTime now) {
		// TODO Auto-generated method stub
		
	}
}

