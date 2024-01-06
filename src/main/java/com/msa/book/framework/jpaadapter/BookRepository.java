package com.msa.book.framework.jpaadapter;

import com.msa.book.domain.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    // Book은 Jpa가 제공하는 기본메소드만으로 처리 가능하기 때문에 따로 선언하지 않음
}
