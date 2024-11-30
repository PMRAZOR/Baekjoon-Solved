import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;	//arr의 크기(요소의 개수
	static int M;	//목표값
    static int selectCard;
	static int[] arr;
    static int added = 0;
    static int resultSave = 0;
    static int minusPointer = -999;
    static int maxSum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 요소 갯수 N
        M = Integer.parseInt(st.nextToken()); // 목표값 M
        st = new StringTokenizer(br.readLine());
        selectCard = 3;
        arr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken()); // 숫자정보 입력
        }

        method(0, 0, 0); //selectcard = 3
        System.out.println(maxSum);
    }
    public static void method(int cnt, int start, int sum) {
        if (cnt == selectCard) {
            if (sum <= M && sum > maxSum) {
                maxSum = sum;
            }
            return;
        }
        for(int i = start; i < N; i++){
            method(cnt + 1, i + 1, sum + arr[i]);
        }
    }
}