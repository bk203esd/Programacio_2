import acm.program.CommandLineProgram;

public class Problema1 extends CommandLineProgram {

    public boolean isPerfect(int n) {
        int cont = 0;
        for (int a = 1; a < n; a++) {
            if(n % a == 0) {
                cont += a;
            }
        }
        if (n == cont) {
            return true;
        } else {
            return false;
        }
    }

    public void run() {
        int num = readInt("Escriu un nombre n > 1\n");
        if(num > 1) {
            if(isPerfect(num)){
                println(num + " es perfecte");
            } else {
                println(num + " no es perfecte");
            }
        } else {
            println("Error");
        }
    }
}