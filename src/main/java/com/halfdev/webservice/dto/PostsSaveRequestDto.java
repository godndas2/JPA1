package com.halfdev.webservice.dto;

import com.halfdev.webservice.domain.posts.Posts;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class PostsSaveRequestDto {
/**
 * Controller에서 @RequestBody로 외부에서 데이터를 받는 경우엔
 * 기본생성자 + set메소드를 통해서만 값이 할당됩니다.
 * 그래서 이때만 setter를 허용합니다.
 *
 * @Entity 클래스를 절대로 Request, Response로 사용해서는 안되기 때문에
 * Dto를 따로 만들어줌
 */

    private String title;
    private String content;
    private String author;

    public Posts toEntity() {
        return Posts.builder().title(title).content(content).author(author).build();
    }
}
