import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[A];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < A; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, int[]> pairSums = new HashMap<>();
        
        for (int i = 0; i < A; i++) {
            for (int j = i + 1; j < A; j++) {
                int sum = arr[i] + arr[j];
                if (!pairSums.containsKey(sum)) {
                    pairSums.put(sum, new int[]{i, j});
                }
            }
        }

        for (int i = 0; i < A; i++) {
            for (int j = i + 1; j < A; j++) {
                int remainingSum = W - (arr[i] + arr[j]);
                if (pairSums.containsKey(remainingSum)) {
                    int[] pair = pairSums.get(remainingSum);
                    if (pair[0] != i && pair[0] != j && pair[1] != i && pair[1] != j) {
                        System.out.println("YES");
                        return;
                    }
                }
            }
        }

        System.out.println("NO");
    }
}