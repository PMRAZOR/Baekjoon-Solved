import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, map[][], white, green;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("./swea/input2.txt"));
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int [N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - 48;
            }
        }
        cut(0, 0, N);
        System.out.println(sb);
    }
    static void cut(int r, int c, int size) {
        // 주어진 공간이 모두 같은색으로 이루어져 있는지 체크
        int sum = 0;
        for (int i = r, rEnd = r + size; i < rEnd; i++) {
            for (int j = c, cEnd = c + size; j < cEnd; j++) {
                sum += map[i][j];
            }
        }
        if (sum == 0) {
            sb.append("0");
        }
        else if (sum == size * size) {
            sb.append("1");
        }
        else{
            int half = size / 2;
            sb.append("(");
            cut(r, c, half);
            cut(r, c + half, half);
            cut(r + half, c, half);
            cut(r + half, c + half, half);
            sb.append(")");
        }
    }
}