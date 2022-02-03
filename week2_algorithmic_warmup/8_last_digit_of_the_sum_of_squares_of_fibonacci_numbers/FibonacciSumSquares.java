import java.util.*;

public class FibonacciSumSquares {
    private static long getFibonacciSumSquaresFast(long n) {

        
        int p = pisano_period_len();
        n = n % p;
        if (n <= 1)
            return n;
        long previous = 0;
        long current  = 1;
        long sum      = 1;

        for (long i = 0; i < n - 1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)%10;
            sum += (current * current)%10;
        }

        return sum % 10;
    }
    
    
        static int pisano_period_len() {
        int len=0;
        int prev = 0;
        int cur = 1;
        for(int i = 0; i < 100; i++) {
            int tmp = prev;
            prev = cur;
            cur = (cur + tmp) % 10;
            if(prev ==0 && cur == 1) {
                len = i + 1;
                break;
            }
        }
        return len;
    }    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long s = getFibonacciSumSquaresFast(n);
        System.out.println(s);
    }
}

