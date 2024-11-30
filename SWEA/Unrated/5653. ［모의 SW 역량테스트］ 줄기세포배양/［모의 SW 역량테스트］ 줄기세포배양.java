import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

// 메모리 : 24,920KB / 시간 : 545 ms
public class Solution {
    static int N, M, K;
    static int map[][], tempMap[][], statusMap[][];
    public static void solver() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> tempMap[b[0]][b[1]] - tempMap[a[0]][a[1]]);
        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < N + K; j++) {
                for (int j2 = 0; j2 < M + K; j2++) {
                    if (statusMap[j][j2] == 1) {
                        if(map[j][j2] == i){
                            statusMap[j][j2] = 2;
                            map[j][j2] += tempMap[j][j2];
                        }
                    }
                    else if (statusMap[j][j2] == 2){
                        pq.add(new int[]{j, j2});
                        if(map[j][j2] == i) statusMap[j][j2] = 0;
                    }
                }
            }
            while (!pq.isEmpty()) {
                int[] temp = pq.poll();
                int y = temp[0];
                int x = temp[1];
                
                if (map[y][x + 1] == 0) {
                    tempMap[y][x + 1] = tempMap[y][x];
                    map[y][x + 1] = i + tempMap[y][x + 1];
                    statusMap[y][x + 1] = 1;
                }
                if (map[y][x - 1] == 0) {
                    tempMap[y][x - 1] = tempMap[y][x];
                    map[y][x - 1] = i + tempMap[y][x - 1];
                    statusMap[y][x - 1] = 1;
                }
                if (map[y + 1][x] == 0) {
                    tempMap[y + 1][x] = tempMap[y][x];
                    map[y + 1][x] = i + tempMap[y + 1][x];
                    statusMap[y + 1][x] = 1;
                }
                if (map[y - 1][x] == 0) {
                    tempMap[y - 1][x] = tempMap[y][x];
                    map[y - 1][x] = i + tempMap[y - 1][x];
                    statusMap[y - 1][x] = 1;
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
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N + K][M + K];
            tempMap = new int[N + K][M + K];
            statusMap = new int[N + K][M + K];
            for (int i = K / 2; i < K / 2 + N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = K / 2; j < K / 2 + M; j++) {
                    map[i][j] = tempMap[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] != 0) statusMap[i][j] = 1;
                }
            }
            solver();
            int cnt = 0;
            for (int i = 0; i < N + K; i++) {
                for (int j = 0; j < M + K; j++) {
                    if (statusMap[i][j] >= 1) cnt++; 
                }
            }
            sb.append("#" + testCase + " " + cnt + "\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}