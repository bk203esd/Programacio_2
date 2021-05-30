package domain;

import utils.PackUtils;

public class Book {

    public static final int TITLE_LIMIT = 20;

    public static final int SIZE = 8 + 2 * TITLE_LIMIT + 8 + 8; // long + String de 20 caracters + long + long

    private final long id;
    private final String title;
    private final long authorId;

    private long nextBookId;

    public Book(long id, String title, long authorId) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.nextBookId = -1L;
    }

    public Book(long id, String title, long authorId, long nextBookId) {
        this.id = id;
        this.title = title;
        this.authorId = authorId;
        this.nextBookId = nextBookId;
    }

    public byte[] toBytes() {
        byte[] record = new byte[SIZE];
        int offset = 0;
        PackUtils.packLong(id, record, offset);
        offset += 8;

        PackUtils.packLimitedString(title, TITLE_LIMIT, record, offset);
        offset += 2 * TITLE_LIMIT;

        PackUtils.packLong(authorId, record, offset);
        offset += 8;

        PackUtils.packLong(nextBookId, record, offset);
        return record;
    }

    public static Book fromBytes(byte[] record) {
        int offset = 0;
        long id = PackUtils.unpackLong(record, offset);
        offset += 8;

        String title = PackUtils.unpackLimitedString(TITLE_LIMIT, record, offset);
        offset += 2 * TITLE_LIMIT;

        long authorId = PackUtils.unpackLong(record, offset);
        offset += 8;

        long nextBookId = PackUtils.unpackLong(record, offset);
        return new Book(id, title, authorId, nextBookId);
    }

    public long getId() {
        return this.id;
    }

    public String getTitle() {
        return this.title;
    }

    public long getAuthorId() {
        return this.authorId;
    }

    public long getNextBookId() {
        return this.nextBookId;
    }

    public void setNextBookId(long idBook) {
        this.nextBookId = idBook;
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
