
import acm.program.CommandLineProgram;

import java.util.Arrays;

public class Polynomials extends CommandLineProgram {

    private static final int DEGREE = 0;
    private static final int COEFFICIENT = 1;

    public void run() {
        testExpandedSize();
        testCompressedSize();
        testCreateExpanded();
        testCreateCompressed();
        testCopyToFromExpandedToCompressed();
        testCopyToFromCompressedToExpanded();
        testCompress();
        testExpand();
        testPow();
        testEvaluateExpanded();
        testEvaluateCompressed();
        testAddExpanded();
        testAddCompressed();
    }

    public int expandedSize(int[][] compressed) {
        int size = 0;
        if (compressed.length > 0) {
            size = compressed[compressed.length - 1][DEGREE] + 1;
        }
        return size;
    }

    public int compressedSize(int[] expanded) {
        int size = 0;
        for (int i = 0; i < expanded.length; i++) {
            if (expanded[i] != 0) {
                size++;
            }
        }
        return size;
    }

    public int[] createExpanded(int expandedSize) {
        return new int[expandedSize];
    }

    public int[][] createCompressed(int compressedSize) {
        return new int[compressedSize][2];
    }

    public void copyTo(int[] fromExpanded, int[][] toCompressed) {
        int j = 0;
        for (int i = 0; i < fromExpanded.length; i++) {
            if (fromExpanded[i] != 0) {
                toCompressed[j][DEGREE] = i;
                toCompressed[j][COEFFICIENT] = fromExpanded[i];
                j++;
            }
        }
    }

    public void copyTo(int[][] fromCompressed, int[] toExpanded) {
        for (int i = 0; i < fromCompressed.length; i++) {
            toExpanded[fromCompressed[i][DEGREE]] = fromCompressed[i][COEFFICIENT];
        }
    }

    public int[][] compress(int[] expanded) {
        int[][] compressed = createCompressed(compressedSize(expanded));
        copyTo(expanded, compressed);
        return compressed;
    }

    public int[] expand(int[][] compressed) {
        int[] expanded = createExpanded(expandedSize(compressed));
        copyTo(compressed, expanded);
        return expanded;
    }

    public int pow(int base, int exp) {
        int powResult = 1;
        for (int i = 0; i < exp; i++) {
            powResult *= base;
        }
        return powResult;
    }

    public int evaluate(int[] expanded, int x) {
        int result = 0;
        if (expanded.length > 0) {
            result = expanded[expanded.length - 1];
            for (int i = 1; i < expanded.length; i++) {
                result = (result * x) + expanded[expanded.length - 1 - i];
            }
        }
        return result;
    }

    public int evaluate(int[][] compressed, int x) {
        int result = 0;
        if (compressed.length > 0) {
            for (int i = 0; i < compressed.length; i++) {
                result += pow(x, compressed[i][DEGREE]) * compressed[i][COEFFICIENT];
            }
        }
        return result;
    }

    public int[] add(int[] expanded1, int[] expanded2) {
        int[] sumExpanded = checkExpandedSize(expanded1, expanded2);
        for (int i = 0; i < sumExpanded.length; i++) {
            if (expanded1.length <= i) {
                sumExpanded[i] = expanded2[i];
            } else if (expanded2.length <= i) {
                sumExpanded[i] = expanded1[i];
            } else {
                sumExpanded[i] = expanded1[i] + expanded2[i];
            }
        }
        sumExpanded = correctExpanded(sumExpanded);
        return sumExpanded;
    }

    // -----
    // FUNCIONS AUXILIARS ADD EXPANDED
    // -----

    public int[] checkExpandedSize (int[] expanded1, int[] expanded2) {
        int [] expanded;
        if (expanded1.length > expanded2.length) {
            expanded = createExpanded(expanded1.length);
        } else {
            expanded = createExpanded(expanded2.length);
        }
        return expanded;
    }

    public void copyExpanded (int[] expanded1, int[] expanded2) {
        for (int i = 0; i < expanded2.length; i++) {
            expanded2[i] = expanded1[i];
        }
    }

    public int[] correctExpanded (int[] expanded) {
        int[] correctExpand;
        if (compressedSize(expanded) == 0) {
            correctExpand = new int[0];
        } else {
            int counter = 0;
            for (int i = 0; i < expanded.length; i++) {
                if (expanded[i] != 0) {
                    counter = i;
                }
            }
            correctExpand = createExpanded(counter + 1);
            copyExpanded(expanded, correctExpand);
        }
        return correctExpand;
    }

    // -----

    public int[][] add(int[][] compressed1, int[][] compressed2) {
        int[][] auxCompressed = createCompressed(compressed1.length + compressed2.length);

        if (compressed1.length > 0 && compressed2.length == 0) {        //segona matriu buida
            copyCompressed(compressed1, auxCompressed);

        } else if (compressed2.length > 0 && compressed1.length == 0){  //primera matriu buida
            copyCompressed(compressed2, auxCompressed);

        } else {

            copyCompressed(compressed1, auxCompressed);
            int[][] copyCompressed2 = new int[compressed2.length][2];
            copyCompressed(compressed2, copyCompressed2);

            for (int i = 0; i < copyCompressed2.length; i++) {
                for (int j = 0; j < compressed1.length; j++) {
                    if (auxCompressed[j][DEGREE] == copyCompressed2[i][DEGREE] && copyCompressed2[i][COEFFICIENT] != 0) {
                        auxCompressed[j][COEFFICIENT] += copyCompressed2[i][COEFFICIENT];
                        removeCompressed(copyCompressed2, i);
                    }
                }
            }

            for (int i = 0; i < copyCompressed2.length; i++) {

                int j = 0;
                boolean copied = false;

                while (!copied && j < auxCompressed.length - 1) {
                    if (copyCompressed2[i][DEGREE] == 0 && auxCompressed[j][DEGREE] == 0) {
                        copied = true;
                    }
                    if (copyCompressed2[i][DEGREE] > auxCompressed[j][DEGREE] && copyCompressed2[i][DEGREE] < auxCompressed[j + 1][DEGREE]) {
                        addCompressed(auxCompressed, j);
                        auxCompressed[j + 1][DEGREE] = copyCompressed2[i][DEGREE];
                        auxCompressed[j + 1][COEFFICIENT] = copyCompressed2[i][COEFFICIENT];
                        copied = true;
                    }
                    if (copyCompressed2[i][DEGREE] > auxCompressed[j][DEGREE] && auxCompressed[j + 1][DEGREE] == 0) {
                        auxCompressed[j + 1][DEGREE] = copyCompressed2[i][DEGREE];
                        auxCompressed[j + 1][COEFFICIENT] = copyCompressed2[i][COEFFICIENT];
                        copied = true;
                    }
                    if (copyCompressed2[i][DEGREE] < auxCompressed[j][DEGREE] && !copied) {
                        addCompressed(auxCompressed, j);
                        auxCompressed[j][DEGREE] = copyCompressed2[i][DEGREE];
                        auxCompressed[j][COEFFICIENT] = copyCompressed2[i][COEFFICIENT];
                        copied = true;
                    }
                    j++;
                }
            }
            auxCompressed = correctCompressed(auxCompressed);
        }
        return auxCompressed;
    }

    // -----
    // FUNCIONS AUXILIARS ADD COMPRESSED
    // -----

    void copyCompressed (int[][] compressed1, int[][] compressed2) {
        for (int i = 0; i < compressed1.length; i++) {
            compressed2[i][DEGREE] = compressed1[i][DEGREE];
            compressed2[i][COEFFICIENT] = compressed1[i][COEFFICIENT];
        }
    }

    void removeCompressed (int [][] compressed, int index) {
        int i = 0;
        for (i = index; i < compressed.length - 1; i++) {
            compressed[i][DEGREE] = compressed[i + 1][DEGREE];
            compressed[i][COEFFICIENT] = compressed[i + 1][COEFFICIENT];
        }
        compressed[i][DEGREE] = 0;
        compressed[i][COEFFICIENT] = 0;
    }

    void addCompressed (int [][] compressed, int index) {
        for (int i = compressed.length - 1 ; i > index; i--) {
            compressed[i][DEGREE] = compressed[i - 1][DEGREE];
            compressed[i][COEFFICIENT] = compressed[i - 1][COEFFICIENT];
        }
    }

    int [][] correctCompressed (int[][] auxCompressed) {
        int counter = 0;
        boolean isCounted = false;
        int i = 0;
        int[][] compressed = createCompressed(auxCompressed.length);
        copyCompressed(auxCompressed, compressed);
        while (!isCounted) {
            if (compressed[i][DEGREE] == 0 && compressed[i][COEFFICIENT] == 0) {
                isCounted = true;

            } else {
                if (compressed[i][DEGREE] != 0 && compressed[i][COEFFICIENT] == 0) {
                    for (int j = i; j < compressed.length - 1; j++) {
                        compressed[j][DEGREE] = compressed[j + 1][DEGREE];
                        compressed[j][COEFFICIENT] = compressed[j + 1][COEFFICIENT];
                    }
                }
                counter++;
            }
            i++;

        }
        int[][] correctCompress = createCompressed(counter);

        for (int j = 0; j < correctCompress.length; j++) {
            correctCompress[j][DEGREE] = compressed[j][DEGREE];
            correctCompress[j][COEFFICIENT] = compressed[j][COEFFICIENT];
        }

        return correctCompress;

    }

    // -----
    // TESTS
    // -----



    public int[] EXPANDED_ZERO = new int[0];
    public int[] EXPANDED_LEFT_ZEROS = new int[]{0, 0, 0, 0, 42};
    public int[] EXPANDED_MIDDLE_ZEROS = new int[]{42, 0, 12, 0, 24};
    public int[] EXPANDED_NON_ZEROS = new int[]{42, 25, 12, 18, 24};
    public int[] EXPANDED_NON_ZEROS_NEG = new int[]{-42, -25, -12, -18, -24};

    public int[] EXPANDED_RESULT_LEFT_MIDDLE = new int[] {42, 0, 12, 0, 66};
    public int[] EXPANDED1 = new int[] {0, -2, 1, 0, 0, 0, 1, 0};
    public int[] EXPANDED2 = new int[] {1, 2, 0, 2, 0 , 0, -1};
    public int[] EXPANDED_RESULT_1_2 = new int[] {1, 0, 1, 2};

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

    public int[][] COMPRESSED1 = new int[][]{{0, 2},
            {2, -2},
            {3, 8},
            {7, -6}};

    public int[][] COMPRESSED2 = new int[][]{{2, 2},
            {4, -1},
            {8, 5}};

    public int[][] COMPRESSED_RESULT = new int[][]{{0, 2},
            {3, 8},
            {4, -1},
            {7, -6},
            {8, 5}};


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
        checkAddExpanded(EXPANDED_LEFT_ZEROS, EXPANDED_MIDDLE_ZEROS, EXPANDED_RESULT_LEFT_MIDDLE);
        checkAddExpanded(EXPANDED1, EXPANDED2, EXPANDED_RESULT_1_2);
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
        checkAddCompressed(COMPRESSED1, COMPRESSED2, COMPRESSED_RESULT);
        checkAddCompressed(COMPRESSED2, COMPRESSED1, COMPRESSED_RESULT);
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
