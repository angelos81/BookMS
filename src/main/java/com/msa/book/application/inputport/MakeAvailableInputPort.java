package com.msa.book.application.inputport;

import com.msa.book.application.outputport.BookOutputPort;
import com.msa.book.application.usecase.MakeAvailableUsecase;
import com.msa.book.domain.model.Book;
import com.msa.book.domain.model.vo.BookStatus;
import com.msa.book.framework.web.dto.BookOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MakeAvailableInputPort implements MakeAvailableUsecase {

    private final BookOutputPort bookOutputPort;

    @Override
    public BookOutPutDTO available(Long bookNo) {
        Book book = bookOutputPort.loadBook(bookNo);
        book.makeAvailable();
        return BookOutPutDTO.mapToDTO(book);
    }
}
