import java.util.*;

public class FibonacciHuge {
    private static long getFibonacciHugeFast(long n, long m) {

        int period_len = pisano_period_len((int)m);
        n = n % period_len;
        
        if (n <= 1)
            return n;
        
        long previous = 0;
        long current  = 1;
        for (long i = 0; i < n-1; ++i) {
            long tmp_previous = previous;
            previous = current;
            current = (tmp_previous + current)% m;
        }

        return current % m;
    }
    static int pisano_period_len(int m) {
        int len=0;
        int prev = 0;
        int cur = 1;
        for(int i = 0; i < m*m; i++) {
            int tmp = prev;
            prev = cur;
            cur = (cur + tmp) % m;
            if(prev ==0 && cur == 1) {
                len = i + 1;
                break;
            }
        }
        return len;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHugeFast(n, m));

    }
}
