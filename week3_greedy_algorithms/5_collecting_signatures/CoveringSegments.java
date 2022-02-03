import java.util.*;

public class CoveringSegments {

    private static int[] optimalPoints(Segment[] segments) {
        //write your code here
        int[] points = new int[2 * segments.length];
        Arrays.sort(segments, new Comparator<Segment>() {
            @Override
            public int compare(Segment s1, Segment s2) {
                return Integer.compare(s1.end, s2.end);
            }

        });
        for(Segment segment : segments) {
            System.out.println(segment.start+"   "+ segment.end);
        }
        int count = 1;
        int p = segments[0].end;
        points[0] = p;
        for(int i = 1; i < segments.length; i++) {
            if(p < segments[i].start) {
                p = segments[i].end;
                points[count] = p;
                count++;
            }
        }

        int[] result = new int[count];
        for(int i = 0; i < count ; i++) {
            result[i] = points[i];
        }




        return result;
    }

    private static class Segment {
        int start, end;

        Segment(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        int[] points = optimalPoints(segments);
        System.out.println(points.length);
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
