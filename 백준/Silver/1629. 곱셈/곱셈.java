import java.io.*;
import java.util.*;

public class Main {
    public static long solver(long A, long B, long C){
        A %= C;
        long result = 1;
        while (B > 0) {
            if (B % 2 == 1) {
                result = (result * A) % C;
            }
            A = (A * A) % C;
            B /= 2;
        }
        return result;
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());
        System.out.println(solver(A, B, C));
    }
}