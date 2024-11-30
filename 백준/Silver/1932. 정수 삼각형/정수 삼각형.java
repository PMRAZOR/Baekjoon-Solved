import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = Integer.parseInt(br.readLine());
        List<int[]> arr = new ArrayList<>();
        String line;
        for(int time = 0; time < length; time++) {
            line = br.readLine();
            String[] numbers = line.trim().split("\\s+");
            int[] row = new int[numbers.length];
            for (int i = 0; i < numbers.length; i++) {
                row[i] = Integer.parseInt(numbers[i]);
            }
            arr.add(row);
        }
        int[] dp = arr.get(length - 1);
        for (int i = length - 2; i >= 0; i--) {
            int[] currentRow = arr.get(i);
            for (int j = 0; j <= i; j++) {
                dp[j] = currentRow[j] + Math.max(dp[j], dp[j + 1]);
            }
        }
        int max = 0;
        for (int i = 0; i < dp.length; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}