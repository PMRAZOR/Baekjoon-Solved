import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < N; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp == 0) {
                if (pq.isEmpty()) {
                    sb.append(0);
                    sb.append("\n");
                }
                else {
                    sb.append(pq.poll() + "\n");
                }
            } else {
                pq.add(temp);
            }
        }
        System.out.println(sb);
    }
}