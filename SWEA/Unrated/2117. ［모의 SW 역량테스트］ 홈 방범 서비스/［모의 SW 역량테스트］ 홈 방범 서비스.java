import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Solution1
 */
public class Solution {
    static int cnt;
    static int[][] arr;
    static int N, M;
    static void solver(int y, int x, int K) {
        cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Math.abs(i - y) + Math.abs(j - x) < K) {
                    cnt += arr[i][j];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= TC; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // 배열크기
            M = Integer.parseInt(st.nextToken()); // 집당 지불 비용
            arr = new int[N][N]; // 배열 크기를 N x N으로 변경

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int max = 0;
            for (int k = 1; k <= N + 1; k++) {
                int cost = k * k + (k - 1) * (k - 1);
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++) {
                        solver(i, j, k);
                        if (cnt * M >= cost) {
                            max = Math.max(max, cnt);
                        }
                    }
                }
            }
            System.out.println("#" + testCase + " " + max);
        }
    }
}