package course.springframework.WebApp.bootstrap;

import course.springframework.WebApp.domain.Author;
import course.springframework.WebApp.domain.Book;
import course.springframework.WebApp.domain.Publisher;
import course.springframework.WebApp.repositories.AuthorRepository;
import course.springframework.WebApp.repositories.BookRepository;
import course.springframework.WebApp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component  //Bu classi spring bileseni olarak belirlemeye yarayan anotasyon
public class BootstrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {


        Author eric = new Author("Eric","Evans");
        Book ddd = new Book("Domain Driven Design","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod","Johnson");
        Book noEJB = new Book("J2EE Development without EJB","156852");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        authorRepository.save(rod);
        bookRepository.save(noEJB);


        System.out.println("Started in bootstrap");
        System.out.println("Number of books " + bookRepository.count());

        Publisher publisher= new Publisher();
        publisher.setName("Oguzhan");
        publisher.setCity("Trabzon");
        publisher.setZip("61");

        publisherRepository.save(publisher);
        System.out.println("Publisher Count : "  + publisherRepository.count());



    }
}
