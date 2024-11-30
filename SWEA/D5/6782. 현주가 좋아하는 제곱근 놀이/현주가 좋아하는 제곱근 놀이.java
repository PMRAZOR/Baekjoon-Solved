import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    static long cnt;
    
    static void solver(long N) {
        if (N == 2) {
            return;
        }
        
        long sqrt = (long) Math.sqrt(N);
        
        if (sqrt * sqrt == N) {
            cnt++;
            solver(sqrt);
        }
        else {
            long nextSquare = (sqrt + 1) * (sqrt + 1);
            cnt += nextSquare - N + 1;
            solver(sqrt + 1);
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= TC; testCase++) {
            long N = Long.parseLong(br.readLine());
            cnt = 0;
            solver(N);
            System.out.println("#" + testCase + " " + cnt);
        }
    }
}