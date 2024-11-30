import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int time = 0;
        for (int i = 0; i < N; i++) {
            char cur = str.charAt(i);
            if (cur == 'P') time = 1;
            else if (cur == 'S' && time == 1) time = 2;
            else if ((cur == '4' || cur == '5') && time == 2) continue;
            else time = 0;
            sb.append(cur);
        }
        System.out.println(sb);
    }
}