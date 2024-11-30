import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            int money = Integer.parseInt(br.readLine());
            if (money == 0) break;
            else if (money <= 1000000) System.out.println(money);
            else if (money > 1000000 && money <= 5000000) System.out.printf("%d%n", (int)(money * 0.9));
            else System.out.printf("%d%n", (int)(money * 0.8));
        }
    }
}