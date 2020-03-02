package com.danielpm1982.bookcatalog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookcatalogApplication {
    public static void main(String[] args) {
        SpringApplication.run(BookcatalogApplication.class, args);
    }
}


/*
access H2 GUI console at:
http://localhost:8080/h2-console
select the following instance of the DB:
jdbc:h2:mem:testdb
/*
SQL commands for showing all tables, columns and tuples:
create view view_book_publisher as select book_id, isbn, title, publisher_fk, publisher_id, name, address, city,state, country from book b join publisher p on b.publisher_fk =p.publisher_id;
create view view_book_author as select * from (select book_id, isbn, title, publisher_fk, book_fk, author_fk from book b join book_author ba on b.book_id=ba.book_fk) bba join author a on bba.author_fk=a.author_id;
select * from view_book_author;
select * from view_book_publisher;
select vba.book_id, vba.isbn, vba.title, vba.publisher_fk, publisher_id, name, address, city, state, country, book_fk, author_fk, author_id, first_name, last_name  from view_book_author vba join view_book_publisher vbp on vba.book_id=vbp.book_id;

See the DB-state-result.png file for a picture of the DB state after running this main class (and the BootstrapData one) and after accessing the DB instance and using the sql above.
See also the web-view png pictures about when accessing the application via http://localhost:8080 at the browser.
*/
