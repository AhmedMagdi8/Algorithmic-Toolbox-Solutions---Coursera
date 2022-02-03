import java.util.*;
import java.io.*;

public class CarFueling {

    static int computeMinRefills(int dist, int tank, int[] stops)
    {
        int num = 0;
        int current = 0;
        int stp[] = new int[stops.length+2];
        stp[0] = 0;
        stp[stp.length-1] = dist;

        for(int i = 1; i <= stp.length-2; i++){
            stp[i] = stops[i-1];
        }
        int n = stp.length;
        while(current <= n - 2) {
          int lastRefill = current;
          while(current <= n - 2 && stp[current + 1] - stp[lastRefill] <= tank) {
              // System.out.println(stp[current+1]+" - "+ stp[lastRefill]);
            current += 1;
          }
          if(current == lastRefill)
            return -1;
          else
          {
            if(current != stp.length-1)
                num += 1;
          }
        }
        return num;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int dist = scanner.nextInt();
        int tank = scanner.nextInt();
        int n = scanner.nextInt();
        int stops[] = new int[n];
        for (int i = 0; i < n; i++) {
            stops[i] = scanner.nextInt();
        }

        System.out.println(computeMinRefills(dist, tank, stops));
    }
}
