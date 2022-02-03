import java.util.Scanner;

public class Fibonacci {
  private static long calc_fib(int n) {
    if (n <= 1)
      return n;
        int prev = 0;
        int cur  = 1;
        for (int i = 0; i < n - 1; ++i) {
            int tmp = prev;
            prev = cur;
            cur = tmp + cur;
        }
    return cur;

  }

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(calc_fib(n));
  }
}
