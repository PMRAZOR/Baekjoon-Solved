import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    // 사용 메모리 : 21,428kb / 사용 시간 : 1,378 ms
    static int N, min; // 재료 갯수, 최대 칼로리 
    static int[] sinArr, cenArr;
    static boolean[] forChecking;
    static boolean trigger;

    public static void Solver(int cnt) {
        if (trigger) return;
        if (cnt == N) { // cnt가 최대 재료 갯수까지 도달 시
            int diff = Integer.MAX_VALUE;
            int sinSum = 1;
            int cenSum = 0;
            for (int i = 0; i < N; i++) {
                // 체킹한 배열일 시 sum에 추가
                if (forChecking[i]) sinSum *= sinArr[i];
                if (forChecking[i]) cenSum += cenArr[i];
            }
            if (sinSum != 1 && cenSum != 0) {
                diff = Math.abs(sinSum - cenSum);
                min = Math.min(min, diff);
                if(min == 0) trigger = true;
            }
            return;
        }
        // 미선택 배열일 때
        forChecking[cnt] = false;
        Solver(cnt + 1);
        // 선택 배열 일 떄
        forChecking[cnt] = true;
        Solver(cnt + 1);
        
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // 재료 갯수
        min = Integer.MAX_VALUE;
        sinArr = new int[N];
        cenArr = new int[N];
        forChecking = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sinArr[i] = Integer.parseInt(st.nextToken());
            cenArr[i] = Integer.parseInt(st.nextToken());
        }
        Solver(0);
        System.out.println(min);
    }
}