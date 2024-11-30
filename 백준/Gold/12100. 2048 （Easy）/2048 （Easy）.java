import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr;
    static int max, N;

    public static void solver(int time) {
        if (time == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max = Math.max(max, arr[i][j]);
                }
            }
            return;
        }

        int[][] backup = new int[N][N];
        for (int i = 0; i < N; i++) {
            System.arraycopy(arr[i], 0, backup[i], 0, N);
        }

        for (int i = 0; i < 4; i++) {
            move(i);
            solver(time + 1);
            for (int j = 0; j < N; j++) {
                System.arraycopy(backup[j], 0, arr[j], 0, N);
            }
        }
    }

    public static void move(int direction) {
        // 0 1 2 3 / 위 오 아 왼
        if (direction == 0) {
            for (int j = 0; j < N; j++) {
                int index = 0;
                int prev = 0;
                for (int i = 0; i < N; i++) {
                    if (arr[i][j] != 0) {
                        if (prev == arr[i][j]) {
                            arr[index - 1][j] *= 2;
                            prev = 0;
                        } else {
                            prev = arr[i][j];
                            arr[index++][j] = arr[i][j];
                        }
                    }
                }
                while (index < N) {
                    arr[index++][j] = 0;
                }
            }
        } else if (direction == 1) {
            for (int i = 0; i < N; i++) {
                int index = N - 1;
                int prev = 0;
                for (int j = N - 1; j >= 0; j--) {
                    if (arr[i][j] != 0) {
                        if (prev == arr[i][j]) {
                            arr[i][index + 1] *= 2;
                            prev = 0;
                        } else {
                            prev = arr[i][j];
                            arr[i][index--] = arr[i][j];
                        }
                    }
                }
                while (index >= 0) {
                    arr[i][index--] = 0;
                }
            }
        } else if (direction == 2) {
            for (int j = 0; j < N; j++) {
                int index = N - 1;
                int prev = 0;
                for (int i = N - 1; i >= 0; i--) {
                    if (arr[i][j] != 0) {
                        if (prev == arr[i][j]) {
                            arr[index + 1][j] *= 2;
                            prev = 0;
                        } else {
                            prev = arr[i][j];
                            arr[index--][j] = arr[i][j];
                        }
                    }
                }
                while (index >= 0) {
                    arr[index--][j] = 0;
                }
            }
        } else if (direction == 3) {
            for (int i = 0; i < N; i++) {
                int index = 0;
                int prev = 0;
                for (int j = 0; j < N; j++) {
                    if (arr[i][j] != 0) {
                        if (prev == arr[i][j]) {
                            arr[i][index - 1] *= 2;
                            prev = 0;
                        } else {
                            prev = arr[i][j];
                            arr[i][index++] = arr[i][j];
                        }
                    }
                }
                while (index < N) {
                    arr[i][index++] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        max = 0;
        StringTokenizer st = null;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solver(0);
        System.out.println(max);
    }
}