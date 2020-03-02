package com.danielpm1982.bookcatalog.bootstrap;
import com.danielpm1982.bookcatalog.domain.Author;
import com.danielpm1982.bookcatalog.domain.Book;
import com.danielpm1982.bookcatalog.domain.Publisher;
import com.danielpm1982.bookcatalog.repository.AuthorRepository;
import com.danielpm1982.bookcatalog.repository.BookRepository;
import com.danielpm1982.bookcatalog.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final PublisherRepository publisherRepository;
    public BootstrapData(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository){
        this.bookRepository=bookRepository;
        this.authorRepository=authorRepository;
        this.publisherRepository=publisherRepository;
    }
    @Override
    public void run(String... args) {
        System.out.println("Started in Bootstrap:");
        createBooks();
        createAuthors();
        createPublishers();
        addAuthorsAndPublisherToBook(); //setting all relationships between entities
        showBooks();
        showAuthors();
        showPublishers();
    }
    private void createBooks(){
        Book b1 = new Book("b1T", "27350628365");
        bookRepository.save(b1);
        Book b2 = new Book("b2T", "27465082052");
        bookRepository.save(b2);
        Book b3 = new Book("b3T", "56151981919");
        bookRepository.save(b3);
        Book b4 = new Book("b4T", "87865165185");
        bookRepository.save(b4);
    }
    private void createAuthors(){
        Author a1 = new Author("a1FN", "a1LN");
        authorRepository.save(a1);
        Author a2 = new Author("a2FN", "a2LN");
        authorRepository.save(a2);
    }
    private void createPublishers(){
        Publisher p1 = new Publisher("p1", "p1A", "p1C", "p1S", "p1Ct");
        publisherRepository.save(p1);
        Publisher p2 = new Publisher("p2", "p2A", "p2C", "p2S", "p2Ct");
        publisherRepository.save(p2);
    }
    private void addAuthorsAndPublisherToBook(){
        Author a1 = authorRepository.findByFirstName("a1FN");
        Author a2 = authorRepository.findByFirstName("a2FN");
        Publisher p1 = publisherRepository.findByName("p1");
        Publisher p2 = publisherRepository.findByName("p2");
        Book b1 = bookRepository.findByTitle("b1T");
        b1.getAuthorSet().add(a1);
        b1.setPublisher(p1);
        bookRepository.save(b1);
        Book b2 = bookRepository.findByTitle("b2T");
        b2.getAuthorSet().add(a1);
        b2.getAuthorSet().add(a2);
        b2.setPublisher(p2);
        bookRepository.save(b2);
        Book b3 = bookRepository.findByTitle("b3T");
        b3.getAuthorSet().add(a1);
        b3.getAuthorSet().add(a2);
        b3.setPublisher(p2);
        bookRepository.save(b3);
        Book b4 = bookRepository.findByTitle("b4T");
        b4.getAuthorSet().add(a2);
        b4.setPublisher(p1);
        bookRepository.save(b4);
    }
    private void showBooks(){
        System.out.println("Books:");
        bookRepository.findAll().forEach(x-> System.out.println("Id: "+x.getId()+" Title: "+x.getTitle()+" ISBN: "+x.getIsbn()+" AuthorSet: "+x.getAuthorSet()+" PublisherSet: "+x.getPublisher()));
    }
    private void showAuthors(){
        System.out.println("Authors:");
        authorRepository.findAll().forEach(x-> System.out.println("Id: "+x.getId()+" FirstName: "+x.getFirstName()+" LastName: "+x.getLastName()+" BookSet: "+x.getBookSet()));
    }
    private void showPublishers(){
        System.out.println("Publishers:");
        publisherRepository.findAll().forEach(x-> System.out.println("Id: "+x.getId()+" Name: "+x.getName()+" Address: "+x.getAddress()+" City: "+x.getCity()+" State: "+x.getState()+" Country: "+x.getCountry()+" BookSet: "+x.getBookSet()));
    }
}

/*
bookSet of Author and Publisher instances are NOT obtained from these instances,
but are "mapped by", indirectly, from the Book instances, through the authorSet and
publisher fields, respectively.
Therefore, there's no need in adding any bookSet instance values to either Author or Publisher
instances, only the publisher and authorSet values for each Book instance (as done at
addAuthorsAndPublisherToBook() method above).
*/
