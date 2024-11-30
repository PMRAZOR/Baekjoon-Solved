import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int N, M, CCTVNum, total0Cnt;
    static int[] CCTVDirection;
    static List<int[]> CCTVAddr;
    static int[][] arr, copyArr;

    static void CCTV1(int x, int y, int direction){
        if (direction == 1) {
            for (int i = x - 1; i >= 0; i--) {
                if (copyArr[y][i] == 6) break;
                copyArr[y][i] = 9;
            }
        }
        else if (direction == 2) {
            for (int i = y - 1; i >= 0; i--) {
                if (copyArr[i][x] == 6) break;
                copyArr[i][x] = 9;
            }
        }
        else if (direction == 3) {
            for (int i = x + 1; i < M; i++) {
                if (copyArr[y][i] == 6) break;
                copyArr[y][i] = 9;
            }
        }
        else if (direction == 4) {
            for (int i = y + 1; i < N; i++) {
                if (copyArr[i][x] == 6) break;
                copyArr[i][x] = 9;
            }
        }
    }

    static void CCTV2(int x, int y, int direction){
        if (direction == 1) {
            for (int i = x - 1; i >= 0; i--) {
                if (copyArr[y][i] == 6) break;
                copyArr[y][i] = 9;
            }
            for (int i = x + 1; i < M; i++) {
                if (copyArr[y][i] == 6) break;
                copyArr[y][i] = 9;
            }
        }
        else if (direction == 2) {
            for (int i = y - 1; i >= 0; i--) {
                if (copyArr[i][x] == 6) break;
                copyArr[i][x] = 9;
            }
            for (int i = y + 1; i < N; i++) {
                if (copyArr[i][x] == 6) break;
                copyArr[i][x] = 9;
            }
        }
    }

    static void CCTV3(int x, int y, int direction){
        if (direction == 1) {
            for (int i = x - 1; i >= 0; i--) {
                if (copyArr[y][i] == 6) break;
                copyArr[y][i] = 9;
            }
            for (int i = y - 1; i >= 0; i--) {
                if (copyArr[i][x] == 6) break;
                copyArr[i][x] = 9;
            }
        }
        else if (direction == 2) {
            for (int i = y - 1; i >= 0; i--) {
                if (copyArr[i][x] == 6) break;
                copyArr[i][x] = 9;
            }
            for (int i = x + 1; i < M; i++) {
                if (copyArr[y][i] == 6) break;
                copyArr[y][i] = 9;
            }
        }
        else if (direction == 3) {
            for (int i = x + 1; i < M; i++) {
                if (copyArr[y][i] == 6) break;
                copyArr[y][i] = 9;
            }
            for (int i = y + 1; i < N; i++) {
                if (copyArr[i][x] == 6) break;
                copyArr[i][x] = 9;
            }
        }
        else if (direction == 4) {
            for (int i = y + 1; i < N; i++) {
                if (copyArr[i][x] == 6) break;
                copyArr[i][x] = 9;
            }
            for (int i = x - 1; i >= 0; i--) {
                if (copyArr[y][i] == 6) break;
                copyArr[y][i] = 9;
            }
        }
    }

    static void CCTV4(int x, int y, int direction){
        if (direction == 1) {
            for (int i = x - 1; i >= 0; i--) {
                if (copyArr[y][i] == 6) break;
                copyArr[y][i] = 9;
            }
            for (int i = x + 1; i < M; i++) {
                if (copyArr[y][i] == 6) break;
                copyArr[y][i] = 9;
            }
            for (int i = y - 1; i >= 0; i--) {
                if (copyArr[i][x] == 6) break;
                copyArr[i][x] = 9;
            }
        }
        else if (direction == 2) {
            for (int i = y - 1; i >= 0; i--) {
                if (copyArr[i][x] == 6) break;
                copyArr[i][x] = 9;
            }
            for (int i = y + 1; i < N; i++) {
                if (copyArr[i][x] == 6) break;
                copyArr[i][x] = 9;
            }
            for (int i = x + 1; i < M; i++) {
                if (copyArr[y][i] == 6) break;
                copyArr[y][i] = 9;
            }
        }
        else if (direction == 3) {
            for (int i = x - 1; i >= 0; i--) {
                if (copyArr[y][i] == 6) break;
                copyArr[y][i] = 9;
            }
            for (int i = x + 1; i < M; i++) {
                if (copyArr[y][i] == 6) break;
                copyArr[y][i] = 9;
            }
            for (int i = y + 1; i < N; i++) {
                if (copyArr[i][x] == 6) break;
                copyArr[i][x] = 9;
            }
        }
        else if (direction == 4) {
            for (int i = y - 1; i >= 0; i--) {
                if (copyArr[i][x] == 6) break;
                copyArr[i][x] = 9;
            }
            for (int i = y + 1; i < N; i++) {
                if (copyArr[i][x] == 6) break;
                copyArr[i][x] = 9;
            }
            for (int i = x - 1; i >= 0; i--) {
                if (copyArr[y][i] == 6) break;
                copyArr[y][i] = 9;
            }
        }
    }

    static void CCTV5(int x, int y){
        for (int i = x - 1; i >= 0; i--) {
            if (copyArr[y][i] == 6) break;
            copyArr[y][i] = 9;
        }
        for (int i = x + 1; i < M; i++) {
            if (copyArr[y][i] == 6) break;
            copyArr[y][i] = 9;
        }
        for (int i = y - 1; i >= 0; i--) {
            if (copyArr[i][x] == 6) break;
            copyArr[i][x] = 9;
        }
        for (int i = y + 1; i < N; i++) {
            if (copyArr[i][x] == 6) break;
            copyArr[i][x] = 9;
        }
    }

    static void solver(int cnt){
        if (CCTVNum == cnt) {
            // System.out.println(Arrays.toString(CCTVDirection));
            // 결과
            copyArr = new int[N][M];
            for (int i = 0; i < N; i++) {
                System.arraycopy(arr[i], 0, copyArr[i], 0, M);
            }
            for (int i = 0; i < CCTVNum; i++) {
                int[] CCTVPoint = CCTVAddr.get(i);
                int y = CCTVPoint[0];
                int x = CCTVPoint[1];
                // System.out.println(CCTVDirection[i]);
                if (arr[y][x] == 1) CCTV1(x, y, CCTVDirection[i]);
                else if (arr[y][x] == 2) CCTV2(x, y, CCTVDirection[i]);
                else if (arr[y][x] == 3) CCTV3(x, y, CCTVDirection[i]);
                else if (arr[y][x] == 4) CCTV4(x, y, CCTVDirection[i]);
                else if (arr[y][x] == 5) CCTV5(x, y);
            }
            int zeroCnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copyArr[i][j] == 0) zeroCnt++;
                }
            }
            total0Cnt = Math.min(total0Cnt, zeroCnt);
            // System.out.println("==========================");
            return;
        }
        int[] CCTVPoint = CCTVAddr.get(cnt);
        int y = CCTVPoint[0];
        int x = CCTVPoint[1];
        if (arr[y][x] == 1 || arr[y][x] == 3 || arr[y][x] == 4) {
            for(int i = 1; i <= 4; i++){
                CCTVDirection[cnt] = i;
                solver(cnt+1);
            }
        }
        else if (arr[y][x] == 2) {
            for(int i = 1; i <= 2; i++){
                CCTVDirection[cnt] = i;
                solver(cnt+1);
            }
        }
        else if (arr[y][x] == 5) {
            CCTVDirection[cnt] = 1;
            solver(cnt+1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        CCTVAddr = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] != 0 && arr[i][j] != 6) {
                    CCTVAddr.add(new int[]{i, j});
                }
            }
        }
        CCTVNum = CCTVAddr.size();
        // System.out.println(CCTVNum);
        CCTVDirection = new int[CCTVNum];
        total0Cnt = Integer.MAX_VALUE;
        solver(0);
        // for (int i = 0; i < 6; i++) {
        //     System.out.print(CCTVCounter[i] + " ");
        // }
        System.out.println(total0Cnt);
    }
}