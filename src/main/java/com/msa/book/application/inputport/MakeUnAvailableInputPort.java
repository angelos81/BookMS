package com.msa.book.application.inputport;

import com.msa.book.application.outputport.BookOutputPort;
import com.msa.book.application.usecase.MakeUnAvailableUsecase;
import com.msa.book.domain.model.Book;
import com.msa.book.framework.web.dto.BookOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MakeUnAvailableInputPort implements MakeUnAvailableUsecase {
    private final BookOutputPort bookOutputPort;

    @Override
    public BookOutPutDTO unAvailable(Long bookNo) {
        Book book = bookOutputPort.loadBook(bookNo);
        book.makeUnAvailable();
        return BookOutPutDTO.mapToDTO(book);
    }
}
