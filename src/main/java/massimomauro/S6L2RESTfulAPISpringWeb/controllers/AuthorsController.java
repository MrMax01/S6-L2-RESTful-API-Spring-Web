package massimomauro.S6L2RESTfulAPISpringWeb.controllers;

import massimomauro.S6L2RESTfulAPISpringWeb.entities.Author;
import massimomauro.S6L2RESTfulAPISpringWeb.services.AuthorsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {
    @Autowired
    private AuthorsService authorsService;

    // 1. GET http://localhost:3001/authors (+ query params opzionali)
    @GetMapping("")
    public List<Author> getUser(){
        return authorsService.getAuthors();
    }

    // 2. POST http://localhost:3001/authors (+ body)
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // <-- 201
    public Author saveAuthor(@RequestBody Author body){
        return authorsService.save(body);
    }

    // 3. GET http://localhost:3001/authors/:id
    @GetMapping("/{id}")
    public Author findById(@PathVariable int id){
        return authorsService.findAuthorById(id);
    }

    // 4. PUT http://localhost:3001/authors/:id (+ body)
    @PutMapping("/{id}")
    public Author findByIdAndUpdate(@PathVariable int id, @RequestBody Author body){
        return authorsService.findAuthorByIdAndUpdate(id, body);
    }

    // 5. DELETE http://localhost:3001/authors/:id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findByIdAndDelete(@PathVariable int id){
        authorsService.findAuthorByIdAndDelete(id);
    }
}
