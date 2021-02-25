import acm.program.CommandLineProgram;

public class Problema4 extends CommandLineProgram {

    public char[] removeSpaces(char[] chars) {
        char[] resultat = new char[chars.length];
        int j = 0;
        for (int i = 0 ; i < chars.length ; i++) {
            if(chars[i] != ' ') {
                resultat[j] = chars[i];
                j++;
            }
        }
        return resultat;
    }

    public void run() {
        String entrada = readLine();
        char[] sortida = entrada.toCharArray();
        printArray(removeSpaces(sortida));
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
