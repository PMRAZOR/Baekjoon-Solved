import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
public class Solution {
    static int N;
    static int[][] map;
    static int coreSize, maxConnected, minLength;
    static List<int[]> coreAddr; // 코어의 위치 i, j

    static void dfs(int curCore, int connected, int length) {
        // 연결된 코어 + 코어 총 번호 - 현재 코어 번호 가 최대보다 작으면 강종
        if (connected + coreSize - curCore < maxConnected) return;
        // 코어사이즈 도달 시
        if (curCore == coreSize) {
            // 1. 코어 연결 갯수가 많을 시
            if (connected > maxConnected) {
                maxConnected = connected;
                minLength = length;
            }
            // 2. 갯수는 같은데 연결 횟수가 줄어들었을 시
            else if (connected == maxConnected && length < minLength) {
                maxConnected = connected;
                minLength = length;
            }
            // else if (curCore == length) minLength = length;
            // 확인
            return;
        }

        // 현재 뎁스 코어 위치
        int[] corePoint = coreAddr.get(curCore);
        int y = corePoint[0];
        int x = corePoint[1];

        if (y == 0 || y == N - 1 || x == 0 || x == N - 1) {
            dfs(curCore + 1, connected + 1, length);
            return;
        }
        
        dfs(curCore + 1, connected, length);

        // 방향 4개
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirs) {
            // 연결 가능할 시
            if (canConnect(y, x, dir[0], dir[1])) {
                // 와이어 길이 구하기
                int wire = connect(y, x, dir[0], dir[1]);
                // dfs
                dfs(curCore + 1, connected + 1, length + wire);
                // 재귀용 롤백
                rollback(y, x, dir[0], dir[1]);
            }
        }
    }

    static boolean canConnect(int y, int x, int dy, int dx) {
        y += dy;
        x += dx;
        // 패딩 도달 시 까지
        while (y >= 0 && y < N && x >= 0 && x < N) {
            if (map[y][x] != 0) {
                return false;
            }
            y += dy;
            x += dx;
        }
        return true;
    }

    static int connect(int y, int x, int dy, int dx) {
        // 와이어 카운터
        int cnt = 0;
        y += dy;
        x += dx;
        while (y >= 0 && y < N && x >= 0 && x < N) {
            // 와이어 = 2
            map[y][x] = 2;
            y += dy;
            x += dx;
            // 카운터 추가
            cnt++;
        }
        // 전선 길이 (카운터) 리턴
        return cnt;
    }

    static void rollback(int y, int x, int dy, int dx) {
        // 재귀용 배열 롤백
        y += dy;
        x += dx;
        while (y >= 0 && y < N && x >= 0 && x < N) {
            map[y][x] = 0;
            y += dy;
            x += dx;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= TC; testCase++) {
            coreAddr = new ArrayList<>();
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 1) coreAddr.add(new int[]{i, j});
                }
            }
            coreSize = coreAddr.size();
            maxConnected = 0;
            minLength = Integer.MAX_VALUE;

            // 배열 보는 용도
            // for (int i = 0; i < N; i++) {
            //     for (int j = 0; j < N; j++) {
            //         System.out.print(map[i][j] + " ");
            //     }
            //     System.err.println();
            // }

            int edgeConnected = 0;
            for (int[] core : coreAddr) {
                if (core[0] == 0 || core[0] == N-1 || core[1] == 0 || core[1] == N-1) {
                    edgeConnected++;
                }
            }

            dfs(0, edgeConnected, 0);
            sb.append("#" + testCase + " " + minLength + "\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}