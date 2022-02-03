// import java.util.*;
// import java.io.*;
//
// public class CarFueling {
//
//     static int computeMinRefills(int dist, int tank, int[] stops)
//     {
//         int num = 0;
//         int current = 0;
//         int n = stops.length;
//         boolean breakk = false;
//         while(current <=  n-2) {
//             int lastRefill = current;
//             while(current <= n -2) {
//                 if (stops[current+1] - stops[lastRefill] <= tank)
//                     current++;
//                 else {
//                     breakk=true;
//                     break;
//                 }
//             }
//             if(current == lastRefill) {
//                 return -1;
//             }
//             if(breakk && current <= n-1) {
//                 num++;
//                 breakk = false;
//             }
//         }
//         return num;
//     }
//
//
//     public static void main(String[] args) {
//         Scanner scanner = new Scanner(System.in);
//         int dist = scanner.nextInt();
//         int tank = scanner.nextInt();
//         int n = scanner.nextInt();
//         int stops[] = new int[n];
//         for (int i = 0; i < n; i++) {
//             stops[i] = scanner.nextInt();
//         }
//
//         System.out.println(computeMinRefills(dist, tank, stops));
//     }
// }
