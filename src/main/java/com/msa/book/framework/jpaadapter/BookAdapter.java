package com.msa.book.framework.jpaadapter;

import com.msa.book.application.outputport.BookOutputPort;
import com.msa.book.domain.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class BookAdapter implements BookOutputPort {
    private final BookRepository bookRepository;

    @Override
    public Book loadBook(long bookNo) {
        Optional<Book> book = bookRepository.findById(bookNo);
        return book.get();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
}
