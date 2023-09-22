package com.github.board.Repository;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "board1")
public class PostEntity {

    @Getter
    @javax.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 기본 키를 숫자 타입(Long)으로 변경


    @Getter
    private String title;
    private String content;

//    private String author = "ok";
//    private Integer post_id=0;
//    private Integer memberId; // memberId 필드 추가

    public PostEntity(String title, String content) {
        this.title = title;
        this.content = content;
    }


    public void setContent(String newTitle, String newContent) {
        this.title = newTitle;
        this.content = newContent;
    }
//
//    @OneToMany
//    private List<UserEntity> userEntities;
//

}

//public class PostEntity {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private String title;
//    private String contents;
//    @javax.persistence.Id
//    private Long memberId;
//
//    public PostEntity(String title, String contents) {
//        this.title = title;
//        this.contents = contents;
//    }
//
//    public PostEntity(Long memberId,String title, String contents) {
//        this.memberId = memberId;
//        this.title = title;
//        this.contents = contents;
//    }
//
//    public PostEntity(Long memberId){
//
//    }
//
//
//    public void setMemberId(Long memberId) {
//        this.memberId = memberId;
//    }
//
//
//    public void setContent(String new_title, String new_contents) {
//        this.title = new_title;
//        this.contents = new_contents;
//    }
//}