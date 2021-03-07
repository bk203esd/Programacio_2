
import acm.program.CommandLineProgram;

import java.util.Arrays;

public class Polynomials extends CommandLineProgram {

    private static final int DEGREE = 0;
    private static final int COEFFICIENT = 1;

    public void run() {
        //testExpandedSize();
        //testCompressedSize();
        //testCreateExpanded();
        //testCreateCompressed();
        //testCopyToFromExpandedToCompressed();
        //testCopyToFromCompressedToExpanded();
        //testCompress();
        //testExpand();
        //testPow();
        //testEvaluateExpanded();
        //testEvaluateCompressed();
        //testAddExpanded();
        //testAddCompressed();
    }

    public int expandedSize(int[][] compressed) {
        throw new UnsupportedOperationException("Apartado 1");
    }

    public int compressedSize(int[] expanded) {
        throw new UnsupportedOperationException("Apartado 2");
    }

    public int[] createExpanded(int expandedSize) {
        throw new UnsupportedOperationException("Apartado 3");
    }

    public int[][] createCompressed(int compressedSize) {
        throw new UnsupportedOperationException("Apartado 4");
    }

    public void copyTo(int[] fromExpanded, int[][] toCompressed) {
        throw new UnsupportedOperationException("Apartado 5");
    }

    public void copyTo(int[][] fromCompressed, int[] toExpanded) {
        throw new UnsupportedOperationException("Apartado 6");
    }

    public int[][] compress(int[] expanded) {
        throw new UnsupportedOperationException("Apartado 7");
    }

    public int[] expand(int[][] compressed) {
        throw new UnsupportedOperationException("Apartado 8");
    }

    public int pow(int base, int exp) {
        throw new UnsupportedOperationException("Apartado 9");
    }

    public int evaluate(int[] expanded, int x) {
        throw new UnsupportedOperationException("Apartado 10");
    }

    public int evaluate(int[][] compressed, int x) {
        throw new UnsupportedOperationException("Apartado 11");
    }

    public int[] add(int[] expanded1, int[] expanded2) {
        throw new UnsupportedOperationException("Apartado 12");
    }

    public int[][] add(int[][] compressed1, int[][] compressed2) {
        throw new UnsupportedOperationException("Apartado 13");
    }

    // -----
    // TESTS
    // -----

    public int[] EXPANDED_ZERO = new int[0];
    public int[] EXPANDED_LEFT_ZEROS = new int[]{0, 0, 0, 0, 42};
    public int[] EXPANDED_MIDDLE_ZEROS = new int[]{42, 0, 12, 0, 24};
    public int[] EXPANDED_NON_ZEROS = new int[]{42, 25, 12, 18, 24};
    public int[] EXPANDED_NON_ZEROS_NEG = new int[]{-42, -25, -12, -18, -24};

    public int[][] COMPRESSED_ZERO = new int[0][2];
    public int[][] COMPRESSED_LEFT_ZEROS = new int[][]{{4, 42}};
    public int[][] COMPRESSED_MIDDLE_ZEROS = new int[][]{{0, 42},
            {2, 12},
            {4, 24}};
    public int[][] COMPRESSED_NON_ZEROS = new int[][]{{0, 42},
            {1, 25},
            {2, 12},
            {3, 18},
            {4, 24}};

    public int[][] COMPRESSED_NON_ZEROS_NEG = new int[][]{{0, -42},
            {1, -25},
            {2, -12},
            {3, -18},
            {4, -24}};

    public String stringify(int[] expanded) {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (int i = 0; i < expanded.length; i++) {
            builder.append(expanded[i]);
            if (i != expanded.length - 1) {
                builder.append(", ");
            }
        }
        builder.append("}");
        return builder.toString();
    }

    public String stringify(int[][] compressed) {
        StringBuilder builder = new StringBuilder();
        builder.append("{");
        for (int i = 0; i < compressed.length; i++) {
            builder.append(stringify(compressed[i]));
            if (i != compressed.length - 1) {
                builder.append(", ");
            }
        }
        builder.append("}");
        return builder.toString();
    }

    public boolean matrixEquals(int[][] matrix1, int[][] matrix2) {
        if (matrix1.length != matrix2.length) {
            return false;
        }
        for (int i = 0; i < matrix1.length; i++) {
            if (!Arrays.equals(matrix1[i], matrix2[i])) {
                return false;
            }
        }
        return true;
    }

    public int[][] duplicate(int[][] source) {
        int[][] result = new int[source.length][];
        for (int i = 0; i < source.length; i++) {
            result[i] = Arrays.copyOf(source[i], source[i].length);
        }
        return result;
    }

    public void checkExpandedSize(int[][] compressed, int expected) {
        int[][] savedCompressed = duplicate(compressed);
        int expandedSize = expandedSize(savedCompressed);
        if (expandedSize != expected) {
            printlnError("expandedSize of " + stringify(compressed)
                    + " returns " + expandedSize
                    + " but should be " + expected);
        } else if (!matrixEquals(compressed, savedCompressed)) {
            printlnError("expandedSize of " + stringify(compressed)
                    + " should not modify its parameter");
        } else {
            printlnOk("expandedSize of " + stringify(compressed));
        }
    }


    public void testExpandedSize() {
        printlnInfo("BEGIN testExpandedSize");
        checkExpandedSize(COMPRESSED_ZERO, 0);
        checkExpandedSize(COMPRESSED_LEFT_ZEROS, 5);
        checkExpandedSize(COMPRESSED_MIDDLE_ZEROS, 5);
        checkExpandedSize(COMPRESSED_NON_ZEROS, 5);
        printlnInfo("END testExpandedSize");
        printBar();
    }

    public void checkCompressedSize(int[] expanded, int expected) {
        int[] savedExpanded = Arrays.copyOf(expanded, expanded.length);
        int compressedSize = compressedSize(savedExpanded);
        if (compressedSize != expected) {
            printlnError("compressedSize of " + stringify(expanded)
                    + " returns " + compressedSize
                    + " but should be " + expected);
        } else if (!Arrays.equals(expanded, savedExpanded)) {
            printlnError("compressedSize of " + stringify(expanded)
                    + " should not modify its parameter");
        } else {
            printlnOk("compressedSize of " + stringify(expanded));
        }
    }

    public void testCompressedSize() {
        printlnInfo("BEGIN testCompressedSize");
        checkCompressedSize(EXPANDED_ZERO, 0);
        checkCompressedSize(EXPANDED_LEFT_ZEROS, 1);
        checkCompressedSize(EXPANDED_MIDDLE_ZEROS, 3);
        checkCompressedSize(EXPANDED_NON_ZEROS, 5);
        printlnInfo("END testCompressedSize");
        printBar();
    }

    public void checkCreateExpanded(int expandedSize) {
        int[] createExpanded = createExpanded(expandedSize);
        int[] expected = new int[expandedSize];
        if (!Arrays.equals(createExpanded, expected)) {
            printlnError("createExpanded of " + expandedSize
                    + " returns " + stringify(createExpanded)
                    + " but should be " + stringify(expected));
        } else {
            printlnOk("createExpanded of " + expandedSize);
        }
    }

    public void testCreateExpanded() {
        printlnInfo("BEGIN testCreateExpanded");
        checkCreateExpanded(0);
        checkCreateExpanded(1);
        checkCreateExpanded(5);
        printlnInfo("END testCreateExpanded");
        printBar();
    }

    public void checkCreateCompressed(int compressedSize) {
        int[][] createCompressed = createCompressed(compressedSize);
        int[][] expected = new int[compressedSize][2];
        if (!matrixEquals(createCompressed, expected)) {
            printlnError("createCompressed of " + compressedSize
                    + " returns " + stringify(createCompressed)
                    + " but should be " + stringify(expected));
        } else {
            printlnOk("createCompressed of " + compressedSize);
        }
    }

    public void testCreateCompressed() {
        printlnInfo("BEGIN testCreateCompressed");
        checkCreateCompressed(0);
        checkCreateCompressed(1);
        checkCreateCompressed(5);
        printlnInfo("END testCreateCompressed");
        printBar();
    }

    public void testCopyToFromExpandedToCompressed() {
        printlnInfo("BEGIN testCopyToFromExpandedToCompressed");
        checkCopyToFromExpandedToCompressed(EXPANDED_ZERO, COMPRESSED_ZERO);
        checkCopyToFromExpandedToCompressed(EXPANDED_LEFT_ZEROS, COMPRESSED_LEFT_ZEROS);
        checkCopyToFromExpandedToCompressed(EXPANDED_MIDDLE_ZEROS, COMPRESSED_MIDDLE_ZEROS);
        checkCopyToFromExpandedToCompressed(EXPANDED_NON_ZEROS, COMPRESSED_NON_ZEROS);
        checkCopyToFromExpandedToCompressed(EXPANDED_NON_ZEROS_NEG, COMPRESSED_NON_ZEROS_NEG);
        printlnInfo("END testCopyToFromExpandedToCompressed");
        printBar();
    }

    private void checkCopyToFromExpandedToCompressed(int[] fromExpanded, int[][] expected) {
        int[] savedFromExpanded = Arrays.copyOf(fromExpanded, fromExpanded.length);
        int[][] toCompressed = createCompressed(compressedSize(fromExpanded));
        copyTo(savedFromExpanded, toCompressed);
        if (!matrixEquals(toCompressed, expected)) {
            printlnError("copyTo (fromExpanded) " + stringify(fromExpanded)
                    + " returns " + stringify(toCompressed)
                    + " but should be " + stringify(expected));
        } else if (!Arrays.equals(fromExpanded, savedFromExpanded)) {
            printlnError("copyTo (fromExpanded) " + stringify(fromExpanded)
                    + " should not modify its parameter");
        } else {
            printlnOk("copyTo (fromExpanded) " + stringify(fromExpanded));
        }
    }

    public void testCopyToFromCompressedToExpanded() {
        printlnInfo("BEGIN testCopyToFromCompressedToExpanded");
        checkCopyToFromCompressedToExpanded(COMPRESSED_ZERO, EXPANDED_ZERO);
        checkCopyToFromCompressedToExpanded(COMPRESSED_LEFT_ZEROS, EXPANDED_LEFT_ZEROS);
        checkCopyToFromCompressedToExpanded(COMPRESSED_MIDDLE_ZEROS, EXPANDED_MIDDLE_ZEROS);
        checkCopyToFromCompressedToExpanded(COMPRESSED_NON_ZEROS, EXPANDED_NON_ZEROS);
        checkCopyToFromCompressedToExpanded(COMPRESSED_NON_ZEROS_NEG, EXPANDED_NON_ZEROS_NEG);
        printlnInfo("END testCopyToFromCompressedToExpanded");
        printBar();
    }

    private void checkCopyToFromCompressedToExpanded(int[][] fromCompressed, int[] expected) {
        int[][] savedFromCompressed = duplicate(fromCompressed);
        int[] toExpanded = createExpanded(expandedSize(fromCompressed));
        copyTo(savedFromCompressed, toExpanded);
        if (!Arrays.equals(toExpanded, expected)) {
            printlnError("copyTo (fromCompressed) " + stringify(fromCompressed)
                    + " returns " + stringify(toExpanded)
                    + " but should be " + stringify(expected));
        } else if (!matrixEquals(fromCompressed, savedFromCompressed)) {
            printlnError("copyTo (fromCompressed) " + stringify(fromCompressed)
                    + " should not modify its parameter");
        } else {
            printlnOk("copyTo (fromCompressed) " + stringify(fromCompressed));
        }
    }

    public void checkCompress(int[] expanded, int[][] expected) {
        int[] savedExpanded = Arrays.copyOf(expanded, expanded.length);
        int[][] compressed = compress(savedExpanded);
        if (!matrixEquals(compressed, expected)) {
            printlnError("compress of " + stringify(expanded)
                    + " returns " + stringify(compressed)
                    + " but should be " + stringify(expected));
        } else if (!Arrays.equals(expanded, savedExpanded)) {
            printlnError("compress of " + stringify(expanded)
                    + " should not modify its parameter");
        } else {
            printlnOk("compress of " + stringify(expanded));
        }
    }

    public void testCompress() {
        printlnInfo("BEGIN testCompress");
        checkCompress(EXPANDED_ZERO, COMPRESSED_ZERO);
        checkCompress(EXPANDED_LEFT_ZEROS, COMPRESSED_LEFT_ZEROS);
        checkCompress(EXPANDED_MIDDLE_ZEROS, COMPRESSED_MIDDLE_ZEROS);
        checkCompress(EXPANDED_NON_ZEROS, COMPRESSED_NON_ZEROS);
        printlnInfo("END testCompress");
        printBar();
    }

    public void checkExpand(int[][] compressed, int[] expected) {
        int[][] savedCompressed = duplicate(compressed);
        int[] expanded = expand(savedCompressed);
        if (!Arrays.equals(expanded, expected)) {
            printlnError("expand of " + stringify(compressed)
                    + " returns " + stringify(expanded)
                    + " but should be " + stringify(expected));
        } else if (!matrixEquals(compressed, savedCompressed)) {
            printlnError("expand of " + stringify(compressed)
                    + " should not modify its parameter");
        } else {
            printlnOk("expand of " + stringify(compressed));
        }
    }

    public void testExpand() {
        printlnInfo("BEGIN testExpand");
        checkExpand(COMPRESSED_ZERO, EXPANDED_ZERO);
        checkExpand(COMPRESSED_LEFT_ZEROS, EXPANDED_LEFT_ZEROS);
        checkExpand(COMPRESSED_MIDDLE_ZEROS, EXPANDED_MIDDLE_ZEROS);
        checkExpand(COMPRESSED_NON_ZEROS, EXPANDED_NON_ZEROS);
        printlnInfo("END testExpand");
        printBar();
    }

    public void checkPow(int base, int exponent, int expected) {
        int pow = pow(base, exponent);
        if (pow != expected) {
            printlnError("pow of " + base + "^" + exponent
                    + " returns " + pow
                    + " but should be " + expected);
        } else {
            printlnOk("pow of " + base + "^" + exponent);
        }
    }

    public void testPow() {
        printlnInfo("BEGIN testPow");
        checkPow(0, 0, 1);
        checkPow(2, 0, 1);
        checkPow(4, 1, 4);
        checkPow(4, 4, 256);
        checkPow(6, 4, 1296);
        printlnInfo("END testPow");
        printBar();
    }

    public void checkEvaluateExpanded(int[] expanded, int x, int expected) {
        int[] savedExpanded = Arrays.copyOf(expanded, expanded.length);
        int value = evaluate(savedExpanded, x);
        if (value != expected) {
            printlnError("evaluation of " + stringify(expanded)
                    + " at " + x
                    + " returns " + value
                    + " but should be " + expected);
        } else if (!Arrays.equals(expanded, savedExpanded)) {
            printlnError("evaluation of " + stringify(expanded)
                    + " at " + x
                    + " should not modify its parameter");
        } else {
            printlnOk("evaluation of " + stringify(expanded) + " at " + x);
        }
    }

    public void testEvaluateExpanded() {
        printlnInfo("BEGIN evaluation of expanded");
        checkEvaluateExpanded(EXPANDED_ZERO, 10, 0);
        checkEvaluateExpanded(EXPANDED_MIDDLE_ZEROS, 0, 42);
        checkEvaluateExpanded(EXPANDED_MIDDLE_ZEROS, 1, 78);
        checkEvaluateExpanded(EXPANDED_NON_ZEROS, 2, 668);
        checkEvaluateExpanded(EXPANDED_NON_ZEROS, 3, 2655);
        printlnInfo("END evaluation of expanded");
        printBar();
    }

    public void checkEvaluateCompressed(int[][] compressed, int x, int expected) {
        int[][] savedCompressed = duplicate(compressed);
        int value = evaluate(savedCompressed, x);
        if (value != expected) {
            printlnError("evaluation of " + stringify(compressed)
                    + " at " + x
                    + " returns " + value
                    + " but should be " + expected);
        } else if (!matrixEquals(compressed, savedCompressed)) {
            printlnError("evaluation of " + stringify(compressed)
                    + " at " + x
                    + " should not modify its parameter");
        } else {
            printlnOk("evaluation of " + stringify(compressed) + " at " + x);
        }
    }

    public void testEvaluateCompressed() {
        printlnInfo("BEGIN evaluation of compressed");
        checkEvaluateCompressed(COMPRESSED_ZERO, 10, 0);
        checkEvaluateCompressed(COMPRESSED_MIDDLE_ZEROS, 0, 42);
        checkEvaluateCompressed(COMPRESSED_MIDDLE_ZEROS, 1, 78);
        checkEvaluateCompressed(COMPRESSED_NON_ZEROS, 2, 668);
        checkEvaluateCompressed(COMPRESSED_NON_ZEROS, 3, 2655);
        printlnInfo("END evaluation of compressed");
        printBar();
    }


    public void checkAddExpanded(int[] exp1, int[] exp2, int[] expected) {
        int[] savedExp1 = Arrays.copyOf(exp1, exp1.length);
        int[] savedExp2 = Arrays.copyOf(exp2, exp2.length);
        int[] added = add(savedExp1, savedExp2);
        if (!Arrays.equals(added, expected)) {
            printlnError("adding " + stringify(exp1)
                    + " to " + stringify(exp2)
                    + " returns " + stringify(added)
                    + " but should be " + stringify(expected));
        } else if (!Arrays.equals(exp1, savedExp1) || !Arrays.equals(exp2, savedExp2)) {
            printlnError("adding " + stringify(exp1)
                    + " to " + stringify(exp2)
                    + " should not modify any of its parameters");
        } else {
            printlnOk("adding " + stringify(exp1) + " to " + stringify(exp2));
        }
    }

    public void testAddExpanded() {
        printlnInfo("BEGIN add expanded");
        checkAddExpanded(EXPANDED_ZERO, EXPANDED_NON_ZEROS, EXPANDED_NON_ZEROS);
        checkAddExpanded(EXPANDED_NON_ZEROS, EXPANDED_ZERO, EXPANDED_NON_ZEROS);
        checkAddExpanded(EXPANDED_NON_ZEROS, EXPANDED_NON_ZEROS_NEG, EXPANDED_ZERO);
        printlnInfo("END add expanded");
        printBar();
    }

    public void checkAddCompressed(int[][] comp1, int[][] comp2, int[][] expected) {
        int[][] savedComp1 = duplicate(comp1);
        int[][] savedComp2 = duplicate(comp2);
        int[][] added = add(savedComp1, savedComp2);
        if (!matrixEquals(added, expected)) {
            printlnError("adding " + stringify(comp1)
                    + " to " + stringify(comp2)
                    + " returns " + stringify(added)
                    + " but should be " + stringify(expected));
        } else if (!matrixEquals(comp1, savedComp1) || !matrixEquals(comp2, savedComp2) ) {
            printlnError("adding " + stringify(comp1)
                    + " to " + stringify(comp2)
                    + " should not modify any of its parameters");
        } else {
            printlnOk("adding " + stringify(comp1) + " to " + stringify(comp2));
        }
    }

    public void testAddCompressed() {
        printlnInfo("BEGIN add compressed");
        checkAddCompressed(COMPRESSED_ZERO, COMPRESSED_NON_ZEROS, COMPRESSED_NON_ZEROS);
        checkAddCompressed(COMPRESSED_NON_ZEROS, COMPRESSED_ZERO, COMPRESSED_NON_ZEROS);
        checkAddCompressed(COMPRESSED_NON_ZEROS, COMPRESSED_NON_ZEROS_NEG, COMPRESSED_ZERO);
        printlnInfo("END add compressed");
        printBar();
    }

    // Colorize output for CommandLineProgram

    public String ANSI_RESET = "\u001B[0m";
    public String ANSI_RED = "\u001B[31m";
    public String ANSI_GREEN = "\u001B[32m";
    public String ANSI_BLUE = "\u001B[34m";

    public void printlnInfo(String message) {
        if (acm.program.CommandLineProgram.class.isInstance(this))
            println(ANSI_BLUE + message + ANSI_RESET);
        else
            println(message);
    }

    public void printlnOk(String message) {
        if (acm.program.CommandLineProgram.class.isInstance(this))
            println(ANSI_GREEN + "OK: " + message + ANSI_RESET);
        else
            println("OK: " + message);
    }

    public void printlnError(String message) {
        if (acm.program.CommandLineProgram.class.isInstance(this))
            println(ANSI_RED + "ERROR: " + message + ANSI_RESET);
        else
            println("ERROR: " + message);
    }

    public void printBar() {
        println("--------------------------------------------------");
    }

    // Some combinations of OS & JVM need this
    public static void main(String[] args) {
        new Polynomials().start(args);
    }
}
