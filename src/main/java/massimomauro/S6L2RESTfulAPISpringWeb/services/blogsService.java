package massimomauro.S6L2RESTfulAPISpringWeb.services;

import massimomauro.S6L2RESTfulAPISpringWeb.entities.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

@Service
public class blogsService {
    private List<Blog> blogs = new ArrayList<>();

    public Blog save(Blog body){
        Random rndm = new Random();
        body.setId(rndm.nextInt(1, 1000));
        this.blogs.add(body);
        return body;
    }

    public List<Blog> getBlogs() {
        return this.blogs;
    }

    public Blog findBlogById(int id){
        Blog u = null;
        for (Blog user: this.blogs) {
            if (user.getId() == id) {
                u = user;
            }
        }
        if(u == null ){
            throw new RuntimeException("non trova l'id");
        } else {
            return u;
        }
    }

    public void findBlogByIdAndDelete(int id){
        ListIterator<Blog> iterator = this.blogs.listIterator();

        while (iterator.hasNext()){
            Blog current = iterator.next();
            if(current.getId() == id){
                iterator.remove();
            }
        }
    }

    public Blog findBlogByIdAndUpdate(int id, Blog body){
        Blog found = null;

        for (Blog user:this.blogs) {
            if(user.getId() == id){
                found = user;
                found.setId(id);
                found.setCategory(body.getCategory());
                found.setTitle(body.getTitle());
                found.setCover(body.getCover());
                found.setContent(body.getContent());
                found.setReadingTime(body.getReadingTime());
            }
        }
        if(found == null ){
            throw new RuntimeException("non trovo l'id");
        } else {
            return found;
        }
    }
}
