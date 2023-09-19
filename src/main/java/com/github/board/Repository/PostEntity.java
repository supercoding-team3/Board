package com.github.board.Repository;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@NoArgsConstructor
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String title;
    private String contents;
    @javax.persistence.Id
    private Long memberId;

    public PostEntity(String title, String contents) {
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }


}