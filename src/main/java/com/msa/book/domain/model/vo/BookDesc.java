package com.msa.book.domain.model.vo;

import com.msa.book.domain.model.Book;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class BookDesc {
    private String description;
    private String author;
    private String isbn;
    private LocalDate publicationDate;
    private Source source;

    public static BookDesc createBookDesc(String author,
                                          String isbn,
                                          String description,
                                          LocalDate publicationDate,
                                          Source source) {
        return new BookDesc(description, author, isbn, publicationDate, source);
    }

    public static BookDesc sample() {
        return createBookDesc("홍길동", "123123", "실습으로 배우는 MSA", LocalDate.now(), Source.DONATION);
    }

    public static void main(String[] args) {
        System.out.println(BookDesc.sample());
    }
}
