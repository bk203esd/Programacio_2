import acm.program.CommandLineProgram;
import java.util.*;

public class Problema4 extends CommandLineProgram {
    public void run() {
        String line = readLine("Enter a sentence: ");
        print(longestWord(line));
    }

    public String longestWord (String line) {
        StringTokenizer tokenizer = new StringTokenizer(line, " ,.;:0123456789");
        String result = "";
        while (tokenizer.hasMoreTokens()) {
            String word = tokenizer.nextToken();
            if (word.length() > result.length()) {
                result = word;
            }
        }
        return result;
    }


}
