public class Rational {
    private int x;
    private int y;

    public Rational(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void add(Rational r) {
        this.x = (this.x * r.y) + (r.x * this.y);
        this.y = this.y * r.y;
    }

    public void sub(Rational r) {
        this.x = (this.x * r.y) - (r.x * this.y);
        this.y = this.y * r.y;
    }

    public void mult(Rational r) {
        this.x *= r.x;
        this.y *= r.y;
    }

    public void div(Rational r) {
        this.x *= r.y;
        this.y *= r.x;
    }

    public static Rational add(Rational r1, Rational r2) {
        return new Rational((r1.x * r2.y) + (r2.x * r1.y), r1.y * r2.y);
    }

    public static Rational sub(Rational r1, Rational r2) {
        return new Rational((r1.x * r2.y) - (r2.x * r1.y), r1.y * r2.y);
    }

    public static Rational mult(Rational r1, Rational r2) {
        return new Rational(r1.x * r2.x, r1.y * r2.y);
    }

    public static Rational div(Rational r1, Rational r2) {
        return new Rational(r1.x * r2.y, r2.x * r1.y);
    }

    public static Rational mcd(Rational r) {
        int aux;
        int x = r.x;
        int y = r.y;
        while (y != 0) {
            aux = y;
            y = x % y;
            x = aux;
        }
        return new Rational(r.x / x, r.y / x);
    }

    public String toString() {
        return "(" + x + "/" + y + ")";
    }
}

