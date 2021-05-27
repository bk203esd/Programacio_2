package files;

import domain.Author;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AuthorsFile {

    private final RandomAccessFile authors;

    public AuthorsFile(String fname) throws IOException {
        throw new UnsupportedOperationException("paso 3");
    }

    public void writeAuthor(Author author) throws IOException {
        throw new UnsupportedOperationException("paso 3");
    }

    public Author readAuthor(long idAuthor) throws IOException {
        throw new UnsupportedOperationException("paso 3");
    }

    public long numAuthors() throws IOException {
        throw new UnsupportedOperationException("paso 3");
    }

    public long nextAuthorId() throws IOException {
        throw new UnsupportedOperationException("paso 3");
    }

    public boolean isValidId(long idAuthor) throws IOException {
        throw new UnsupportedOperationException("paso 3");
    }

    public void reset() throws IOException {
        throw new UnsupportedOperationException("paso 3");
    }

    public void close() throws IOException {
        throw new UnsupportedOperationException("paso 3");
    }
}
