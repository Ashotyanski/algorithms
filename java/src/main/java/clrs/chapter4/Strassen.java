package clrs.chapter4;

import java.util.Arrays;

public class Strassen {
    public static void main(String[] args) {
        int[][] A = new int[][]{
                {1, 1, 1, 1},
                {2, 2, 2, 2},
                {3, 3, 3, 3},
                {4, 4, 4, 4}
        };
        int[][] B = new int[][]{
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2},
                {2, 2, 2, 2}
        };

        int[][] I = new int[][]{
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
        };

        System.out.println(Arrays.deepToString(squareMatrixMultiplyStrassen(A, A)));
    }

    private static int[][] squareMatrixMultiplyStrassen(int[][] A, int[][] B) {
        return squareMatrixMultiplyStrassen(A, 0, 0, B, 0, 0, A.length);
    }

    private static int[][] squareMatrixMultiplyStrassen(int[][] A, int ay, int ax, int[][] B, int by, int bx, int n) {
        if (n == 1) {
            return new int[][]{{A[ay][ax] * B[by][bx]}};
        }
        int[][] C = new int[n][n];
        int delta = n / 2;
        int[][] S1 = diff(B, by, bx + delta, B, by + delta, bx + delta, n / 2);
        int[][] S2 = sum(A, ay, ax, A, ay, ax + delta, n / 2);
        int[][] S3 = sum(A, ax + delta, ax, A, ay + delta, ax + delta, n / 2);
        int[][] S4 = diff(B, by + delta, bx, B, by, bx, n / 2);
        int[][] S5 = sum(A, ay, ax, A, ay + delta, ax + delta, n / 2);
        int[][] S6 = sum(B, by, bx, B, by + delta, bx + delta, n / 2);
        int[][] S7 = diff(A, ay, ax + delta, A, ay + delta, ax + delta, n / 2);
        int[][] S8 = sum(B, by + delta, bx, B, by + delta, bx + delta, n / 2);
        int[][] S9 = diff(A, ay, ax, A, ay + delta, ax, n / 2);
        int[][] S0 = sum(B, by, bx, B, by, bx + delta, n / 2);

        int[][] P1 = squareMatrixMultiplyStrassen(A, ay, ax, S1, 0, 0, n / 2);
        int[][] P2 = squareMatrixMultiplyStrassen(S2, 0, 0, B, by + delta, bx + delta, n / 2);
        int[][] P3 = squareMatrixMultiplyStrassen(S3, 0, 0, B, by, bx, n / 2);
        int[][] P4 = squareMatrixMultiplyStrassen(A, ay + delta, ax + delta, S4, 0, 0, n / 2);
        int[][] P5 = squareMatrixMultiplyStrassen(S5, 0, 0, S6, 0, 0, n / 2);
        int[][] P6 = squareMatrixMultiplyStrassen(S7, 0, 0, S8, 0, 0, n / 2);
        int[][] P7 = squareMatrixMultiplyStrassen(S9, 0, 0, S0, 0, 0, n / 2);

        int[][] C11 = diff(sum(P5, P4), diff(P2, P6));
        int[][] C12 = sum(P1, P2);
        int[][] C21 = sum(P3, P4);
        int[][] C22 = diff(sum(P5, P1), sum(P3, P7));

        return concatSubmatrices(C11, C12, C21, C22);
    }

    private static int[][] squareMatrixMultiplyRecursive(int[][] A, int[][] B) {
        return squareMatrixMultiplyRecursive(A, 0, 0, B, 0, 0, A.length);
    }

    private static int[][] squareMatrixMultiplyRecursive(int[][] A, int ax, int ay, int[][] B, int bx, int by, int n) {
        if (n == 1) {
            return new int[][]{{A[ay][ax] * B[by][bx]}};
        }
        int[][] C = new int[n][n];
        int delta = n / 2;
        int[][] C11 = sum(
                squareMatrixMultiplyRecursive(
                        A, ax, ay,
                        B, bx, by, n / 2),
                squareMatrixMultiplyRecursive(
                        A, ax + delta, ay,
                        B, bx, by + delta, n / 2));

        int[][] C12 = sum(
                squareMatrixMultiplyRecursive(
                        A, ax, ay,
                        B, bx + delta, by, n / 2),
                squareMatrixMultiplyRecursive(
                        A, ax + delta, ay,
                        B, bx + delta, by + delta, n / 2));

        int[][] C21 = sum(
                squareMatrixMultiplyRecursive(
                        A, ax, ay + delta,
                        B, bx, by, n / 2),
                squareMatrixMultiplyRecursive(
                        A, ax + delta, ay + delta,
                        B, bx, by + delta, n / 2));

        int[][] C22 = sum(
                squareMatrixMultiplyRecursive(
                        A, ax, ay + delta,
                        B, bx + delta, by, n / 2),
                squareMatrixMultiplyRecursive(
                        A, ax + delta, ay + delta,
                        B, bx + delta, by + delta, n / 2));

        return concatSubmatrices(C11, C12, C21, C22);
    }

    private static int[][] concatSubmatrices(int[][] C11, int[][] C12, int[][] C21, int[][] C22) {
        int n = C11.length;
        int[][] C = new int[n * 2][n * 2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                C[i][j] = C11[i][j];
                C[i][n + j] = C12[i][j];
                C[n + i][j] = C21[i][j];
                C[n + i][n + j] = C22[i][j];
            }
        }
        return C;
    }

    private static int[][] sum(int[][] A, int[][] B) {
        return sum(A, 0, 0, B, 0, 0, A.length);
    }

    private static int[][] sum(int[][] A, int ay, int ax, int[][] B, int by, int bx, int n) {
        int[][] S = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                S[i][j] = A[ay + i][ax + j] + B[by + i][bx + j];
            }
        }
        return S;
    }

    private static int[][] diff(int[][] A, int[][] B) {
        return diff(A, 0, 0, B, 0, 0, A.length);
    }

    private static int[][] diff(int[][] A, int ay, int ax, int[][] B, int by, int bx, int n) {
        int[][] S = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                S[i][j] = A[ay + i][ax + j] - B[by + i][bx + j];
            }
        }
        return S;
    }

    private static int[][] squareMatrixMultiplyFlat(int[][] A, int[][] B) {
        int[][] C = new int[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B[0].length; j++) {
                for (int k = 0; k < A[0].length; k++) {
                    C[j][i] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}
