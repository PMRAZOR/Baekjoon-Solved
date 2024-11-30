import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        int first = Integer.parseInt(br.readLine());

        if (N >= 6) {
            System.out.println("Love is open door");
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            first = 1 - first;  // 0을 1로, 1을 0으로 바꾸는 간단한 방법
            System.out.println(first);
        }
    }
}