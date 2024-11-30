import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 메모리 : 45232KB / 시간 : 344 ms

public class Main {
    static int N, cnt;
    static boolean visited[], visited_up[], visited_down[];
    public static void solver(int point){
        if (point == N) {
            cnt++;
            return;
        }
        for (int i = 0; i < N; i++) {
            if (!visited[i] && !visited_up[i + point] && !visited_down[N - 1 - point + i]) {
                visited[i] = true;
                visited_up[i + point] = true;
                visited_down[N - 1 - point + i] = true;
                solver(point + 1);
                visited[i] = false;
                visited_up[i + point] = false;
                visited_down[N - 1 - point + i] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        visited_up = new boolean[2 * N - 1];
        visited_down = new boolean[2 * N - 1];
        cnt = 0;
        solver(cnt);
        System.out.println(cnt);
    }
}