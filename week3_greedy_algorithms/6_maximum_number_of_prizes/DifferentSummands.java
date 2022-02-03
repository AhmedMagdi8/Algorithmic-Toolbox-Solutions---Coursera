import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        //write your code here
        if(n == 2) {
            summands.add(2);
            return  summands;
        }
        int curr = 1;
        summands.add(curr);
        n -= curr;
        curr++;
        while(n > 0 ) {
            if(n - curr > curr) {
                summands.add(curr);
                n -= curr;
                curr ++;
            } else {
                summands.add(n);
                n = 0;
            }
        }
        return summands;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}
