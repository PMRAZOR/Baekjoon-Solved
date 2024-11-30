import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int N, M, loopToTry; // N = y, M = x
    // 메모리 : 32,804 kb, 시간 205 ms

    static void solver1(){
        int tempArr[] = new int[M];
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M; j++) {
                tempArr[j] = arr[i][j];
            }
            for (int k = 0; k < M; k++) {
                arr[i][k] = arr[N - i - 1][k];
                arr[N - i - 1][k] = tempArr[k];
            }
        }
    }

    static void solver2(){
        int tempArr[] = new int[N];
        for (int i = 0; i < M / 2; i++) {
            for (int j = 0; j < N; j++) {
                tempArr[j] = arr[j][i];
            }
            for (int k = 0; k < N; k++) {
                arr[k][i] = arr[k][M - i - 1];
                arr[k][M - i - 1] = tempArr[k];
            }
        }
    }

    static void solver3() {
        int[][] newArr = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newArr[j][N - 1 - i] = arr[i][j];
            }
        }
        arr = newArr;
        M = arr[0].length;
        N = arr.length;
    }

    static void solver4() {
        int[][] newArr = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                newArr[M - 1 - j][i] = arr[i][j];
            }
        }
        arr = newArr;
        M = arr[0].length;
        N = arr.length;
    }

    static void solver5() {
        int tempArr[][] = new int[N / 2][M / 2];
        int offsetN = N / 2;
        int offsetM = M / 2;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                tempArr[i][j] = arr[i][j];
                arr[i][j] = arr[i + offsetN][j];
                arr[i + offsetN][j] = arr[i + offsetN][j + offsetM];
                arr[i + offsetN][j + offsetM] = arr[i][j + offsetM];
                arr[i][j + offsetM] = tempArr[i][j];
            }
        }
    }

    static void solver6() {
        int tempArr[][] = new int[N / 2][M / 2];
        int offsetN = N / 2;
        int offsetM = M / 2;
        for (int i = 0; i < N / 2; i++) {
            for (int j = 0; j < M / 2; j++) {
                tempArr[i][j] = arr[i][j];
                arr[i][j] = arr[i][j + offsetM] ;
                arr[i][j + offsetM] = arr[i + offsetN][j + offsetM];
                arr[i + offsetN][j + offsetM] = arr[i + offsetN][j];
                arr[i + offsetN][j]  = tempArr[i][j];
            }
        }
    }

    static void menu(int R){
        if (R == 1) {
            solver1();
        }
        else if (R == 2) {
            solver2();
        }
        else if (R == 3) {
            solver3();
        }
        else if (R == 4) {
            solver4();
        }
        else if (R == 5) {
            solver5();
        }
        else if (R == 6) {
            solver6();
        }
    }
    
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("./swea/input2.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        loopToTry = Integer.parseInt(st.nextToken());
        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int R = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < loopToTry; i++) {
            R = Integer.parseInt(st.nextToken());
            menu(R);
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}