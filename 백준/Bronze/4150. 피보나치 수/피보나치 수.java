import java.io.*;
import java.math.BigInteger;

public class Main {
    public static BigInteger fivo(int n) {
        if (n <= 2) {
            return BigInteger.ONE;
        }
        
        BigInteger[] dp = new BigInteger[n + 1];
        dp[1] = BigInteger.ONE;
        dp[2] = BigInteger.ONE;
        
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1].add(dp[i-2]);
        }
        
        return dp[n];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        BigInteger ans = fivo(N);
        System.out.println(ans);
    }
}