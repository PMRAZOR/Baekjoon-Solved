import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.InputStreamReader;
/**
 * d
 */
public class Solution {

	public static void main(String[] args) throws IOException {
		String codeNumArr[] = {"0001101", "0011001", "0010011", "0111101", "0100011", "0110001", "0101111", "0111011", "0110111", "0001011"};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int TC = 1; TC <= 10; TC++) {
			Stack<Integer> resultStack = new Stack<>();
			Stack<Integer> finalStack = new Stack<>();
			resultStack.push(0);
			finalStack.push(0);
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 16
			int M = Integer.parseInt(st.nextToken()); // 80
			int arr[][] = new int[N][M];
			for(int i = 0; i < N; i++){
				String str = br.readLine();
				for(int j = 0; j < M; j++){
					arr[i][j] = str.charAt(j) - 48;
				}
			}
			int backLeft = 0;

			for(int i = 0; i < N; i++){
				int backCnt = 0;
				for(int j = M-1; j > 0; j--){
					if(arr[i][j] == 0){
						backCnt++;
					}
					else if(arr[i][j] == 1){
						backLeft = backCnt;
						break;
					}
				}
			} // backLeft = 뒤에서 1까지 수

			int frontleft = M - backLeft - 56; // ex)4

			int onelineCodes = ((M - frontleft - backLeft) / 7); // 총 7자리 코드의 갯수 ( 뒷자리 제외 ) ex) 56 / 7 = 8

			// System.out.println(M + " " + frontleft + " " + backLeft);
			
			int[][] temp = new int[onelineCodes][7]; // [8][7]
			int cnty = 0;
			int cntx = frontleft; // 0000 | 0111011

			for(int line = 0; line < N; line++){ // 한줄 한줄 표현, 여기서 메인 구현 
				if(cntx < M - backLeft){ //M - back = 60, 4~59 까지 총 56개
					for(int i = 0; i < onelineCodes; i++){ // M-left 한줄 만큼 돌리기 ex_8번
						for(int j = 0; j < 7; j++){ // 7번
							temp[i][j] = arr[cnty][cntx++];
						}
						if(cntx == M - backLeft){
							cntx = frontleft;
							cnty++;
						}
					}
				}
				// System.out.println(line); // 배열 보는 코드
				// for(int i = 0; i < 8; i++){
				// 	for(int j = 0; j < 7; j++){
				// 		System.out.print(temp[i][j]);
				// 	}
				// 	System.out.println("");
				// }
				StringBuilder codesb = new StringBuilder();
				int decimalCode[][] = new int[N][onelineCodes];
				for(int k = 0; k < N; k++){
					for(int i = 0; i < onelineCodes; i++){
						codesb.setLength(0);
						for(int j = 0; j < 7; j++){
							codesb.append(temp[i][j]);
						}
						if(codesb.toString().equals("0000000")){
							continue;
						}
						else{
							decimalCode[k][i] = Arrays.asList(codeNumArr).indexOf(codesb.toString());
							//codesb 인덱스 찾기 구현할 것
						}
					}
				}
				// for(int k = 0; k < N; k++){
				// 	for(int i = 0; i < 8; i++){
				// 		System.out.print(decimalCode[k][i]);
				// 	}
				// 	System.out.println();
				// }
				int result = 0;
				int added = 0;
				for(int k = 0; k < N; k++){
					result = (decimalCode[k][0] + decimalCode[k][2] + decimalCode[k][4] + decimalCode[k][6]) * 3 + decimalCode[k][1] + decimalCode[k][3] + decimalCode[k][5] + decimalCode[k][7];
					added = decimalCode[k][0] + decimalCode[k][2] + decimalCode[k][4] + decimalCode[k][6] + decimalCode[k][1] + decimalCode[k][3] + decimalCode[k][5] + decimalCode[k][7];
					if(result != 0 && resultStack.peek() == 0){
						resultStack.pop();
						resultStack.push(result);
						finalStack.pop();
						finalStack.push(added);
					}
					else if(result != 0 && result != resultStack.peek()){
						resultStack.push(result);
						finalStack.push(added);
					}
				}
			}
			int tcFinalResult = 0;
			for(int i = 0; i < resultStack.size(); i++){
				if(resultStack.peek()%10 == 0){
					tcFinalResult = finalStack.pop();
					break;
				}
			}
			sb.append("#" + TC + " " + tcFinalResult + "\n");
		}
		sb.deleteCharAt(sb.length() - 1);
		System.out.println(sb);
	}
}