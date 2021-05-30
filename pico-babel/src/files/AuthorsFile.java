package files;

import domain.Author;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AuthorsFile {

    private final RandomAccessFile authors;

    public AuthorsFile(String fname) throws IOException {
        authors = new RandomAccessFile(fname, "rw");
    }

    public void writeAuthor(Author author) throws IOException {
        byte[] record = author.toBytes();
        long pos = (author.getId() - 1) * Author.SIZE;
        authors.seek(pos);
        authors.write(record);
    }

    public Author readAuthor(long idAuthor) throws IOException {
        byte[] record = new byte[Author.SIZE];
        long pos = (idAuthor - 1) * Author.SIZE;
        authors.seek(pos);
        authors.read(record);
        return Author.fromBytes(record);
    }

    public long numAuthors() throws IOException {
        return authors.length() / Author.SIZE;
    }

    public long nextAuthorId() throws IOException {
        return numAuthors() + 1;
    }

    public boolean isValidId(long idAuthor) throws IOException {
        return (idAuthor >= 1L && idAuthor <= numAuthors());
    }

    public void reset() throws IOException {
        this.authors.setLength(0);
    }

    public void close() throws IOException {
        authors.close();
    }
}
