package com.danielpm1982.bookcatalog.repository;
import com.danielpm1982.bookcatalog.domain.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
    @Query("from Book b where b.title like %:bookTitle%")
    public Book findByTitle(String bookTitle);
}
