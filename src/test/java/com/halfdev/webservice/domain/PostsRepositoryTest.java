package com.halfdev.webservice.domain;

import com.halfdev.webservice.domain.posts.Posts;
import com.halfdev.webservice.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After
    public void cleanup() {
        /* 테스트 코드에 영향을 끼치지 않기 위해 method가 끝날 때마다
        * postsRepositoryf를 비워주는 method
        * */
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        // given
        postsRepository.save(Posts.builder()
                .title("Test Title")
                .content("Test Content")
                .author("Tester")
                .build());
        // when
        List<Posts> postsList = postsRepository.findAll();
        // then
        Posts posts = postsList.get(0);
        assertThat(posts.getTitle(), is("Test Title"));
        assertThat(posts.getContent(), is("Test Content"));
    }
}
