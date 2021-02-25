import acm.program.CommandLineProgram;

public class Problema3 extends CommandLineProgram {

    public char[] removeExtrems(char[] chars) {
        char[] resultat;
        if(chars.length > 2) {
            resultat = new char[chars.length - 2];
            for(int i = 0 ; i < resultat.length ; i++) {
                resultat[i] = chars[i + 1];
            }
        } else {
            resultat = new char[] {0};
        }
        return resultat;
    }

    public void run() {
        char[] entrada = new char[] {'a', 'b', 'c', 'd', 'e', 'f'};
        char[] sortida = removeExtrems(entrada);
        printArray(sortida) ;
    }

    public void printArray(char[] chars) {
        int i;
        print("{");
        for(i = 0 ; i < chars.length - 1 ; i++) {
            print(chars[i] + ",");
        }
        print(chars[i] + "}");

    }
}
