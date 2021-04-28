import acm.program.CommandLineProgram;

import java.io.*;

public class Problema3 extends CommandLineProgram {

    private static String INPUT_FILE = "input.txt";
    private static String OUTPUT_FILE = "output.txt";
    private static int CLAVE = 3;

    public void run() {
        try {
            FileReader input = new FileReader(INPUT_FILE);
            FileWriter output = new FileWriter(OUTPUT_FILE);
            int c;

            while ((c = input.read()) != -1) {
                if (c >= 'A' && c <= 'Z') {
                    c += CLAVE;
                    if (c > 'Z') {
                        c -= ('Z' - 'A');
                    }
                } else if (c >= 'a' && c <= 'z') {
                    c += CLAVE;
                    if (c > 'z') {
                        c -= ('z' - 'a');
                    }
                }
                output.write(c);
            }
            input.close();
            output.close();

        } catch (IOException ex) {
            println("Something bad has happened :c");
        }
    }

}
