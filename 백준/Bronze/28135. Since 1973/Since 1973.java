import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (String.valueOf(i).contains("50")) cnt += 2;
            else cnt++;
        }
        if (String.valueOf(N).contains("50")) cnt--;
        System.out.println(cnt);
    }
}