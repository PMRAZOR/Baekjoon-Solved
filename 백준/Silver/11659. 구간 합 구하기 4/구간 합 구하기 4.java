import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 배열 크기
        int M = Integer.parseInt(st.nextToken()); // 트라이 횟수
        
        int[] arr = new int[N + 1];
        st = new StringTokenizer(br.readLine());

        for(int i = 1; i < N + 1; i++){
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
        }

        for(int j = 0; j < M; j++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken());
            System.out.println(arr[end] - arr[start]);
        }
    }
}