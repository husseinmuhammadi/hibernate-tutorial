package com.javastudio.tutorial.dao;

import com.javastudio.tutorial.entity.Comment;
import com.javastudio.tutorial.entity.Post;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PostDaoTest {

    @Spy
    private PostDao postDao;

    @Test
    void savePostWithComments() {
        
        Post post = Post.builder()
                .title("I like programming")
                .description("Programming are enjoyable")
                .comments(List.of(
                        Comment.builder().text("I agree").build(),
                        Comment.builder().text("I agree too").build(),
                        Comment.builder().text("I found it great").build()
                )).build();
        post.getComments().forEach(comment -> comment.setPost(post));

        postDao.begin();
        postDao.save(post);
        postDao.commit();
    }

}