import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map, tempMap;
    static int N, M, cnt, gameTimeCnt;
    static int distance;
    static int maxKill;

    public static int[] shooting(int x) {
        int[] target = null;
        int minDist = Integer.MAX_VALUE;
        for (int i = M - 1; i >= 0; i--) {
            for (int j = 0; j < N; j++) {
                if (tempMap[i][j] == 1) {
                    int dist = (M - i) + Math.abs(x - j);
                    if (dist <= distance && (dist < minDist || (dist == minDist && j < target[1]))) {
                        minDist = dist;
                        target = new int[]{i, j};
                    }
                }
            }
        }
        return target;
    }

    public static void nextGame(){
        for (int i = M - 1; i > 0; i--) {
            for (int j = 0; j < N; j++) {
                tempMap[i][j] = tempMap[i - 1][j];
            }
        }
        for (int i = 0; i < N; i++) {
            tempMap[0][i] = 0;
        }
    }

    public static void simulate(int[] archers) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                tempMap[i][j] = map[i][j];
            }
        }
        cnt = 0;
        for (int i = 0; i < M; i++) {
            int[][] targets = new int[3][];
            for (int j = 0; j < 3; j++) {
                targets[j] = shooting(archers[j]);
            }
            for (int[] target : targets) {
                if (target != null && tempMap[target[0]][target[1]] == 1) {
                    tempMap[target[0]][target[1]] = 0;
                    cnt++;
                }
            }
            nextGame();
        }
        maxKill = Math.max(maxKill, cnt);
    }

    public static void batch(int[] archers, int index, int start) {
        if (index == 3) {
            simulate(archers);
            return;
        }
        for (int i = start; i < N; i++) {
            archers[index] = i;
            batch(archers, index + 1, i + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        distance = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        tempMap = new int[M + 1][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        maxKill = 0;
        gameTimeCnt = Integer.MAX_VALUE;

        batch(new int[3], 0, 0);
        
        System.out.println(maxKill);
    }
}