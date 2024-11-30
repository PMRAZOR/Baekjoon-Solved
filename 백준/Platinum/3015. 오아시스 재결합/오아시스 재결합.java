import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<int[]> stack = new Stack<>();
        long cnt = 0;

        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            int sameCount = 1;

            while (!stack.isEmpty() && stack.peek()[0] <= height) {
                cnt += stack.peek()[1];
                if (stack.peek()[0] == height) {
                    sameCount += stack.peek()[1];
                }
                stack.pop();
            }

            if (!stack.isEmpty()) {
                cnt++;
            }

            stack.push(new int[]{height, sameCount});
        }

        System.out.println(cnt);
    }
}