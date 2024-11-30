import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int bf(int N){
        if (N == 1) return 0;
        int result = bf(N - 1);
        if (N % 2 == 0) result = Math.min(result, bf(N / 2));
        if (N % 3 == 0) result = Math.min(result, bf(N / 3));
        return result + 1;
    }
    static int dp(int N){
        int[] D = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            D[i] = D[i - 1] + 1;
            if (i % 2 == 0) D[i] = Math.min(D[i / 2] + 1, D[i]);
            if (i % 3 == 0) D[i] = Math.min(D[i / 3] + 1, D[i]);
        }
        return D[N];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        // int bf = bf(N);
        int dp = dp(N);
        System.out.println(dp);
    }
}