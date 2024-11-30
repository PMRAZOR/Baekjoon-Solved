import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int N, M;
    static int[] ingriArr;
    static boolean[] forChecking;
    static int[][] stopUsingWith;
    static boolean canGo;
    static int counter;

    public static void Solver(int cnt) {
        if (cnt == N) { // 3까지 도달 할 때
            counter++;
            return;
        }
        // 미선택 배열일 때
        forChecking[cnt] = false;
        Solver(cnt + 1);

        canGo = true;
        for (int i = 0; i < cnt; i++) {
            if (forChecking[i]) {
                for (int j = 0; j < M; j++) {
                    if ((ingriArr[i] == stopUsingWith[j][0] && ingriArr[cnt] == stopUsingWith[j][1]) || (ingriArr[i] == stopUsingWith[j][1] && ingriArr[cnt] == stopUsingWith[j][0])) {
                        canGo = false;
                        break;
                    }
                }
            }
            if(!canGo) break;
        }
        
        if (canGo) {
            // 선택 배열 일 떄
            forChecking[cnt] = true;
            Solver(cnt + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= TC; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken()); // N번 까지의 재료 ex) 3이면 1, 2, 3
            M = Integer.parseInt(st.nextToken()); // 같이 들어가면 안되는 애들 갯수
            ingriArr = new int[N];
            stopUsingWith = new int[M][2];
            forChecking = new boolean[N];
            counter = 0;
            for (int i = 0; i < N; i++) {
                ingriArr[i] = i + 1;
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                stopUsingWith[i][0] = Integer.parseInt(st.nextToken());
                stopUsingWith[i][1] = Integer.parseInt(st.nextToken());
            }
            Solver(0);
            sb.append("#" + testCase + " " + counter + "\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}