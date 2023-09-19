package com.github.board.Web.Controller;

import com.github.board.Repository.PostEntity;
import com.github.board.Service.PostService;
import com.github.board.Web.Dto.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/api/posts")
    public String postBoard(@ModelAttribute PostDTO postDTO) {
        // PostDTO에서 데이터 추출
        String title = postDTO.getTitle();
        String contents = postDTO.getContents();

        // 게시물 생성 및 저장
        PostEntity newPost = new PostEntity(title, contents); // 예시: Post 생성자에 맞게 변경 필요
        return postService.save(newPost).toString(); // PostService에 게시물 저장 로직 추가

//        return "redirect:/api/posts"; // 게시물 목록 페이지로 리다이렉트
    }

    @GetMapping("/api/posts")
    public String getBoard(@ModelAttribute PostDTO postDTO) {
        // 전체 데이터 Get
        return postService.findAll().toString();

//        return "redirect:/api/posts"; // 게시물 목록 페이지로 리다이렉트
    }

    @PutMapping("/api/posts/{post_id}")
    public String putBoard(@ModelAttribute PostDTO postDTO, @PathVariable Long post_id) {
        String title = postDTO.getTitle();
        String contents = postDTO.getContents();

        // postService.updatePost 메서드 호출하고 반환값 저장
        return postService.updatePost(post_id, title, contents);
    }

}
