import java.util.*;
import java.io.*;

public class MajorityElement {
    // divide and conquer

    // the majority element of an array is also a majority for half of the array
    static int count (int[] arr, int n) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == n)
                count++;
        }
        return count;
    }
     private static int getMajorityElement(int[] a) {
       int n = a.length;
       if(n == 1)
            return a[0];
        int mid = n/2;
        int leftMaj = getMajorityElement(Arrays.copyOfRange(a, 0, mid));
        int rightMaj = getMajorityElement(Arrays.copyOfRange(a, mid, n));

        if(leftMaj == rightMaj)
            return leftMaj;
        int leftCount = count(a,leftMaj);
        int rightCount = count(a,rightMaj);

        return leftCount > rightCount ? leftMaj : rightMaj;

     }

// with hashmap O(n)
//     private static int getMajorityElement(int[] a) {
//     HashMap<Integer,Integer> h = new HashMap<>();
//     for(int i : a) {
//         if(h.containsKey(i)){
//             int m = h.get(i);
//             h.put(i, m+1);
//         } else {
//             h.put(i, 1);
//         }
//     }
//     int max = 0;
//     for(int i : h.keySet()){
//         if(h.get(i) > max)
//             max = h.get(i);
//     }
//
//     if(max > a.length/2)
//         return 1;
//     return 0;
//     }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int max = getMajorityElement(a);
        // System.out.println(max);
        int count =0;
        for(int i = 0; i < n; i++) {
            if(a[i] == max)
                count++;
        }
        // System.out.println(count);
        if(count > n / 2)
            System.out.println(1);
        else
            System.out.println(0);
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
