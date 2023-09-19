package com.github.board.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostEntity, Long> {
//     CRUD (Create, Read, Update, Delete) 작업을 수행 가능
}
