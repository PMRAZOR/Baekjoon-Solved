import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    static int N, M, cnt;
    static int[][] maze;
    static void bfs(){
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];

        visited[0][0] = true;
        queue.offer(new int[]{0, 0});
        int cnt = 1;
        int size = 1;

        while (!queue.isEmpty()) {
            size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                
                if (x == M - 1 && y == N - 1) {
                    System.out.println(cnt);
                    return;
                }
    
                if (x > 0 && maze[y][x - 1] == 1 && !visited[y][x - 1]) {
                    visited[y][x - 1] = true;
                    queue.offer(new int[]{x - 1, y});
                }
                if (x < M - 1 && maze[y][x + 1] == 1 && !visited[y][x + 1]) {
                    visited[y][x + 1] = true;
                    queue.offer(new int[]{x + 1, y});
                }
                if (y > 0 && maze[y - 1][x] == 1 && !visited[y - 1][x]) {
                    visited[y - 1][x] = true;
                    queue.offer(new int[]{x, y - 1});
                }
                if (y < N - 1 && maze[y + 1][x] == 1 && !visited[y + 1][x]) {
                    visited[y + 1][x] = true;
                    queue.offer(new int[]{x, y + 1});
                }
            }
            cnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // y
        M = Integer.parseInt(st.nextToken()); // x
        maze = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }
        bfs();
    }
}