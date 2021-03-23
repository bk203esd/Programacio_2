import acm.program.CommandLineProgram;
import java.util.*;

public class Problema5 extends CommandLineProgram {
    public void run() {
        String line = readLine("Entra un missatge: ");
        print(makeAcronym(line));
    }

    public String makeAcronym (String line) {
        StringTokenizer tokenizer = new StringTokenizer(line,"el la un una unos y o de "  );
        String acronym = "";
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();

        }
        return acronym;
    }
}
