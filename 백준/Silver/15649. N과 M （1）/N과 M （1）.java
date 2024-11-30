import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.Set;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] used = new boolean[N + 1];
        method(M, N, "", used);
    }

    public static void method(int M, int N, String result, boolean[] used) {
        if (M == 0) {
            System.out.println(result.trim());
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                method(M - 1, N, result + i + " ", used);
                used[i] = false;
            }
        }
    }
}