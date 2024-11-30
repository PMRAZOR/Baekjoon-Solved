import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[11];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        for (int i = 0; i < N; i++) {
            int point = Integer.parseInt(br.readLine());
            for (int j = 3; j < point; j++) {
                dp[j] = dp[j-3] + dp[j-2] + dp[j-1];
            }
            sb.append(dp[point - 1]);
            sb.append("\n");
        }
        System.out.println(sb);
    }
}