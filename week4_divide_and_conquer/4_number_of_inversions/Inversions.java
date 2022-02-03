import java.util.*;

public class Inversions {

    static int[] mergeSort(int [] a) {
        int n = a.length;
        if(n == 1)
            return a;

        int m = n/2;
        int arr1[] = Arrays.copyOfRange(a, 0, m);
        int arr2[] = Arrays.copyOfRange(a, m, n);

        int[] L = mergeSort(arr1);
        int[] R = mergeSort(arr2);

        int[] mergedArr = merge(L,R);

        return mergedArr;
    }

    static int count = 0; // defined globally
    static int[] merge(int[] a, int [] b) {
        int[] mergedArr = new int[a.length+b.length];
        int ind1=0, ind2=0, mer =0;
        while(ind1 < a.length && ind2 < b.length) {
            int aEle = a[ind1];
            int bEle = b[ind2];
            if(aEle <= bEle) {
                mergedArr[mer] = aEle;
                ind1++;
            } else {
                mergedArr[mer] = bEle;
                ind2++;
                count++;
            }
            mer++;
        }
        // check the remaining items to be sorted in the arrays
        if(ind1 == a.length) {
            for(int i =ind2; i < b.length; i++) {
                mergedArr[mer++] = b[i];
            }
        } else {
            for(int i =ind1; i < a.length; i++) {
                mergedArr[mer++] = a[i];
            }
        }
        return mergedArr;
    }
    // merge sort .. divide every array into two halfs until arrays of length one then merge
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = new int[n];
        mergeSort(a);
        System.out.println(count);
    }
}
