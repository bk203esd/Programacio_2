package domain;

import utils.PackUtils;

public class Author {

    public static final int NAME_LIMIT = 20;

    public static final int SIZE = 8 + NAME_LIMIT * 2 + 4 + 8 + 8; // long + String 20 chars + int + long + long

    private final long id;
    private final String name;

    private int  numBooks;
    private long firstBookId;
    private long lastBookId;


    public Author(long id, String name) {
        this.id = id;
        this.name = name;
        this.numBooks = 0;
        this.firstBookId = -1L;
        this.lastBookId = -1L;
    }

    public Author(long id, String name, int numBooks, long firstBookId, long lastBookId) {
        this.id = id;
        this.name = name;
        this.numBooks = numBooks;
        this.firstBookId = firstBookId;
        this.lastBookId = lastBookId;
    }

    public void addBookId(long idBook) {
        if (numBooks == 0) {
            this.firstBookId = idBook;
            this.lastBookId = idBook;
        } else {
            this.lastBookId = idBook;
        }
        this.numBooks++;
    }

    public byte[] toBytes() {
        byte[] record = new byte[SIZE];
        int offset = 0;
        PackUtils.packLong(id, record, offset);
        offset += 8;

        PackUtils.packLimitedString(name, NAME_LIMIT, record, offset);
        offset += 2 * NAME_LIMIT;

        PackUtils.packInt(numBooks, record, offset);
        offset += 4;

        PackUtils.packLong(firstBookId, record, offset);
        offset += 8;

        PackUtils.packLong(lastBookId, record, offset);
        return record;
    }

    public static Author fromBytes(byte[] record) {
        int offset = 0;
        long id = PackUtils.unpackLong(record, offset);
        offset += 8;

        String name = PackUtils.unpackLimitedString(NAME_LIMIT, record, offset);
        offset += 2 * NAME_LIMIT;

        int numBooks = PackUtils.unpackInt(record, offset);
        offset += 4;

        long firstBookId = PackUtils.unpackLong(record, offset);
        offset += 8;

        long lastBookId = PackUtils.unpackLong(record, offset);
        return new Author(id, name, numBooks, firstBookId, lastBookId);
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public long getLastBookId() {
        return this.lastBookId;
    }

    public int getNumBooks() {
        return this.numBooks;
    }

    public long getFirstBookId() {
        return this.firstBookId;
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
