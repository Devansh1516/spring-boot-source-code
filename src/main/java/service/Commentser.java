package service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;


import entity.comm;
import lombok.RequiredArgsConstructor;
import repo.Commrepo;

@Service
@RequiredArgsConstructor
public class Commentser {
	private final Commrepo com;
	public comm addComment(comm comment) {
		comment.setCreatedAt(LocalDateTime.now());
		return com.save(comment);
		
	}

}
