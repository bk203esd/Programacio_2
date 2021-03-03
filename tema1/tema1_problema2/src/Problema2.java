import acm.program.CommandLineProgram;

public class Problema2 extends CommandLineProgram {
    public int max(int[] numbers) {
        int i = 0;
        int max = numbers[0];
        for (i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            }
        }
        return max;
    }

    public void run() {
        int[] nums = new int[] {4, 12, -5, 3};
        int max = max(nums);
        println("El resultat es " + max);
    }
}
