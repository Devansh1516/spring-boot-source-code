package controller;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grid07.botapi.entity.Post;

import entity.comm;
import entity.post;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import repo.Postrepo;
import service.Commentser;
import service.Postser;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class contro {
	private final Postser ps;
	private final Commentser com;
	@PostMapping
	public post createpost(@RequestBody post po) {
		return ps.createPost(po);
		
	}
	@PostMapping("/{postId}/comments")
	public comm cratecomment(@PathVariable Long postId,
			@RequestBody comm comment) {
		comment.setCreatedAt(LocalDateTime.now());
		return com.addComment(comment);
		
	}
	@PostMapping("/{postid}/like")
	 public String Like(@PathVariable Long postid) {
		return "post"+ postid +"linked";
		 
	 }
	@PostMapping("test")
	public String wroking() {
		return "is working";
		
	}

}
