import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            int temp = Integer.parseInt(br.readLine());
            ans += temp;
            arr[i] = temp;
        }
        Arrays.sort(arr);
        System.out.println(ans / 5);
        System.out.println(arr[2]);
    }
}