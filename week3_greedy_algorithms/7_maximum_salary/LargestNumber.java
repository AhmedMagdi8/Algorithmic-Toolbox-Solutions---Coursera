import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        String result = "";
        Arrays.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int i = 0;
                int j = 0;
                while (true) {
                    if(Character.compare(o2.charAt(i), o1.charAt(j)) == 0) {
                        if(i < o2.length() - 1 && j < o1.length() - 1) {
                            j++;
                            i++;
                        } else if(i < o2.length() -1) {
                            i++;
                        } else if (j < o1.length() - 1) {
                            j++;
                        } else {
                            return Character.compare(o2.charAt(i), o1.charAt(j));
                        }
                    } else {
                        return Character.compare(o2.charAt(i), o1.charAt(j));
                    }
                }
                 //To change body of generated methods, choose Tools | Templates.
            }

        });
        for (int i = 0; i < a.length; i++) {
            result += a[i];
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }

        System.out.println(largestNumber(a));
    }
}
