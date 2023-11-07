package massimomauro.S6L2RESTfulAPISpringWeb.services;

import massimomauro.S6L2RESTfulAPISpringWeb.entities.Author;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

@Service
public class AuthorsService {
    private List<Author> authors = new ArrayList<>();

    public Author save(Author body){
        Random rndm = new Random();
        body.setId(rndm.nextInt(1, 1000));
        this.authors.add(body);
        return body;
    }

    public List<Author> getAuthors() {
        return this.authors;
    }

    public Author findAuthorById(int id){
        Author a = null;
        for (Author author: this.authors) {
            if (author.getId() == id) {
                a = author;
            }
        }
        if(a == null ){
            throw new RuntimeException("non trova l'id");
        } else {
            return a;
        }
    }

    public void findAuthorByIdAndDelete(int id){
        ListIterator<Author> iterator = this.authors.listIterator();

        while (iterator.hasNext()){
            Author current = iterator.next();
            if(current.getId() == id){
                iterator.remove();
            }
        }
    }

    public Author findAuthorByIdAndUpdate(int id, Author body){
        Author found = null;

        for (Author author:this.authors) {
            if(author.getId() == id){
                found = author;
                found.setId(id);
                found.setName(body.getName());
                found.setSurname(body.getSurname());
                found.setEmail(body.getEmail());
                found.setBirthDay(body.getBirthDay());

            }
        }
        if(found == null ){
            throw new RuntimeException("non trovo l'id");
        } else {
            return found;
        }
    }
}
