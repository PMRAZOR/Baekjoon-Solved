import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int sol(int A, int B) {
        int cnt = 1;
        while (B > A) {
            if (B % 2 == 0) {
                B /= 2;
            } else if (B % 10 == 1) {
                B /= 10;
            } else {
                return -1;
            }
            cnt++;
        }
        return (B == A) ? cnt : -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        System.out.println(sol(A, B));
    }
}