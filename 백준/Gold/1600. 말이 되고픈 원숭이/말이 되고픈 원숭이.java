import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, min, arr[][];
    static Queue<int[]> queue;
    static boolean[][][] visited;

    static void moveKnight(int x, int y, int knight, int cnt){
        // 1. 4방향 기준점 경계 체크
        // 왼
        if (x > 1 && y > 0 && arr[y - 1][x - 2] == 0 && !visited[y - 1][x - 2][knight - 1]) {
            visited[y - 1][x - 2][knight - 1] = true;
            queue.offer(new int[]{x - 2, y - 1, knight - 1, cnt});
        }
        if (x > 1 && y < N - 1 && arr[y + 1][x - 2] == 0 && !visited[y + 1][x - 2][knight - 1]) {
            visited[y + 1][x - 2][knight - 1] = true;
            queue.offer(new int[]{x - 2, y + 1, knight - 1, cnt});
        }
        // 오
        if (x < M - 2 && y > 0 && arr[y - 1][x + 2] == 0 && !visited[y - 1][x + 2][knight - 1]) {
            visited[y - 1][x + 2][knight - 1] = true;
            queue.offer(new int[]{x + 2, y - 1, knight - 1, cnt});
        }
        if (x < M - 2 && y < N - 1 && arr[y + 1][x + 2] == 0 && !visited[y + 1][x + 2][knight - 1]) {
            visited[y + 1][x + 2][knight - 1] = true;
            queue.offer(new int[]{x + 2, y + 1, knight - 1, cnt});
        }
        // 위
        if (y > 1 && x > 0 && arr[y - 2][x - 1] == 0 && !visited[y - 2][x - 1][knight - 1]) {
            visited[y - 2][x - 1][knight - 1] = true;
            queue.offer(new int[]{x - 1, y - 2, knight - 1, cnt});
        }
        if (y > 1 && x < M - 1 && arr[y - 2][x + 1] == 0 && !visited[y - 2][x + 1][knight - 1]) {
            visited[y - 2][x + 1][knight - 1] = true;
            queue.offer(new int[]{x + 1, y - 2, knight - 1, cnt});
        }
        // 아래
        if (y < N - 2 && x > 0 && arr[y + 2][x - 1] == 0 && !visited[y + 2][x - 1][knight - 1]) {
            visited[y + 2][x - 1][knight - 1] = true;
            queue.offer(new int[]{x - 1, y + 2, knight - 1, cnt});
        }
        if (y < N - 2 && x < M - 1 && arr[y + 2][x + 1] == 0 && !visited[y + 2][x + 1][knight - 1]) {
            visited[y + 2][x + 1][knight - 1] = true;
            queue.offer(new int[]{x + 1, y + 2, knight - 1, cnt});
        }
    }
    static void moveNormal(int x, int y, int knight, int cnt){
        // 위
        if (x > 0 && arr[y][x - 1] == 0 && !visited[y][x - 1][knight]) {
            visited[y][x - 1][knight] = true;
            queue.offer(new int[]{x - 1, y, knight, cnt});
        }
        // 아래
        if (x < M - 1 && arr[y][x + 1] == 0 && !visited[y][x + 1][knight]) {
            visited[y][x + 1][knight] = true;
            queue.offer(new int[]{x + 1, y, knight, cnt});
        }
        // 왼
        if (y > 0 && arr[y - 1][x] == 0 && !visited[y - 1][x][knight]) {
            visited[y - 1][x][knight] = true;
            queue.offer(new int[]{x, y - 1, knight, cnt});
        }
        // 오
        if (y < N - 1 && arr[y + 1][x] == 0 && !visited[y + 1][x][knight]) {
            visited[y + 1][x][knight] = true;
            queue.offer(new int[]{x, y + 1, knight, cnt});
        }
    }

    static int bfs(int x, int y, int knight) {
        queue = new ArrayDeque<>();
        visited = new boolean[N][M][knight + 1];
        queue.offer(new int[]{x, y, knight, 0});
        visited[y][x][knight] = true;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int xPoint = point[0];
            int yPoint = point[1];
            int knightPoint = point[2];
            int cntPoint = point[3];
            if (xPoint == M - 1 && yPoint == N - 1) return cntPoint;
            if (knightPoint > 0) moveKnight(xPoint, yPoint, knightPoint, cntPoint + 1);
            moveNormal(xPoint, yPoint, knightPoint, cntPoint + 1);
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // M = x
        N = Integer.parseInt(st.nextToken()); // N = y
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = bfs(0, 0, K);
        System.out.println(result);
    }
}