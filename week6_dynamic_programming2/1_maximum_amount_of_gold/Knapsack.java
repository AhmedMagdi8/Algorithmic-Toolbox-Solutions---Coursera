import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int opt[][] = new int[w.length+1][W+1];
        for(int i = 0; i <= w.length; i++) {
            for (int j = 0; j <= W; j++) {
                    if(i ==0 || j == 0)
                        opt[i][j] = 0;
                    else {
                        opt[i][j] = opt[i-1][j];
                        if(w[i-1] <= j) {
                                int val = opt[i-1][j - w[i-1]] + w[i-1];
                                if (val > opt[i][j])
                                    opt[i][j] = val;
                        }
                    }
                }
            }
            return opt[w.length][W];
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}
