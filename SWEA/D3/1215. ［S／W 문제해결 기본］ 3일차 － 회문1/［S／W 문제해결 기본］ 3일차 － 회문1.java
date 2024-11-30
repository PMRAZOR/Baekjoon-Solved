import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for (int TC = 1; TC <= 10; TC++) {
			int line = Integer.parseInt(br.readLine());
			String codeArr[][] = new String[8][8];
			for(int i = 0; i < 8; i++){
				String str = br.readLine();
				String forLine[] = str.split("");
				for(int j = 0; j < 8; j++){
					codeArr[i][j] = forLine[j];
				}
			}
			int halfLine = line / 2;
			int leftLine = line % 2;
			int cnt = 0;
			for(int i = 0; i < 8; i++){
				for(int j = 0; j < 8; j++){
					String lineArr[] = new String[halfLine];
					lineArr[0] = codeArr[i][j];
					if(j + line <= 8){
						int checkCnt = 0;
						for(int k = 1; k < halfLine; k++){
							lineArr[k] = codeArr[i][j + k];
							checkCnt++;
						}
						for(int l = halfLine + leftLine; l < line; l++){
							if(lineArr[checkCnt].equals(codeArr[i][j + l]) && checkCnt == 0){
								cnt++;
							}
							else if(lineArr[checkCnt].equals(codeArr[i][j + l])){
								checkCnt--;
							}
						}
					}
					if(i + line <= 8){
						int checkCnt = 0;
						for(int k = 1; k < halfLine; k++){
							lineArr[k] = codeArr[i + k][j];
							checkCnt++;
						}
						for(int l = halfLine + leftLine; l < line; l++){
							if(lineArr[checkCnt].equals(codeArr[i + l][j]) && checkCnt == 0){
								cnt++;
							}
							else if(lineArr[checkCnt].equals(codeArr[i + l][j])){
								checkCnt--;
							}
						}
					}
				}
			}
			sb.append("#" + TC + " " + cnt + "\n");
		}
		System.out.println(sb);
	}
}