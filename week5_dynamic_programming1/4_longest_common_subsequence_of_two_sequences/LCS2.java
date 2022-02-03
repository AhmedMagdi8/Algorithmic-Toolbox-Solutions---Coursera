import java.util.*;

public class LCS2 {
    static int max(int a, int b) {
        int max = a;
        if(b > max)
            max = b;
        return max;
    }

    private static int lcs2(int[] a, int[] b) {
        //Write your code here
        int arr[][] = new int[a.length+1][b.length+1];
        for(int i = 0; i <= a.length; i++) {
            arr[i][0] = 0;
        }
        for(int i = 0; i <= b.length; i++) {
            arr[0][i] = 0;
        }

        for(int i = 1; i <= a.length; i++) {
            for(int j = 1; j <= b.length; j++) {
                int max = max(arr[i-1][j],arr[i][j-1]);
                if(a[i-1] == b[j-1])
                    arr[i][j] =  arr[i-1][j-1] + 1;
                else
                    arr[i][j] = max;
            }
        }
        return arr[a.length][b.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}
