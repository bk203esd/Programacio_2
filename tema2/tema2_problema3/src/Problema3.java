import acm.program.CommandLineProgram;


public class Problema3 extends CommandLineProgram {

    public String encodeCaesar(String message, int distance) {
        char[] encodedMessage = new char[message.length()];

        for (int i = 0; i < message.length(); i++) {
            encodedMessage[i] = (char) (message.charAt(i) + distance);
            /*if (encodedMessage[i] >= 'Z' && encodedMessage[i] <= 'a') {
                encodedMessage[i] = (char) (message.charAt(i) - 'Z');
            }
            if (encodedMessage[i] >= 'z') {
                encodedMessage[i] = (char) (message.charAt(i) - 'z');
            }*/
        }

        return new String(encodedMessage, 0, message.length());
    }

    public void run() {
        int distance = readInt("Introdueix un nombre enter: ");
        String message = new String(readLine("Introdueix un missatge: "));
        String encodedMessage = encodeCaesar(message, distance);
        print(encodedMessage);
    }

}
