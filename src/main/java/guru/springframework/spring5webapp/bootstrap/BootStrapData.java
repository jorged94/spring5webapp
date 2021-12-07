package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        Author jkrowling = new Author("Johane", "Rowling");
        Book harrypotter = new Book("Harry Potter", "243242");

        jkrowling.getBooks().add(harrypotter);
        harrypotter.getAuthors().add(jkrowling);

        bookRepository.save(harrypotter);
        authorRepository.save(jkrowling);


        Author ggmarques = new Author("Gabriel", "Garcia");
        Book cienanos = new Book("Cien Años", "243242");

        ggmarques.getBooks().add(cienanos);
        cienanos.getAuthors().add(ggmarques);

        bookRepository.save(cienanos);
        authorRepository.save(ggmarques);

        System.out.println("Pruebita uwu");
        System.out.printf("Numero de libros: "+ bookRepository.count());


    }
}
