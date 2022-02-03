import java.util.*;

public class LCS3 {
    static int max(int a, int b,int c) {
        int max = a;
        if(b > max)
            max = b;
        if(c > max )
            max = c;
        return max;
    }

    private static int lcs3(int[] a, int[] b, int[] c) {
        int arr[][][] = new int[a.length+1][b.length+1][c.length+1];
        for(int i = 0; i <= a.length; i++) {
            arr[i][0][0] = 0;
        }
        for(int i = 0; i <= b.length; i++) {
            arr[0][i][0] = 0;
        }
        for(int i = 0; i <= c.length; i++) {
            arr[0][0][i] = 0;
        }
        for(int i = 1; i <= a.length; i++) {
            for(int j = 1; j <= b.length; j++) {
                for(int k = 1; k <=c.length;k++) {
                    // 8 possibilities 2 excluded => x , y , z => 2 ^ 3 = 8 => except 1 1 1 & 0 0 0 => i j k
                    int max1 = max(arr[i-1][j][k], arr[i][j-1][k-1],arr[i-1][j][k-1]);
                    int max2 = max(arr[i][j][k-1], arr[i-1][j-1][k],arr[i][j-1][k]);
                    int max = max(max1,max2,0);
                    if(a[i-1] == b[j-1] && a[i-1] == c[k-1])
                        arr[i][j][k] =  arr[i-1][j-1][k-1] + 1;
                    else
                        arr[i][j][k] = max;
                }

            }
        }
        return arr[a.length][b.length][c.length];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}
