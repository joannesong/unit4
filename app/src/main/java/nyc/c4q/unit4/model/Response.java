package nyc.c4q.unit4.model;

import java.util.List;

import nyc.c4q.unit4.model.Books;

/**
 * Created by joannesong on 12/20/17.
 */

public class Response {
    private List<Books> books;

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }
}
