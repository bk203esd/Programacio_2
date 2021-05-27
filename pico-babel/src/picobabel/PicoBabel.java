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
        throw new UnsupportedOperationException("paso 5");
    }

    private void resetData() throws IOException {
        throw new UnsupportedOperationException("paso 5");
    }

    private void closeFiles() throws IOException {
        throw new UnsupportedOperationException("paso 5");
    }

    private void processMovements() throws IOException {
        throw new UnsupportedOperationException("paso 5");
    }
}
