import java.util.*;

public class FibonacciPartialSum {
    private static long getFibonacciPartialSumFast(long from, long to) 
    {
        int p = pisano_period_len();
        to = to % p;
        from = from % p;
        
        if (to <= 1)
            return to;        
        
        if(from > to) {
            long tmp = from;
            from = to;
            to = tmp;
        }
//        if(from == 16 && to == 32)
//            return 6;
//        System.out.println(from +" "+to);
        
        long sum = 0;
        long current = 0;
        long next  = 1;

        for (long i = 0; i <= to; ++i) {
            if (i >= from) {
                sum += current;
            }
            long new_current = next;
            next = (next + current)%10;
            current = new_current;
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
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long from = scanner.nextLong();
        long to = scanner.nextLong();
        System.out.println(getFibonacciPartialSumFast(from, to));
    }
}


