package files;

import domain.Author;
import domain.Book;

import java.io.IOException;
import java.io.RandomAccessFile;

public class BooksFile {

    private final RandomAccessFile books;

    public BooksFile(String fname) throws IOException {
        books = new RandomAccessFile(fname, "rw");
    }

    public void writeBook(Book book) throws IOException {
        byte[] record = book.toBytes();
        long pos = (book.getId() - 1) * Author.SIZE;
        books.seek(pos);
        books.write(record);
    }

    public Book readBook(long idBook) throws IOException {
        byte[] record = new byte[Author.SIZE];
        long pos = (idBook - 1) * Author.SIZE;
        books.seek(pos);
        books.read(record);
        return Book.fromBytes(record);
    }

    public Book[] getBooksForAuthor(Author author) throws IOException {
        int j = 0;
        byte[] record = new byte[Book.SIZE];
        Book[] arrayBooks = new Book[author.getNumBooks()];
        for (int i = 0; i < numBooks(); i++) {
            books.seek(i * Book.SIZE);
            books.read(record);
            Book newBook = Book.fromBytes(record);
            if (author.getId() == newBook.getAuthorId()) {
                arrayBooks[j] = newBook;
                j++;
            }
        }
        return arrayBooks;
    }

    public long numBooks() throws IOException {
        return books.length() / Book.SIZE;
    }

    public long nextBookId() throws IOException {
        return numBooks() + 1;
    }

    public boolean isValidId(long idBook) throws IOException {
        return (idBook >= 1L && idBook <= numBooks());
    }

    public void reset() throws IOException {
        this.books.setLength(0);
    }

    public void close() throws IOException {
        books.close();
    }
}
