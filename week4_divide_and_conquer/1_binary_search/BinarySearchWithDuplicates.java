import java.io.*;
import java.util.*;

public class BinarySearchWithDuplicates {

    static int BinarySearchWithDuplicates(int[] a, int x,int l, int r) {
        //write your code here
        if(r < l)
            return -1;
        int mid = l + (r - l) / 2;
        if(a[mid] == x){
            while(mid > 0 && a[mid] == a[mid-1]){
                mid = mid -1;
            }
            return mid;
        }
        if(a[mid] < x ) {
          return BinarySearchWithDuplicates(a,x,mid+1,r);
        }
        if (a[mid] > x) {
            return BinarySearchWithDuplicates(a, x, l, mid-1);
        }
        return -1;

    }

    static int linearSearch(int[] a, int x) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == x) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
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
        for (int i = 0; i < m; i++) {
            //replace with the call to binarySearch when implemented
            System.out.print(BinarySearchWithDuplicates(a, b[i],0,a.length-1) + " ");
        }
    }
    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
