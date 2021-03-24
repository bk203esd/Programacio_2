import acm.program.CommandLineProgram;


public class Problema8 extends CommandLineProgram{

    public void run() {
        Complex c1 = new Complex(2, 3);
        Complex c2 = new Complex(5, 1);
        Complex result = Complex.div(c1, c2);
        c1.polar(c1);
        print(c1.toString());
    }

}
