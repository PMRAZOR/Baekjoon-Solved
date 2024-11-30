import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 메모리 : 17468 KB / 시간 192ms
    static int[][] arr;
    static int cnt, N;
    // 1 = 오른쪽, 2 = 대각선, 3 = 밑으로
    static void solver(int x, int y, int direc) {
        // 끝까지 도달 가능하면 cnt++
        if (x == N - 1 && y == N - 1) {
            cnt++;
            return;
        }
        // 오른쪽
        if ((direc == 1 || direc == 2) && x + 1 < N && arr[y][x + 1] == 0) {
            solver(x + 1, y, 1);
        }
        // 밑으로
        if ((direc == 2 || direc == 3) && y + 1 < N && arr[y + 1][x] == 0) {
            solver(x, y + 1, 3);
        }
        // 대각선
        if (x + 1 < N && y + 1 < N && arr[y][x + 1] == 0 && arr[y + 1][x] == 0 && arr[y + 1][x + 1] == 0) {
            solver(x + 1, y + 1, 2);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        cnt = 0;
        solver(1, 0, 1);
        System.out.println(cnt);
    }
}