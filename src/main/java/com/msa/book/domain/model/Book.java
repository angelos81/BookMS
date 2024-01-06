package com.msa.book.domain.model;

import com.msa.book.domain.model.vo.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long no;

    private String title;

    @Embedded
    private BookDesc desc;

    private Classfication classfication;
    private BookStatus bookStatus;
    private Location location;

    // 도서입고
    public static Book enterBook(String title
                               , String author
                               , String isbn
                               , String description
                               , LocalDate publicationDate
                               , Source source
                               , Classfication classfication
                               , Location location) {

        BookDesc bookDesc = BookDesc.createBookDesc(author, isbn, description, publicationDate, source);

        Book book = new Book();
        book.setTitle(title);
        book.setDesc(bookDesc);
        book.setClassfication(classfication);
        book.setLocation(location);
        book.setBookStatus(BookStatus.ENTERED);
        return book;
    }

    public Book makeAvailable() {
        this.setBookStatus(BookStatus.AVAILABLE);
        return this;
    }

    public Book makeUnAvailable() {
        this.setBookStatus(BookStatus.UNAVAILABLE);
        return this;
    }


    public static Book sample() {
        return enterBook("MSA", "홍길동", "123123", "실습으로 배우는 MSA", LocalDate.now(), Source.DONATION, Classfication.COMPUTER, Location.JEONGJA);
    }

    public static void main(String[] args) {
        System.out.println(Book.sample());
    }

}
