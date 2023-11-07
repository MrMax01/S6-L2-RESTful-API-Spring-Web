package massimomauro.S6L2RESTfulAPISpringWeb.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Blog {
    private long id;
    private String category;
    private String title;
    private String cover;
    private String content;
    private int readingTime;
}
