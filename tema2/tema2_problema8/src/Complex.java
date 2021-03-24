public class Complex {      //a + bi
    private double a;
    private double b;

    public Complex(float a, float b) {
        this.a = a;
        this.b = b;
    }

    public double getA() {
        return this.a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public double getB() {
        return this.b;
    }

    public void setB(float b) {
        this.b = b;
    }

    public void polar(Complex c) {
        this.a = Math.sqrt(c.a * c.a + c.b * c.b);      //mòdul
        this.b = Math.atan(c.b / c.a);                  //argument
    }

    public void cartesiana(Complex c) {
        this.a = c.a * Math.cos(c.b);
        this.b = c.a * Math.sin(c.b);
    }

    public void add(Complex c) {
        this.a += c.a;
        this.b += c.b;
    }

    public void sub(Complex c) {
        this.a -= c.a;
        this.b -= c.b;
    }

    public static Complex mult(Complex c1, Complex c2) {
        Complex result = new Complex();
        result.a = c1.a * c2.a - c1.b * c2.b;
        result.b = c1.a * c2.b + c1.b * c2.a;
        return result;
    }

    public void div(Complex c) {
        this.a = (this.a * c.a + this.b * c.b) / (c.a * c.a + c.b * c.b);
        this.b = (this.b * c.a - this.a * c.b) / (c.a * c.a + c.b * c.b);
    }

    public String toString() {
        return "( " + a + ", " + b + ")";
    }

}
