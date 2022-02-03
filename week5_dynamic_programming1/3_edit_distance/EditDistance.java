package com.company;

import java.util.*;

class EditDistance {

    static int min(int i, int j, int k) {
        int min = i;
        if(min > j)
            min = j;
        if(min > k)
            min = k;
        return min;
    }
    public static int EditDistance(String s, String t) {
        //write your code here
        int arr[][] = new int[s.length()+1][t.length()+1];
        for(int i = 0; i <= s.length();i++) {
            arr[i][0] = i;
        }
        for(int i = 0; i <= t.length();i++) {
            arr[0][i] = i;
        }
        for(int i = 1; i <= s.length();i++) {
            for(int j = 1; j <= t.length();j++) {
                int match = arr[i-1][j-1];
                int mismatch = arr[i-1][j-1] + 1;
                int insertion = arr[i][j-1] + 1;
                int deletion = arr[i-1][j]+ 1;
                if(s.charAt(i-1) == t.charAt(j-1)) {
                    arr[i][j] = min(match,insertion,deletion);
                } else {
                    arr[i][j] = min(mismatch,insertion,deletion);
                }
            }
        }
//        reconstructSolution(s,t,arr,s.length(),t.length());
//        System.out.println();
        return arr[s.length()][t.length()];

    }
    public static void reconstructSolution(String s, String t,int arr[][] ,int i ,int j) {
        if (i ==0 && j == 0)
            return;
        if( i > 0 && arr[i][j] == arr[i-1][j] + 1) {
            reconstructSolution(s, t, arr, i - 1, j);
            System.out.print(s.charAt(i-1)+"|--   ");
        }
        else if( j > 0 && arr[i][j] == arr[i][j-1] + 1) {
            reconstructSolution(s, t, arr, i, j - 1);
            System.out.print("--|"+t.charAt(j-1)+"  ");

        }
        else {
            reconstructSolution(s, t, arr, i - 1, j - 1);
            System.out.print(s.charAt(i-1)+"|"+t.charAt(j-1)+"  ");
        }
    }
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);

        String s = scan.next();
        String t = scan.next();

        System.out.println(EditDistance(s, t));
    }

}
