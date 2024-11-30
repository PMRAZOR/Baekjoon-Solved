import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class Solution
{
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = null;
        for(int TC = 1; TC <= 10; TC++){ // N = 건물갯수
            int N = Integer.parseInt(br.readLine());
            int[] arr1 = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                arr1[i] = Integer.parseInt(st.nextToken());
            }
            int leftMax = 0;
            int rightMax = 0;
            int totalMax = 0;
            int ans = 0;
            for(int j = 2; j < N - 2; j++){
                leftMax = Math.max(arr1[j-1], arr1[j-2]);
                rightMax = Math.max(arr1[j+1], arr1[j+2]);
                totalMax = Math.max(leftMax, rightMax);
                if (arr1[j] > totalMax) {
                    ans += arr1[j] - totalMax;
                }
            }
        sb.append("#" + TC + " " + ans);
        sb.append("\n");
        }
    sb.deleteCharAt(sb.length() - 1);
    System.out.println(sb);
	}
}