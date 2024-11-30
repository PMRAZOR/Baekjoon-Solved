import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Solution1
 */
public class Main {
    static int N, M;
    static ArrayList<ArrayList<Integer>> arr;
    static boolean[] visited;

    static boolean dfs(int start, int depth) {
        if (depth == 4) return true;

        visited[start] = true;
        for (int i : arr.get(start)) {
            if (!visited[i]) {
                if (dfs(i, depth + 1)) return true;
            }
        }
        visited[start] = false;
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            arr.add(new ArrayList<>());
        }
        visited = new boolean[N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        boolean trigger = false;
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            trigger = dfs(i, 0);
            if (trigger) break;
        }
        System.out.println(trigger ? 1 : 0);
    }
}