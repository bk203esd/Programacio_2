import acm.program.CommandLineProgram;

public class Problema7 extends CommandLineProgram {

    public String removeSpaces(String str) {
        char[] resultChars = new char[str.length()];
        int resultLength = 0;
        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);
            if(current != ' ') {
                resultChars[resultLength] = current;
                resultLength++;
            }
        }
        return new String(resultChars, 0, resultLength);
    }

    public void run() {
        String sentence = readLine("Enter a senctence: ");
        print("Result: ");
        println(removeSpaces(sentence));
    }
}
