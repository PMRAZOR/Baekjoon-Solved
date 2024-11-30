import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 메모리 : 12908 kb / 실행 시간 : 72 ms
    static char[][] arr;
    static boolean[] visited;
    static int R, C, max;
    public static void solver(int cnt, int x, int y){
        max = Math.max(max, cnt);

        if (x + 1 < C && !visited[arr[y][x + 1] - 'A']) {
            visited[arr[y][x + 1] - 'A'] = true;
            solver(cnt + 1, x + 1, y);
            visited[arr[y][x + 1] - 'A'] = false;
        }
        if (x - 1 >= 0 && !visited[arr[y][x - 1] - 'A']) {
            visited[arr[y][x - 1] - 'A'] = true;
            solver(cnt + 1, x - 1, y);
            visited[arr[y][x - 1] - 'A'] = false;
        }
        if (y + 1 < R && !visited[arr[y + 1][x] - 'A']) {
            visited[arr[y + 1][x] - 'A'] = true;
            solver(cnt + 1, x, y + 1);
            visited[arr[y + 1][x] - 'A'] = false;
        }
        if (y - 1 >= 0 && !visited[arr[y - 1][x] - 'A']) {
            visited[arr[y - 1][x] - 'A'] = true;
            solver(cnt + 1, x, y - 1);
            visited[arr[y - 1][x] - 'A'] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("./swea/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[R][C];
        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        // for (int i = 0; i < R; i++) {
        //     for (int j = 0; j < C; j++) {
        //         System.out.print(arr[i][j]);
        //     }
        //     System.out.println();
        // }
        visited = new boolean[26];
        visited[arr[0][0] - 'A'] = true;
        solver(1, 0, 0);
        System.out.println(max);
    }
}