package com.github.board.Web.Controller;

import com.github.board.Repository.PostEntity;
import com.github.board.Service.PostService;
import com.github.board.Web.Dto.PostDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/posts") // 게시글을 생성하는 api
    public ResponseEntity<String> postBoard(@RequestBody PostDTO postDTO) {
        String title = postDTO.getTitle();
        String content = postDTO.getContent();

        // Entity 객체 생성
        PostEntity newPost = new PostEntity(title, content);

        // Entity 객체를 서비스를 통해 DB에 저장
        PostEntity savedPost = postService.save(newPost);

        if (savedPost != null) {
            return ResponseEntity.ok("게시물이 성공적으로 저장되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("게시물 저장에 실패했습니다.");
        }
    }

    @PutMapping("/posts/{post_id}")
    public ResponseEntity<String> putBoard(@RequestBody PostDTO postDTO, @PathVariable Long post_id) {
        String title = postDTO.getTitle();
        String content = postDTO.getContent();

        // postService.updatePost 메서드 호출하고 반환값 저장


        if (postService.updatePost(post_id, title, content) != null) {
            return ResponseEntity.ok("게시물이 성공적으로 저장되었습니다.");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("게시물 저장에 실패했습니다.");
        }

    }

//    @PostMapping("/posts") // 게시글을 생성하는 api
//    public String postBoard(@ModelAttribute PostDTO postDTO) {
//        // PostDTO에서 데이터 추출
//        String title = postDTO.getTitle();
//        String contents = postDTO.getContent();
//
//        // 게시물 생성 및 저장
//        PostEntity newPost = new PostEntity(title, contents); // 예시: Post 생성자에 맞게 변경 필요
//        postService.save(newPost).toString(); // PostService에 게시물 저장 로직 추가
//
//
////        return "redirect:/api/posts"; // 게시물 목록 페이지로 리다이렉트
//    }




    @GetMapping("/posts") //전체 게시글을 출력하는 api - Main화면에 전송
    public List<PostEntity> getBoard(@ModelAttribute PostDTO postDTO) {
        // 전체 데이터 Get
        List<PostEntity> posts = postService.findAll();

        return posts;

//        return "redirect:/api/posts"; // 게시물 목록 페이지로 리다이렉트
    }




    @GetMapping("/posts/{post_id}") // 특정 ID를 받아와 게시글을 출력하는 api
    public ResponseEntity<PostEntity> getPostById(@PathVariable Long post_id) {
        Optional<PostEntity> postOptional = postService.getById(post_id);

        if (postOptional.isPresent()) { //객체가 값(게시물)을 가지고 있는지 여부를 확인
            return ResponseEntity.ok(postOptional.get()); //객체가 값(데이터)을 포함하고 있으면, 그 값을 반환
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
