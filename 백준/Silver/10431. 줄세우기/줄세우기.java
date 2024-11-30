import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= P; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int cnt = 0;
            int[] arr = new int[20];

            for (int i = 0; i < 20; i++) {
                int current = Integer.parseInt(st.nextToken());
                int j = i - 1;
                while (j >= 0 && arr[j] > current) {
                    arr[j + 1] = arr[j];
                    j--;
                    cnt++;
                }
                arr[j + 1] = current;
            }

            sb.append(T).append(" ").append(cnt).append("\n");
        }

        System.out.print(sb);
    }
}