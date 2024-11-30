import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        
        long[] prefixSum = new long[N + 1];
        int[] count = new int[M];
        long cnt = 0;
        
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = (prefixSum[i-1] + Integer.parseInt(st.nextToken())) % M;
            if (prefixSum[i] == 0) cnt++;
            cnt += count[(int)prefixSum[i]];
            count[(int)prefixSum[i]]++;
        }
        
        System.out.println(cnt);
    }
}