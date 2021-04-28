import acm.program.CommandLineProgram;
import java.io.*;

public class Problema2 extends CommandLineProgram {

    private static String FILE_NAME = "input.txt";

    public void run() {
        try {
            int sum = 0;
            FileReader input = new FileReader(FILE_NAME);
            int c = input.read();

            while (c != -1) {
                if (c != ',') {
                    sum += c - '0';
                }
                c = input.read();
            }
            input.close();
            println(sum);

        } catch (IOException ex) {
            println("Something bad has happened :c");
        }
    }

}

