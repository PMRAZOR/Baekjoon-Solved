import java.util.ArrayDeque;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    // 메모리 48220 KB / 시간 292ms
    static int N, M, totalCnt;
    static int[][] arr;
    static boolean[][][] visited;
    static void bfs(){
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][2];
        visited[0][0][0] = true;
        queue.offer(new int[]{0, 0, 0});
        int cnt = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
                int isBroken = point[2];

                if (totalCnt <= cnt) {
                    return;
                }
                
                if (x == M - 1 && y == N - 1) {
                    totalCnt = Math.min(totalCnt, cnt);
                    return;
                }
    
                if (x > 0 && !visited[y][x - 1][isBroken]) {
                    if(arr[y][x - 1] == 0){
                        visited[y][x - 1][isBroken] = true;
                        queue.offer(new int[]{x - 1, y, isBroken});
                    }
                    else if (isBroken == 0){
                        visited[y][x - 1][1] = true;
                        queue.offer(new int[]{x - 1, y, 1});
                    }
                }
                if (x < M - 1 && !visited[y][x + 1][isBroken]) {
                    if (arr[y][x + 1] == 0){
                        visited[y][x + 1][isBroken] = true;
                        queue.offer(new int[]{x + 1, y, isBroken});
                    }
                    else if (isBroken == 0){
                        visited[y][x + 1][1] = true;
                        queue.offer(new int[]{x + 1, y, 1});
                    }
                }
                if (y > 0 && !visited[y - 1][x][isBroken]) {
                    if(arr[y - 1][x] == 0) {
                        visited[y - 1][x][isBroken] = true;
                        queue.offer(new int[]{x, y - 1, isBroken});
                    }
                    else if (isBroken == 0){
                        visited[y - 1][x][1] = true;
                        queue.offer(new int[]{x, y - 1, 1});
                    }
                }
                if (y < N - 1 && !visited[y + 1][x][isBroken]) {
                    if(arr[y + 1][x] == 0) {
                        visited[y + 1][x][isBroken] = true;
                        queue.offer(new int[]{x, y + 1, isBroken});
                    }
                    else if (isBroken == 0){
                        visited[y + 1][x][1] = true;
                        queue.offer(new int[]{x, y + 1, 1});
                    }
                }
            }
            cnt++;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                arr[i][j] = str.charAt(j) - 48;
            }
        }
        totalCnt = Integer.MAX_VALUE;
        bfs();

        // for (int i = 0; i < 6; i++) {
        //     System.out.print(CCTVCounter[i] + " ");
        // }
        System.out.println(totalCnt != Integer.MAX_VALUE ? totalCnt : -1);
    }
}