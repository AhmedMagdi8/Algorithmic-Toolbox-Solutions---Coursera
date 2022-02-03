import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class PointsAndSegments {

    private static int[] fastCountSegments(ArrayList<int[]> segments, int[] points) {
        int s = segments.size();
        int p = points.length;
        ArrayList<int[]> pts = new ArrayList<>();
        ArrayList<int[]> segs = new ArrayList<>();

        for(int  i = 0; i < p ; i++) {
            pts.add(new int[]{points[i], i});
        }
        for(int i = 0; i < s ; i++) {
            segs.add(new int[] {segments.get(i)[0],1});
            segs.add(new int[] {segments.get(i)[1] +1 ,-1});
        }
        Collections.sort(segs, (a, b) -> b[0] - a[0]);
        Collections.sort(pts, (a, b) -> a[0] - b[0]);

        int count = 0;
        int[] ans = new int[p];
        for(int i = 0; i < p;i++) {
            int x = pts.get(i)[0];
            while(segs.size() != 0 && segs.get(segs.size() - 1)[0] <= x) {
                count += segs.get(segs.size()-1)[1];
                segs.remove(segs.size()-1);
            }
            ans[pts.get(i)[1]] = count;
        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n, m;
        n = scanner.nextInt();
        m = scanner.nextInt();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int[] points = new int[m];
        ArrayList<int[]> segments = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            starts[i] = scanner.nextInt();
            ends [i] = scanner.nextInt();
            segments.add(new int[]{starts[i],ends[i]});
        }

        for (int i = 0; i < m; i++) {
            points[i] = scanner.nextInt();
        }
        //use fastCountSegments
        int[] cnt = fastCountSegments(segments, points);
        for (int x : cnt) {
            System.out.print(x + " ");
        }
    }
}
