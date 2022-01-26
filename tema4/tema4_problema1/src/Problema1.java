import acm.program.CommandLineProgram;
// hola
public class Problema1 extends CommandLineProgram {

    public void run() {
        int n = readInt("Introdueix un nombre enter n >= 0 : ");
        println("El factorial de " + n + " es: " + factorial(n));
    }

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
