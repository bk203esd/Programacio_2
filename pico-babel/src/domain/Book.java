package domain;

import utils.PackUtils;

public class Book {

    public static final int TITLE_LIMIT = 20;

    public static final int SIZE = -1; // TODO

    private final long id;
    private final String title;
    private final long authorId;

    private long nextBookId;

    public Book(long id, String title, long authorId) {
        throw new UnsupportedOperationException("paso 2");
    }

    public Book(long id, String title, long authorId, long nextBookId) {
        throw new UnsupportedOperationException("paso 2");
    }

    public byte[] toBytes() {
        throw new UnsupportedOperationException("paso 2");
    }

    public static Book fromBytes(byte[] record) {
        throw new UnsupportedOperationException("paso 2");
    }

    public long getId() {
        throw new UnsupportedOperationException("paso 2");
    }

    public String getTitle() {
        throw new UnsupportedOperationException("paso 2");
    }

    public long getAuthorId() {
        throw new UnsupportedOperationException("paso 2");
    }

    public long getNextBookId() {
        throw new UnsupportedOperationException("paso 2");
    }

    public void setNextBookId(long idBook) {
        throw new UnsupportedOperationException("paso 2");
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", authorId=" + authorId +
                ", nextBookId=" + nextBookId +
                '}';
    }
}
