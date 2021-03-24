public class Complex {      //a + bi
    private float a;
    private float b;

    public Complex(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public float getA() {
        return this.a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getB() {
        return this.b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public void add(Complex c) {
        this.a += c.a;
        this.b += c.b;
    }

    public void sub(Complex c) {
        this.a -= c.a;
        this.b -= c.b;
    }

    public void mult(Complex c) {

    }

}
