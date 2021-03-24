import acm.program.CommandLineProgram;


public class Problema7 extends CommandLineProgram {

    public void run() {
        Rational r1 = new Rational(4, 8);
        Rational r2 = new Rational(2, 3);
        Rational result = Rational.div(r1, r2);
        result = Rational.mcd(result);
        print(result.toString());
    }
}
