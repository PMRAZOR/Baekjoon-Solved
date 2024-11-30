import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, X, map[][];

    public static boolean ansRow(int R){
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            int diff = map[R][i] - map[R][i + 1];

            if(Math.abs(diff) >= 2) return false;

            if(diff == 1){
                for (int j = i + 1; j <= i + X; j++) {
                    if(j >= N || visited[j] || map[R][j] != map[R][i + 1]) return false;
                    visited[j] = true;
                }
            }
            else if(diff == -1){
                for (int j = i; j > i - X; j--) {
                    if(j < 0 || visited[j] || map[R][j] != map[R][i]) return false;
                    visited[j] = true;
                }
            }
        }
        return true;
    }

    public static boolean ansCol(int C){
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            int diff = map[i][C] - map[i + 1][C];

            if(Math.abs(diff) >= 2) return false;

            if(diff == 1){
                for (int j = i + 1; j <= i + X; j++) {
                    if(j >= N || visited[j] || map[j][C] != map[i + 1][C]) return false;
                    visited[j] = true;
                }
            }
            else if(diff == -1){
                for (int j = i; j > i - X; j--) {
                    if(j < 0 || visited[j] || map[j][C] != map[i][C]) return false;
                    visited[j] = true;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= TC; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                if(ansCol(i)) cnt++;
                if(ansRow(i)) cnt++;
            }
            sb.append("#" + testCase + " " + cnt + "\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}