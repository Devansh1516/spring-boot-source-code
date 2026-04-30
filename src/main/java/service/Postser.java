package service;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import com.grid07.botapi.entity.Post;

import entity.post;
import lombok.RequiredArgsConstructor;
import repo.Postrepo;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class Postser {
	int count;

    private final Postrepo re;

    public post createPost(post po) {
        po.setCreatedAt(LocalDateTime.now());  
        return re.save(po);                    
    }
    private final RedisTemplate<String, Object> redis;
public void updatevit(Long postid, String type) {
	int score=0;
	
	if(type.equals("bot")) {
		count=1;
	}
	else if(type.equals("like")) {
		count=20;
	}
	else if(type.equals("comment")) {
		count=50;
}
	redis.opsForValue().increment("post"+postid+"count"+score);

	Long count=redis.opsForValue().increment("post"+ postid + ":bot_count");
if(count>100) {
	throw new RuntimeException("too many bot replies");
}
}
}