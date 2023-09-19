package com.github.board.Web.Controller;

import com.github.board.Repository.PostEntity;
import com.github.board.Service.PostService;
import com.github.board.Web.Dto.PostDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/api/posts")
    public String createPost(@ModelAttribute PostDto postDTO) {
        // PostDTO에서 데이터 추출
        String title = postDTO.getTitle();
        String contents = postDTO.getContents();

        // 게시물 생성 및 저장
        PostEntity newPost = new PostEntity(title, contents); // 예시: Post 생성자에 맞게 변경 필요
        return postService.save(newPost).toString(); // PostService에 게시물 저장 로직 추가

//        return "redirect:/posts"; // 게시물 목록 페이지로 리다이렉트
    }
}
