import java.util.*;
import java.io.*;

public class Partition3 {
    private static int partition3(int[] A) {
        //write your code here
        int sum = 0;
        int len = A.length;
        int count = 0;
        for(int i = 0; i < len; i++) {
          sum += A[i];
        }
        if(sum % 3 != 0 || len < 3)
          return 0;
        int w = sum / 3;
        int arr[][] = new int[w+1][len+1];
        for(int i = 1; i < w+1; i++) {
          for(int j = 1; j < len+1; j++) {
            arr[i][j] = arr[i][j-1];
            if(A[j-1] <= i) {
              int temp = arr[i-A[j-1]][j-1] + A[j-1];
              if(temp > arr[i][j])
                arr[i][j] =  temp;
              if(arr[i][j] == w) count++;
            }
          }
        }
        if(count < 3)
          return 0;
        return 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}
