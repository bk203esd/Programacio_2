public class Complex {      //a + bi
    private double a;
    private double b;

    public Complex(double a, double b) {
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

    public static Complex add(Complex c1, Complex c2) {
        return new Complex(c1.a + c2.a, c1.b + c2.b);
    }

    public static Complex sub(Complex c1, Complex c2) {
        return new Complex(c1.a - c2.a, c1.b - c2.b);
    }

    public static Complex mult(Complex c1, Complex c2) {
        double a = c1.a * c2.a - c1.b * c2.b;
        double b = c1.a * c2.b + c1.b * c2.a;
        return new Complex(a, b);
    }

    public static Complex div(Complex c1, Complex c2) {
        double a = (c1.a * c2.a + c1.b * c2.b) / (c2.a * c2.a + c2.b * c2.b);
        double b = (c1.b * c2.a - c1.a * c2.b) / (c2.a * c2.a + c2.b * c2.b);
        return new Complex(a, b);
    }

    public String toString() {
        return "( " + a + ", " + b + ")";
    }

}
