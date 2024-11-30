import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        int[][] arr = new int[N][2];
        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        for (int diagonal = 1; diagonal < N; diagonal++) {
            for (int i = 0; i < N - diagonal; i++) {
                int j = i + diagonal;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i][0] * arr[k][1] * arr[j][1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }
        System.out.println(dp[0][N - 1]);
    }
}