import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    // 메모리 : 42,208 kb / 실행 시간 : 339 ms
    static int L, C;
    static char[] arr, forPrint;
    static boolean[] used;
    static int ja, mo;

    public static void solver(int start, int index, int ja, int mo){
        if(start == L){
            if (ja >= 2 && mo >= 1) {
                for (int i = 0; i < L; i++) {
                    System.out.print(forPrint[i]);
                }
                System.out.println();
            }
            return;
        }
        for (int i = index + 1; i < C; i++) {
            forPrint[start] = arr[i];
            if(arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') solver(start + 1, i, ja, mo + 1);
            else solver(start + 1, i, ja + 1, mo);
        }
    }

    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("./swea/input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new char[C];
        forPrint = new char[C];
        used = new boolean[C];
        for (int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        solver(0, -1, 0 , 0);
    }
}