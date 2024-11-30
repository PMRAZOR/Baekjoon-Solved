import java.util.ArrayDeque;
import java.util.Queue;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    static int N, M, virusCnt, max;
    static int K = 3;
    static int[] resultx = new int[K];
    static int[] resulty = new int[K];
    static int[][] arr;

    private static void combination(int cnt, int startR, int startC) {
		if(cnt == K) {
            Queue<int[]> queue = new ArrayDeque<>();
            int[][] copyArr = new int[N][M];
            
            for (int i = 0; i < N; i++) {
                System.arraycopy(arr[i], 0, copyArr[i], 0, M);
            }
			for (int i = 0; i < K; i++) {
                copyArr[resulty[i]][resultx[i]] = 1;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copyArr[i][j] == 2) {
                        queue.offer(new int[]{j, i});
                    }
                }
            }
            
            while (!queue.isEmpty()) {
                int[] point = queue.poll();
                int x = point[0];
                int y = point[1];
    
                if (x > 0 && copyArr[y][x - 1] == 0) {
                    copyArr[y][x - 1] = 2;
                    queue.offer(new int[]{x - 1, y});
                }
                if (x < M - 1 && copyArr[y][x + 1] == 0) {
                    copyArr[y][x + 1] = 2;
                    queue.offer(new int[]{x + 1, y});
                }
                if (y > 0 && copyArr[y - 1][x] == 0) {
                    copyArr[y - 1][x] = 2;
                    queue.offer(new int[]{x, y - 1});
                }
                if (y < N - 1 && copyArr[y + 1][x] == 0) {
                    copyArr[y + 1][x] = 2;
                    queue.offer(new int[]{x, y + 1});
                }
            }
            
            int zeroCnt = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if(copyArr[i][j] == 0) zeroCnt++;
                }
            }

            // 체크용
            // if (zeroCnt >= 27) {
            //     System.out.println(zeroCnt);
            //     for (int i = 0; i < N; i++) {
            //         for (int j = 0; j < M; j++) {
            //             System.out.print(copyArr[i][j] + " ");
            //         }
            //         System.out.println();
            //     }
            //     System.out.println();
            // }

            max = Math.max(max, zeroCnt);
            return;
		}
		
		//반복파트
		// 요소하나를 뽑고 다음 요소 뽑기는 재귀로 넘김
		for(int i = startR; i < N; i++) {
			for(int j = i==startR? startC : 0; j < M; j++) {
				//요소 뽑기
                if(arr[i][j] == 0){
                    resultx[cnt] = j;
                    resulty[cnt] = i;
                    //다음 요소뽑기는 재귀로 넘김
				    if(j == M - 1) combination(cnt+1, i+1, 0);	//마지막 열인 경우(다음 요소의 좌표)
				    else combination(cnt+1, i, j+1);
                }
			}
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][M];
        virusCnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 2) virusCnt++;
            }
        }
        max = 0;
        combination(0, 0, 0);
        System.out.println(max);
    }
}