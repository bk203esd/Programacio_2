import acm.program.CommandLineProgram;

public class problema5 extends CommandLineProgram {

    public void run() {
        int[][] left = new int[][]{{1, 2, 3}, {4, 5, 6}};
        int[][] right = new int[][]{{1, 2}, {3, 4}, {5, 6}};
        int[][] result = matrixMultiplication(left, right);
        printMatrix(result);
    }

    public int[][] matrixMultiplication(int[][] left, int[][] right) {
        int[][] result = new int[left.length][right[0].length];
        if (left[0].length == right.length) {
            for (int i = 0; i < left.length; i++) {                 //nombre de files de la 1a
                for (int j = 0; j < right[0].length; j++) {         //nombre de columnes de la 2a
                    for (int k = 0; k < left[0].length; k++) {      //nombre de columnes de la 1a
                        result[i][j] += left[i][k] * right[k][j];
                    }
                }
            }
        }
        return result;
    }

    public void printMatrix(int[][] matrix) {
        print("{");
        for (int i = 0; i < matrix.length; i++) {
            print("{");
            for (int j = 0; j < matrix[i].length; j++) {
                print(matrix[i][j]);
                if (j != matrix[i].length - 1) {
                    print(", ");
                }
            }
            print("}");
            if ( i != matrix.length - 1) {
                print(", ");
            }
        }
        print("}");
    }
}

