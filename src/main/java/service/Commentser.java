package service;

import java.time.Duration;
import java.time.LocalDateTime;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import entity.comm;
import lombok.RequiredArgsConstructor;
import repo.Botrepo;
import repo.Commrepo;

@Service
@RequiredArgsConstructor
public class Commentser {

    private final Commrepo com;
    private final RedisTemplate<String, Object> redi;
    private Botrepo bot;

    public comm addComment(comm comment, Long userId) {

    
        comment.setCreatedAt(LocalDateTime.now());

        Long postId = comment.getPostId();
        Long authorId = comment.getAuthorId();
        int depth = comment.getDepthLevel();

       
        if (depth > 20) {
            throw new RuntimeException("Max depth exceeded");
        }

        
        boolean isBot = bot.existsById(authorId);

        if (isBot) {
            checkBotLimit(postId);
            checkCooldown(authorId, userId);
            updateVirality(postId, "BOT");
        } else {
            updateVirality(postId, "COMMENT");
        }

       
        return com.save(comment);
    }

  
    public void checkBotLimit(Long postId) {

        Long count = redi.opsForValue()
                .increment("post:" + postId + ":bot_count");

        if (count > 100) {
            throw new RuntimeException("Too many bot replies");
        }
    }

  
    public void checkCooldown(Long botId, Long userId) {

        String key = "cooldown:bot_" + botId + ":human_" + userId;

        if (redi.hasKey(key)) {
            throw new RuntimeException("Cooldown active");
        }

        redi.opsForValue()
                .set(key, "1", Duration.ofMinutes(10));
    }


    public void updateVirality(Long postId, String type) {

        int score = 0;

        if (type.equals("BOT")) score = 1;
        else if (type.equals("LIKE")) score = 20;
        else if (type.equals("COMMENT")) score = 50;

        redi.opsForValue()
                .increment("post:" + postId + ":virality_score", score);
    }
}