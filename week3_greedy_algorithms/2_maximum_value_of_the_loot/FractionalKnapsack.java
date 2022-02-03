import java.util.Scanner;

public class FractionalKnapsack {
    private static double getOptimalValue(int capacity, int[] values, int[] weights) {
        double value = 0;
        float unitValue[] = new float[values.length];
        for( int i = 0; i < values.length; i++) {
            float f = (float)values[i] / weights[i];
            unitValue[i] = f;
        }

        while(capacity > 0) {
            
            int index = 0;
            float max = 0;
            for(int i = 0; i < unitValue.length; i++) {
                if(unitValue[i] > max){
                    max = unitValue[i];
                    index = i;
                }
            }
            if(unitValue[index] == 0)
                return value;
            if(capacity > weights[index]) {
                value += values[index];
                capacity -= weights[index];
            } else {
                value += (capacity * unitValue[index]);
                capacity = 0;
            }
            unitValue[index] = 0;
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int capacity = scanner.nextInt();
        int[] values = new int[n];
        int[] weights = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = scanner.nextInt();
            weights[i] = scanner.nextInt();
        }
        System.out.println(getOptimalValue(capacity, values, weights));
    }
} 
