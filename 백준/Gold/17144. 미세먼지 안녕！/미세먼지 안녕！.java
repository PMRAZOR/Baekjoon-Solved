import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 메모리 : 14284KB / 시간 : 104ms
public class Main {
    static int R, C, T;
    static int[][] map;

    // 확산
    public static void diffuse(){
        int[][] diffusedDustMap = new int[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] > 0) {
                    int dust = map[i][j];
                    int injup = dust / 5;
                    int injuptime = 0;
    
                    if (i > 0 && map[i-1][j] != -1) {
                        diffusedDustMap[i-1][j] += injup;
                        injuptime++;
                    }
                    if (i < R-1 && map[i+1][j] != -1) {
                        diffusedDustMap[i+1][j] += injup;
                        injuptime++;
                    }
                    if (j > 0 && map[i][j-1] != -1) {
                        diffusedDustMap[i][j-1] += injup;
                        injuptime++;
                    }
                    if (j < C-1 && map[i][j+1] != -1) {
                        diffusedDustMap[i][j+1] += injup;
                        injuptime++;
                    }
    
                    diffusedDustMap[i][j] += dust - (dust / 5) * injuptime;
                }
                
            }
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != -1) {
                    map[i][j] = diffusedDustMap[i][j];
                }
            }
        }
    }

    public static void turnReverseClockwise(int point) {
        int temp = map[point][C - 1];
        for (int i = C - 1; i > 0; i--) {
            map[point][i] = map[point][i - 1];
        }
        for (int i = point - 1; i > 0; i--) {
            map[i][0] = map[i - 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            map[0][i] = map[0][i + 1];
        }
        for (int i = 0; i < point - 1; i++) {
            map[i][C - 1] = map[i + 1][C - 1];
        }
        map[point][1] = 0;
        map[point - 1][C - 1] = temp;
    }

    public static void turnClockwise(int point) {
        int temp = map[point][C - 1];
        for (int i = C - 1; i > 0; i--) {
            map[point][i] = map[point][i - 1];
        }
        for (int i = point + 1; i < R - 1; i++) {
            map[i][0] = map[i + 1][0];
        }
        for (int i = 0; i < C - 1; i++) {
            map[R - 1][i] = map[R - 1][i + 1];
        }
        for (int i = R - 1; i > point + 1; i--) {
            map[i][C - 1] = map[i - 1][C - 1];
        }
        map[point][1] = 0;
        map[point + 1][C - 1] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        int purify1 = 0;
        int purify2 = 0;
        map = new int[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (purify1 == 0 && map[i][j] == -1) purify1 = i;
                else if (purify1 != 0 && map[i][j] == -1) purify2 = i;
            }
        }
        for (int i = 0; i < T; i++) {
            diffuse();
            turnReverseClockwise(purify1);
            turnClockwise(purify2);
        }
        int totalCnt = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if(map[i][j] != 0 && map[i][j] != -1) totalCnt += map[i][j];
            }
        }
        System.out.println(totalCnt);
    }
}