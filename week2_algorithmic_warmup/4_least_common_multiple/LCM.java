import java.util.*;

public class LCM {
  private static long lcm_fast(int a, int b) {


    return (long) a * b / gcd(a, b);
  }
  private static long gcd(int a, int b) {
      if(b == 0)
          return a;
      int a_prime = a % b;
      return gcd(b, a_prime);
  }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(lcm_fast(a, b));
  }
}
