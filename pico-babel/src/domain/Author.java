package domain;

import utils.PackUtils;

public class Author {

    public static final int NAME_LIMIT = 20;

    public static final int SIZE = -1; // TODO

    private final long id;
    private final String name;

    private int  numBooks;
    private long firstBookId;
    private long lastBookId;


    public Author(long id, String name) {
        throw new UnsupportedOperationException("paso 1");
    }

    public Author(long id, String name, int numBooks, long firstBookId, long lastBookId) {
        throw new UnsupportedOperationException("paso 1");
    }

    public void addBookId(long idBook) {
        throw new UnsupportedOperationException("paso 1");
    }

    public byte[] toBytes() {
        throw new UnsupportedOperationException("paso 1");
    }

    public static Author fromBytes(byte[] record) {
        throw new UnsupportedOperationException("paso 1");
    }

    public long getId() {
        throw new UnsupportedOperationException("paso 1");
    }

    public String getName() {
        throw new UnsupportedOperationException("paso 1");
    }

    public long getLastBookId() {
        throw new UnsupportedOperationException("paso 1");
    }

    public int getNumBooks() {
        throw new UnsupportedOperationException("paso 1");
    }

    public long getFirstBookId() {
        throw new UnsupportedOperationException("paso 1");
    }

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", numBooks=" + numBooks +
                ", firstBookId=" + firstBookId +
                ", lastBookId=" + lastBookId +
                '}';
    }
}
