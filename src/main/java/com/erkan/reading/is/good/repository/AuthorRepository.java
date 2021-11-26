package com.erkan.reading.is.good.repository;

import com.erkan.reading.is.good.entity.Author;
import com.erkan.reading.is.good.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
