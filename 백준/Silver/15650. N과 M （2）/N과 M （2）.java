import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        method(0, 1, N, "");
    }

    public static void method(int cnt, int start, int N, String result) {
        if (cnt == M) {
            System.out.println(result);
            return;
        }

        for (int i = start; i <= N; i++) {
            method(cnt + 1, i + 1, N, result + i + " ");
        }
    }
}