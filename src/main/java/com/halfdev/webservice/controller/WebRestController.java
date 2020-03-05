package com.halfdev.webservice.controller;

import com.halfdev.webservice.domain.posts.PostsRepository;
import com.halfdev.webservice.dto.PostsSaveRequestDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class WebRestController {

    /* Autowired가 없다
    * Bean 객체를 받도록 하는 것이 권장방식이다.(Autowired와 동일함)
    * @AllArgsConstructor 가 생성자로 Bean객체를 받도록 해줌
    *   public WebRestController(PostsRepository postsRepository) {
        this.postsRepository = postsRepository;
    }
    * */
    private final PostsRepository postsRepository;

    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld!";
    }

    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto) {
        postsRepository.save(dto.toEntity());
    }
}
