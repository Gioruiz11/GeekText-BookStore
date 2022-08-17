package edu.fiu.cen4010.g5.BookStoreApp.service;

import edu.fiu.cen4010.g5.BookStoreApp.model.Author;
import edu.fiu.cen4010.g5.BookStoreApp.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void addAuthor(Author author) {
        authorRepository.insert(author);
    }

    public void updateAuthor(Author author) {
        Author savedAuthor = authorRepository.findById(author.getId())
                .orElseThrow(() -> new RuntimeException(
                        String.format("Cannot Find Author by ID %s", author.getId())
                ));

        savedAuthor.setFirstname(author.getFirstname());
        savedAuthor.setLastname(author.getLastname());
        savedAuthor.setBiography(author.getBiography());
        savedAuthor.setPublisher(author.getPublisher());
        authorRepository.save(savedAuthor);
    }

    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    public void deleteAuthor(String id) {
        authorRepository.deleteById(id);
    }

}