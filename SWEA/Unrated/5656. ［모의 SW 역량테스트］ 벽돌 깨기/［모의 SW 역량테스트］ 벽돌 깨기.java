import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 메모리 : 23008KB / 시간 : 132ms
public class Solution {
    static int[][] map, tempMap;
    static int[] arr, output;
    static int H, W, N, min;
    public static void letsBreak(int x, int y) {
        if (y < 0 || y >= H || x < 0 || x >= W || tempMap[y][x] == 0) return;
        
        int power = tempMap[y][x];
        tempMap[y][x] = 0;
        
        for (int i = 1; i < power; i++) {
            letsBreak(x - i, y);
            letsBreak(x + i, y);
            letsBreak(x, y - i);
            letsBreak(x, y + i);
        }
    }
    
    public static void loop(int depth) {
        if (depth == N) {
            // 배열 복사
            for (int i = 0; i < H; i++) {
                System.arraycopy(map[i], 0, tempMap[i], 0, W);
            }
            
            for (int i = 0; i < N; i++) {
                int x = output[i];
                int y = 0;
                while (y < H && tempMap[y][x] == 0) y++;
                if (y < H) {
                    letsBreak(x, y);
                    dropBricks();
                }
            }
            
            int remainBricks = countRemainingBricks();
            min = Math.min(remainBricks, min);
            return;
        }
    
        for (int i = 0; i < W; i++) {
            output[depth] = i;
            loop(depth + 1);
        }
    }
    public static int countRemainingBricks() {
        int count = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (tempMap[i][j] != 0) count++;
            }
        }
        return count;
    }
    
    public static void dropBricks() {
        for (int x = 0; x < W; x++) {
            int index = H - 1;
            for (int y = H - 1; y >= 0; y--) {
                if (tempMap[y][x] != 0) {
                    tempMap[index][x] = tempMap[y][x];
                    if (index != y) {
                        tempMap[y][x] = 0;
                    }
                    index--;
                }
            }
        }
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= TC; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            output = new int[N];
            map = new int[H][W];
            tempMap = new int[H][W];
            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            arr = new int[W];
            for (int i = 0; i < W; i++) {
                arr[i] = i;
            }
            min = Integer.MAX_VALUE;  // 각 테스트 케이스마다 min 초기화
            loop(0);
            sb.append("#" + testCase + " " + min + "\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}