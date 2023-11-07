package massimomauro.S6L2RESTfulAPISpringWeb.controllers;

import massimomauro.S6L2RESTfulAPISpringWeb.entities.Author;
import massimomauro.S6L2RESTfulAPISpringWeb.entities.Blog;
import massimomauro.S6L2RESTfulAPISpringWeb.services.AuthorsService;
import massimomauro.S6L2RESTfulAPISpringWeb.services.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blogs")
public class BlogsController {
    @Autowired
    private BlogsService blogsService;

    // 1. GET http://localhost:3001/blogs (+ query params opzionali)
    @GetMapping("")
    public List<Blog> getUser(){
        return blogsService.getBlogs();
    }

    // 2. POST http://localhost:3001/blogs (+ body)
    @PostMapping("")
    @ResponseStatus(HttpStatus.CREATED) // <-- 201
    public Blog saveBlog(@RequestBody Blog body){
        return blogsService.save(body);
    }

    // 3. GET http://localhost:3001/blogs/:id
    @GetMapping("/{id}")
    public Blog findById(@PathVariable int id){
        return blogsService.findBlogById(id);
    }

    // 4. PUT http://localhost:3001/blogs/:id (+ body)
    @PutMapping("/{id}")
    public Blog findByIdAndUpdate(@PathVariable int id, @RequestBody Blog body){
        return blogsService.findBlogByIdAndUpdate(id, body);
    }

    // 5. DELETE http://localhost:3001/blogs/:id
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // <-- 204 NO CONTENT
    public void findByIdAndDelete(@PathVariable int id){
        blogsService.findBlogByIdAndDelete(id);
    }
}
