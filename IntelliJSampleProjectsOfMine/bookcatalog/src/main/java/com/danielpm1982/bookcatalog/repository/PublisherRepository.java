package com.danielpm1982.bookcatalog.repository;
import com.danielpm1982.bookcatalog.domain.Publisher;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    @Query("from Publisher p where p.name like %:publisherName%")
    public Publisher findByName(String publisherName);
}
