import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] arr;
    static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(arr);
        
        long result = 0;
        for (int i = 0; i < N; i++) {
            long contribution = (arr[i] % MOD) * (modPow(2, i) - modPow(2, N - 1 - i) + MOD) % MOD;
            result = (result + contribution + MOD) % MOD;
        }
        
        System.out.println(result);
    }

    private static long modPow(long base, int exponent) {
        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent /= 2;
        }
        return result;
    }
}