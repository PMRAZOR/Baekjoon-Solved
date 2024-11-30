import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Solution1
 */
public class Solution {
    static char arr[];
    static String passwordArr[];
    static int N, K;
    // N / 4가 하나의 코드갯수, 그만큼 스트링 빌더로 코드 만들고 배열에 넣기
    static void solver(int start) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N / 4; i++) {
            sb.append(arr[(start + i) % N]);
        }
        passwordArr[start] = sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        for (int testCase = 1; testCase <= TC; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            arr = br.readLine().toCharArray();
            passwordArr = new String[N];
            // N번만큼 배열 돌리기
            for (int i = 0; i < N; i++) {
                solver(i);
            }

            // 해시셋 어레이 생성
            HashSet<String> Passwords = new HashSet<>(Arrays.asList(passwordArr));
            String[] sortedPasswords = Passwords.toArray(new String[0]);
            // 내림차순 정렬(구글 뒤져봤던거)
            Arrays.sort(sortedPasswords, (a, b) -> b.compareTo(a));

            // K번째로 큰 수 찾기
            String resultNum = sortedPasswords[K - 1];
            int result = Integer.parseInt(resultNum, 16);

            System.out.println("#" + testCase + " " + result);
        }
    }
}