package com.msa.book.application.inputport;

import com.msa.book.application.outputport.BookOutputPort;
import com.msa.book.application.usecase.InquiryUsecase;
import com.msa.book.domain.model.Book;
import com.msa.book.framework.web.dto.BookOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class InquiryInputPort implements InquiryUsecase {
    public final BookOutputPort bookOutputPort;

    @Override
    public BookOutPutDTO getBookInfo(Long bookNo) {
        Book book = bookOutputPort.loadBook(bookNo);
        return BookOutPutDTO.mapToDTO(book);
    }
}
