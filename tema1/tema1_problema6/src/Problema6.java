import acm.program.CommandLineProgram;

public class Problema6 extends CommandLineProgram {

    public String removeExtrems (String str) {
        char[] resultChars = new char[str.length()];

        if(str.length() > 2) {
            int resultLength = 0;
            for (int i = 0; i < str.length() - 2; i++){
                resultChars[resultLength] = str.charAt(i + 1);
                resultLength++;
            }
            return new String(resultChars, 0, resultLength);
        } else {
            return new String();
        }
    }

    public void run() {
        String sentence = readLine("Enter a sentence: ");
        print("Result: ");
        println(removeExtrems(sentence));
    }
}
