import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for(int TC = 1; TC < 11; TC++){
            int N = Integer.parseInt(br.readLine()); // N = 덤프횟수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr1 = new int[100];
            for(int i = 0; i < 100; i++){
                arr1[i] = Integer.parseInt(st.nextToken());
            }

            int ans = 0;
            int max = 0;
            int min = 0;

            for(int j = 0; j <= N; j++){
                int maxArr = 0;
                int minArr = 100;
                int maxInd = 0;
                int minInd = 0;
                for(int l : arr1){
                    maxArr = Math.max(maxArr, l);
                    minArr = Math.min(minArr, l);
                }
                for(int k = 0; k < 100; k++){ //최대
                    if(arr1[k] == maxArr){
                        maxInd = k;
                    }
                    else if(arr1[k] == minArr){ //최소
                        minInd = k;
                    }
                }
                max = arr1[maxInd];
                min = arr1[minInd];
                arr1[maxInd] = maxArr - 1;
                arr1[minInd] = minArr + 1;
            }
            ans = max - min;
            sb.append("#" + TC + " " + ans);
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }
}