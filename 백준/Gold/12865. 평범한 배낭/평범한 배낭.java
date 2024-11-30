import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K;
    static int[][] items;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        items = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            items[i][0] = Integer.parseInt(st.nextToken()); // 무게
            items[i][1] = Integer.parseInt(st.nextToken()); // 가치
        }

        dp = new int[K + 1];
        
        for (int i = 0; i < N; i++) {
            for (int j = K; j >= items[i][0]; j--) {
                dp[j] = Math.max(dp[j], dp[j - items[i][0]] + items[i][1]);
            }
        }

        System.out.println(dp[K]);
    }
}