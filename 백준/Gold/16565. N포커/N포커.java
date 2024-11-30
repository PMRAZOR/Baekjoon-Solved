import java.io.*;

public class Main {
    static final int mod = 10007;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[53][53];
        for (int i = 0; i <= 52; i++) {
            arr[i][0] = 1;
        }
        for (int i = 1; i <= 52; i++) {
            for (int j = 1; j <= 52; j++) {
                arr[i][j] = (arr[i - 1][j] + arr[i - 1][j - 1]) % mod;
            }
        }
        long ans = 0;
        for (int i = 1; i <= 13 && N - 4  * i >= 0; i++) {
            long term = (long) arr[52 - 4 * i][N - 4 * i] * arr[13][i] % mod;
            if (i % 2 == 1) {
                ans = (ans + term) % mod;
            } else {
                ans = (ans - term + mod) % mod;
            }
        }
        
        System.out.println(ans);
    }
}