import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    static int[][] arr;
    static int N, M, time, xMan, yMan, boolCnt;
    static boolean[][] visited;

    static void left(int x, int y, Queue<int[]> queue){
        if (x > 0 && arr[y][x - 1] != 0 && arr[y][x - 1] != 2 && arr[y][x - 1] != 6 && arr[y][x - 1] != 7 && !visited[y][x - 1]) {
            visited[y][x - 1] = true;
            boolCnt++;
            queue.offer(new int[]{x - 1, y});
        }
    }
    static void right(int x, int y, Queue<int[]> queue){
        if (x < M - 1 && arr[y][x + 1] != 0 && arr[y][x + 1] != 2 && arr[y][x + 1] != 4 && arr[y][x + 1] != 5 && !visited[y][x + 1]) {
            visited[y][x + 1] = true;
            boolCnt++;
            queue.offer(new int[]{x + 1, y});
        }
    }
    static void up(int x, int y,Queue<int[]> queue){
        if (y > 0 && arr[y - 1][x] != 0 && arr[y - 1][x] != 3 && arr[y - 1][x] != 4 && arr[y - 1][x] != 7 && !visited[y - 1][x]) {
            visited[y - 1][x] = true;
            boolCnt++;
            queue.offer(new int[]{x, y - 1});
        }
    }
    static void down(int x, int y, Queue<int[]> queue){
        if (y < N - 1 && arr[y + 1][x] != 0 && arr[y + 1][x] != 3 && arr[y + 1][x] != 5 && arr[y + 1][x] != 6 && !visited[y + 1][x]) {
            visited[y + 1][x] = true;
            boolCnt++;
            queue.offer(new int[]{x, y + 1});
        }
    }

    // 1. 십자 / 2. I / 3. - / 4. ㄴ / 5. 아래오 / 6. ㄱ / 7. 위왼
    static void bfs(){
        Queue<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{xMan, yMan});
        visited[yMan][xMan] = true;

        int cnt = 1;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int qSize = 0; qSize < size; qSize++) {
                int[] point = queue.poll();
                int xPoint = point[0];
                int yPoint = point[1]; 

                // System.out.println(cnt);

                // System.out.println("=================================================");

                // for (int i = 0; i < N; i++) {
                //     for (int j = 0; j < M; j++) {
                //         System.out.print(visited[i][j] + "\t");
                //     }
                //     System.out.println();
                // }

                if (cnt == time) return;

                if (arr[yPoint][xPoint] == 1) {
                    up(xPoint, yPoint, queue);
                    left(xPoint, yPoint, queue);
                    down(xPoint, yPoint, queue);
                    right(xPoint, yPoint, queue);
                }
                if (arr[yPoint][xPoint] == 2) {
                    up(xPoint, yPoint, queue);
                    down(xPoint, yPoint, queue);
                }
                if (arr[yPoint][xPoint] == 3) {
                    left(xPoint, yPoint, queue);
                    right(xPoint, yPoint, queue);
                }
                if (arr[yPoint][xPoint] == 4) {
                    up(xPoint, yPoint, queue);
                    right(xPoint, yPoint, queue);
                }
                if (arr[yPoint][xPoint] == 5) {
                    down(xPoint, yPoint, queue);
                    right(xPoint, yPoint, queue);
                }
                if (arr[yPoint][xPoint] == 6) {
                    left(xPoint, yPoint, queue);
                    down(xPoint, yPoint, queue);
                }
                if (arr[yPoint][xPoint] == 7) {
                    up(xPoint, yPoint, queue);
                    left(xPoint, yPoint, queue);
                }
            }
            cnt++;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= TC; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            yMan = Integer.parseInt(st.nextToken());
            xMan = Integer.parseInt(st.nextToken());
            time = Integer.parseInt(st.nextToken());
            arr = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            boolCnt = 1;
            visited = new boolean[N][M];
            bfs();
            sb.append("#" + testCase + " " + boolCnt + "\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}