import java.io.*;
import java.nio.Buffer;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long ans = N;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                ans = ans - (ans / i);
                while (N % i == 0) {
                    N = N / i;
                }
            }
            if (i > (int) Math.sqrt(N)) break;
        }
        if (N > 1) {
            ans = ans - (ans / N);
        }
        System.out.println(ans);
    }
}