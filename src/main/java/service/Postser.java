package service;

import org.springframework.stereotype.Service;
import com.grid07.botapi.entity.Post;

import entity.post;
import lombok.RequiredArgsConstructor;
import repo.Postrepo;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class Postser {

    private final Postrepo re;

    public post createPost(post po) {
        po.setCreatedAt(LocalDateTime.now());  
        return re.save(po);                    
    }
}