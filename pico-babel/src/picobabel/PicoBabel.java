package picobabel;

import acm.program.CommandLineProgram;
import domain.Author;
import domain.Book;
import files.AuthorsFile;
import files.BooksFile;
import files.Logger;

import java.io.*;
import java.util.StringTokenizer;

public class PicoBabel extends CommandLineProgram {

    private static final String MOVEMENTS = "movements.csv";
    private static final String LOG       = "logger.log";
    private static final String AUTHORS   = "authorsDB.dat";
    private static final String BOOKS     = "booksDB.dat";

    private BufferedReader movements;
    private Logger         logger;
    private AuthorsFile    authorsDB;
    private BooksFile      booksDB;

    public static void main(String[] args) {
        new PicoBabel().start(args);
    }

    @Override
    public void run() {
        try {
            openFiles();
            resetData();
            processMovements();
        } catch (IOException e) {
            println("Glups !!!");
            e.printStackTrace();
        } finally {
            try {
                closeFiles();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void openFiles() throws IOException {
        this.movements = new BufferedReader(new FileReader(MOVEMENTS));
        this.logger = new Logger(LOG);
        this.authorsDB = new AuthorsFile(AUTHORS);
        this.booksDB = new BooksFile(BOOKS);
    }

    private void resetData() throws IOException {
        authorsDB.reset();
        booksDB.reset();
    }

    private void closeFiles() throws IOException {
        movements.close();
        logger.close();
        authorsDB.close();
        booksDB.close();
    }

    private void processMovements() throws IOException {
        String instruction = this.movements.readLine();
        while (instruction != null) {
            StringTokenizer movements = new StringTokenizer(instruction, ",");
            String movement = movements.nextToken();
            if (movement.equals("ALTA_AUTOR")) {
                registerAuthor(movements.nextToken());
            } else if (movement.equals("ALTA_LIBRO")) {
                registerBook(movements.nextToken(), Long.parseLong(movements.nextToken()));
            } else if (movement.equals("INFO_AUTOR")) {
                searchAuthor(Long.parseLong(movements.nextToken()));
            } else if (movement.equals("INFO_LIBRO")) {
                searchBook(Long.parseLong(movements.nextToken()));
            } else {
                logger.errorUnknownOperation(movement);
            }
            instruction = this.movements.readLine();
        }
    }

    //funcions auxiliars

    private void registerAuthor(String authorName) throws IOException {
        long authorId = authorsDB.nextAuthorId();
        Author newAuthor = new Author(authorId, authorName);
        authorsDB.writeAuthor(newAuthor);
        logger.okNewAuthor(newAuthor);
    }

    private void registerBook(String bookName, Long authorId) throws IOException {
        if (!authorsDB.isValidId(authorId)) {
            logger.errorInfoAutor(authorId);
        } else {
            long bookId = booksDB.nextBookId();
            Book newBook = new Book(bookId, bookName, authorId);
            booksDB.writeBook(newBook);
            Author author = authorsDB.readAuthor(authorId);
            author.addBookId(bookId);
            authorsDB.writeAuthor(author);
            if (author.getNumBooks() > 1) {
                Book[] books = booksDB.getBooksForAuthor(author);
                books[books.length - 2].setNextBookId(bookId);
                booksDB.writeBook(books[books.length - 2]);
            }
            logger.okNewBook(newBook);
        }
    }

    private void searchAuthor(Long authorId) throws IOException{
        if (!authorsDB.isValidId(authorId)) {
            logger.errorInfoBook(authorId);
        } else {
            Author author = authorsDB.readAuthor(authorId);
            Book[] books = booksDB.getBooksForAuthor(author);
            logger.okInfoAutor(author, books);
        }
    }

    private void searchBook(Long bookId) throws IOException {
        if (!booksDB.isValidId(bookId)) {
            logger.errorInfoBook(bookId);
        } else {
            Book book = booksDB.readBook(bookId);
            Author author = authorsDB.readAuthor(book.getAuthorId());
            logger.okInfoBook(book, author);
        }

    }
}
