import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 메모리 : 14368KB / 시간 : 104ms
public class Main {
    static Queue<int[]> W = new ArrayDeque<>();
    static int[] S = new int[]{};
    static int[] D = new int[]{};
    static int R, C, checkTime;
    static char[][] map;
    // 비어있는 곳은 '.'로 표시되어 있고, 물이 차있는 지역은 '*',
    // 돌은 'X'로 표시되어 있다. 비버의 굴은 'D'로,
    // 고슴도치의 위치는 'S'로 나타내어져 있다.
    public static boolean bfs(){
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[R][C];
        queue.add(new int[]{S[0],S[1]}); // 초기위치 큐에 넣기
        visited[S[0]][S[1]] = true;
        checkTime = 0;
        while(!queue.isEmpty()){
            flood();
            int queueSize = queue.size();
            for (int i = 0; i < queueSize; i++) {
                int[] temp = queue.poll();
                int x = temp[1];
                int y = temp[0];

                if(y == D[0] && x == D[1]){
                    // 탈출
                    return true;
                }
                
                if (x > 0 && !visited[y][x - 1] && (map[y][x - 1] == '.' || map[y][x - 1] == 'D')) {
                    visited[y][x - 1] = true;
                    queue.add(new int[]{y, x - 1});
                }

                if (x < C - 1 && !visited[y][x + 1] && (map[y][x + 1] == '.' || map[y][x + 1] == 'D')) {
                    visited[y][x + 1] = true;
                    queue.add(new int[]{y, x + 1});
                }

                if (y > 0 && !visited[y - 1][x] && (map[y - 1][x] == '.' || map[y - 1][x] == 'D')) {
                    visited[y - 1][x] = true;
                    queue.add(new int[]{y - 1, x});
                }

                if (y < R - 1 && !visited[y + 1][x] && (map[y + 1][x] == '.' || map[y + 1][x] == 'D')) {
                    visited[y + 1][x] = true;
                    queue.add(new int[]{y + 1, x});
                }
            }
            checkTime++;
        }
        return false;
    }
    public static void flood(){
        int size = W.size();
        for (int i = 0; i < size; i++) {
            int[] cur = W.poll();
            int y = cur[0];
            int x = cur[1];

            if (x > 0 && map[y][x - 1] == '.') {
                map[y][x - 1] = '*';
                W.add(new int[]{y, x - 1});
            }

            if (x < C - 1 && map[y][x + 1] == '.') {
                map[y][x + 1] = '*';
                W.add(new int[]{y, x + 1});
            }

            if (y > 0 && map[y - 1][x] == '.') {
                map[y - 1][x] = '*';
                W.add(new int[]{y - 1, x});
            }

            if (y < R - 1 && map[y + 1][x] == '.') {
                map[y + 1][x] = '*';
                W.add(new int[]{y + 1, x});
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String tempString = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = tempString.charAt(j);
                if (map[i][j] == 'S') {
                    S = new int[]{i, j};
                } else if (map[i][j] == 'D') {
                    D = new int[]{i, j};
                } else if (map[i][j] == '*') {
                    W.offer(new int[]{i, j});
                }
            }
        }
        // for (int i = 0; i < R; i++) {
        //     for (int j = 0; j < C; j++) {
        //         System.out.print(map[i][j]);
        //     }
        //     System.out.println();
        // }
        boolean result =  bfs();
        System.out.println(result == true ? checkTime : "KAKTUS");
    }
}