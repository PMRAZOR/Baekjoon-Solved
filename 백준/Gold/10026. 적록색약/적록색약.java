import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[][] visited;
    static char[][] arr, arrred;
    static int N;

    // 메모리 : 13424 kb / 실행 시간 : 88 ms
    public static void dfs(int x, int y, char now){
        visited[y][x] = true;
        if (x + 1 < N && arr[y][x + 1] == now && !visited[y][x + 1]) {
            dfs(x + 1, y, now);
        }
        if (x - 1 >= 0 && arr[y][x - 1] == now && !visited[y][x - 1]) {
            dfs(x - 1, y, now);
        }
        if (y + 1 < N && arr[y + 1][x] == now && !visited[y + 1][x]) {
            dfs(x, y + 1, now);
        }
        if (y - 1 >= 0 && arr[y - 1][x] == now && !visited[y - 1][x]) {
            dfs(x, y - 1, now);
        }
    }

    public static void dfsred(int x, int y, char now){
        visited[y][x] = true;
        if (x + 1 < N && arrred[y][x + 1] == now && !visited[y][x + 1]) {
            dfsred(x + 1, y, now);
        }
        if (x - 1 >= 0 && arrred[y][x - 1] == now && !visited[y][x - 1]) {
            dfsred(x - 1, y, now);
        }
        if (y + 1 < N && arrred[y + 1][x] == now && !visited[y + 1][x]) {
            dfsred(x, y + 1, now);
        }
        if (y - 1 >= 0 && arrred[y - 1][x] == now && !visited[y - 1][x]) {
            dfsred(x, y - 1, now);
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("./swea/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        arrred = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'G') {
                    arrred[i][j] = 'R';
                }
                else arrred[i][j] = arr[i][j];
            }
        }
        // for (int i = 0; i < N; i++) {
        //     for (int j = 0; j < N; j++) {
        //         System.out.print(arrred[i][j]);
        //     }
        //     System.out.println();
        // }
        visited = new boolean[N][N];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char now = arr[i][j];
                if (!visited[i][j]){
                    cnt++;
                    dfs(j, i, now);
                }
            }
        }
        System.out.print(cnt + " ");
        visited = new boolean[N][N];
        cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char now = arrred[i][j];
                if (!visited[i][j]){
                    cnt++;
                    dfsred(j, i, now);
                }
            }
        }
        System.out.println(cnt);
    }
}