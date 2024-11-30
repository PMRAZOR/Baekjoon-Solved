import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[][] dp;
    public static void dfs(int child, int parent) {
        dp[child][0] = 0;
        dp[child][1] = 1;
        for (int now : tree[child]) {
            if (now != parent) {
                dfs(now, child);
                dp[child][0] += dp[now][1];
                dp[child][1] += Math.min(dp[now][0], dp[now][1]);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }
        StringTokenizer st = null;
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        dp = new int[N + 1][2];
        dfs(1, 0);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
}