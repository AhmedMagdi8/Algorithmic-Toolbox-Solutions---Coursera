import java.util.Scanner;

public class ChangeDP {

    private static int getChange(int m) {
        //write your code here
        int minCoins[] =  new int[m+1];
        int coins[] = {1,3,4};
        minCoins[0]=0;
        for(int i = 1; i <= m; i++) {
            minCoins[i] = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++) {
                if(i >= coins[j]) {
                    int min = minCoins[i-coins[j]] + 1;
                    if(min < minCoins[i])
                        minCoins[i] = min;
                }
            }
        }
        return minCoins[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}
