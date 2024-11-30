import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = 10;
        for (int testCase = 1; testCase <= TC; testCase++) {
            int arrnum = Integer.parseInt(br.readLine());
            int[][] maze = new int[100][100];
            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    maze[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            int ans = solver(maze);
            sb.append("#" + arrnum + " " + ans + "\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    public static int solver(int[][] maze) {
        int point = 0;
        for (int j = 0; j < 100; j++) {
            if (maze[99][j] == 2) {
                point = j;
                break;
            }
        }

        int i = 99;
        while (i > 0) {
            if (maze[i][point] == 2) {
                i = i - 1;
            } else if (maze[i][point] == 1) {
                if (point == 99) {
                    if (maze[i][point - 1] == 1) {
                        maze[i][point] = 0;
                        point = point - 1;
                    } else {
                        i = i - 1;
                    }
                } else if (point == 0) {
                    if (maze[i][point + 1] == 1) {
                        maze[i][point] = 0;
                        point = point + 1;
                    } else {
                        i = i - 1;
                    }
                } else if (maze[i][point + 1] == 1) {
                    maze[i][point] = 0;
                    point = point + 1;
                } else if (maze[i][point - 1] == 1) {
                    maze[i][point] = 0;
                    point = point - 1;
                } else {
                    i = i - 1;
                }
            }
        }
        return point;
    }
}