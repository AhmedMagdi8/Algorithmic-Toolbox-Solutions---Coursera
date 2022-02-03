import java.util.*;

public class GCD {
    
    private static int fastGCD(int a, int b) {
        if(b == 0)
            return a;
        int a_prime = a % b;
        return fastGCD(b, a_prime);
    }

  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int a = scanner.nextInt();
    int b = scanner.nextInt();

    System.out.println(fastGCD(a, b));
  }
}
