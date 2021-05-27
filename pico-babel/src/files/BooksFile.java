package files;

import domain.Author;
import domain.Book;

import java.io.IOException;
import java.io.RandomAccessFile;

public class BooksFile {

    private final RandomAccessFile books;

    public BooksFile(String fname) throws IOException {
        throw new UnsupportedOperationException("paso 4");
    }

    public void writeBook(Book book) throws IOException {
        throw new UnsupportedOperationException("paso 4");
    }

    public Book readBook(long idBook) throws IOException {
        throw new UnsupportedOperationException("paso 4");
    }

    public Book[] getBooksForAuthor(Author author) throws IOException {
        throw new UnsupportedOperationException("paso 4");
    }

    public long numBooks() throws IOException {
        throw new UnsupportedOperationException("paso 4");
    }

    public long nextBookId() throws IOException {
        throw new UnsupportedOperationException("paso 4");
    }

    public boolean isValidId(long idBook) throws IOException {
        throw new UnsupportedOperationException("paso 4");
    }

    public void reset() throws IOException {
        throw new UnsupportedOperationException("paso 4");
    }

    public void close() throws IOException {
        throw new UnsupportedOperationException("paso 4");
    }
}
