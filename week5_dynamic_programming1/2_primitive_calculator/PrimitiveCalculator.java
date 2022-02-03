import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
        while (n >= 1) {
            sequence.add(n);
            if (n % 3 == 0) {
                n /= 3;
            } else if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
            }
        }
        java.util.Collections.reverse(sequence);
        return sequence;
    }
    static ArrayList<Integer> min(int n) {
        int arr[] = new int[n+1];
        arr[0] = 0;
        arr[1] = 0;
        for(int i = 2; i <=n; i++) {
            int min = arr[i-1] ;
            if(i % 3 == 0) {
                if(arr[i/3] < min)
                    min = arr[i/3];
            } else if ( i % 2 == 0) {
                if(arr[i/2] < min)
                    min = arr[i/2];
            } else {
            }
            arr[i] = min + 1;
        }
        ArrayList<Integer> results = new ArrayList<>();
        int i = n;
        while(i > 1) {
            results.add(i);
            if(arr[i-1] == arr[i] - 1){
                i = i -1;
            } else if(i % 3 == 0 && arr[i/3] == arr[i] - 1) {
                i /= 3;
            } else if(i % 2 ==0 && arr[i / 2] == arr[i] -1) {
                i /= 2;
            }
        }
        results.add(1);
        java.util.Collections.reverse(results);
        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = min(n);
//        System.out.println(min(n));
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}


