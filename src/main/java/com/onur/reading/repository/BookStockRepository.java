package com.onur.reading.repository;

import com.onur.reading.entity.Book;
import com.onur.reading.entity.BookStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

import javax.persistence.LockModeType;

public interface BookStockRepository extends JpaRepository<BookStock, Long> {

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    BookStock findByBook(Book book);
}
