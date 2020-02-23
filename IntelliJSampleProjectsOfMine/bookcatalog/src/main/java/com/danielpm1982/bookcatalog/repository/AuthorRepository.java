package com.danielpm1982.bookcatalog.repository;
import com.danielpm1982.bookcatalog.domain.Author;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
    @Query("from Author a where a.firstName like %:authorFirstName%")
    public Author findByFirstName(String authorFirstName);
}
