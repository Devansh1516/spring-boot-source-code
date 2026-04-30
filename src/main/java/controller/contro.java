package controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import entity.comm;
import entity.post;
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

  
    @PostMapping("/{postId}/comments/{userId}")
    public comm createComment(@PathVariable Long postId,
                              @PathVariable Long userId,
                              @RequestBody comm comment) {

        // make sure postId is set on comment
        comment.setPostId(postId);

        // service handles time + logic
        return com.addComment(comment, userId);
    }


    @PostMapping("/{postId}/like")
    public String like(@PathVariable Long postId) {

        ps.updatevit(postId, "LIKE");

        return "Post " + postId + " liked";
    }
}