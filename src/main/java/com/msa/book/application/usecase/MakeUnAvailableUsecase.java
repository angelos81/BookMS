package com.msa.book.application.usecase;

import com.msa.book.framework.web.dto.BookOutPutDTO;
import org.springframework.stereotype.Service;

@Service
public interface MakeUnAvailableUsecase {
    public BookOutPutDTO unAvailable(Long bookNo);
}
