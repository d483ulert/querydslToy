package com.dev.toy.repository;

import com.dev.toy.entity.Board;
import com.dev.toy.repository.querydsl.BoardRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long>, BoardRepositoryCustom {

}
