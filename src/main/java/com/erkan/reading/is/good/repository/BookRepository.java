package com.erkan.reading.is.good.repository;

import com.erkan.reading.is.good.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
