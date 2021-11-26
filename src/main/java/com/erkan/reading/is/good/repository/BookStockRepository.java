package com.erkan.reading.is.good.repository;

import com.erkan.reading.is.good.entity.Book;
import com.erkan.reading.is.good.entity.BookStock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.QueryHints;

import javax.persistence.LockModeType;
import javax.persistence.QueryHint;

public interface BookStockRepository extends JpaRepository<BookStock, Long> {

    // Can be Optimistic lock in order to increase performance
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    BookStock findByBook(Book book);
}
