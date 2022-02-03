import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
        int len = exp.length();
        int n = (len + 1) / 2;
        long[][] m = new long[n][n];
        long[][] M = new long[n][n];

        for(int i = 0; i < n; i++) {
            m[i][i] = Character.getNumericValue(exp.charAt(2*i));
            M[i][i] =  Character.getNumericValue(exp.charAt(2*i));
        }

        for(int s = 0; s < n - 1; s++) {
            for(int i = 0; i < n - s - 1; i++) {
                int j = s + i + 1;
                long min = Long.MAX_VALUE, max = Long.MIN_VALUE;

                for(int k = i; k < j; k++) {
                    long a = eval(m[i][k], m[k+1][j],exp.charAt(2*k+1));
                    long b = eval(m[i][k], M[k+1][j],exp.charAt(2*k+1));
                    long c = eval(M[i][k], m[k+1][j],exp.charAt(2*k+1));
                    long d = eval(M[i][k], M[k+1][j],exp.charAt(2*k+1));
                    min = Math.min(min,Math.min(a,Math.min(b,Math.min(c,d))));
                    max = Math.max(max,Math.max(a,Math.max(b,Math.max(c,d))));
                }
                m[i][j] = min;
                M[i][j] = max;

            }
        }
//        for(long[] i : M) {
//            for(long j : i) {
//                System.out.print(j + " ");
//            }
//            System.out.println();
//        }

        return M[0][n-1];
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}
