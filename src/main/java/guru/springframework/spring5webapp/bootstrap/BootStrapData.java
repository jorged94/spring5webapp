package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void run(String... args) throws Exception {

        Publisher alfaguara = new Publisher("Alfaguara", "Lima Peru");
        publisherRepository.save(alfaguara);
        
        Author jkrowling = new Author("Johane", "Rowling");
        Book harrypotter = new Book("Harry Potter", "243242");

        jkrowling.getBooks().add(harrypotter);
        harrypotter.getAuthors().add(jkrowling);
//        harrypotter.setPublisher(alfaguara);

        authorRepository.save(jkrowling);
        bookRepository.save(harrypotter);



        Author ggmarques = new Author("Gabriel", "Garcia");
        Book cienanos = new Book("Cien Años", "243242");

        ggmarques.getBooks().add(cienanos);
        cienanos.getAuthors().add(ggmarques);
        cienanos.setPublisher(alfaguara);

        authorRepository.save(ggmarques);
        bookRepository.save(cienanos);

        alfaguara.getBooks().add(harrypotter);
        alfaguara.getBooks().add(cienanos);

        publisherRepository.save(alfaguara);


        System.out.println("Pruebita uwu");
        System.out.println("Numero de libros: "+ bookRepository.count());
        System.out.println("Numero de publishers: "+ publisherRepository.count());

        System.out.println("libros de alfaguara: " + alfaguara.getBooks().size());
//        System.out.println(cienanos.toString());


    }
}
