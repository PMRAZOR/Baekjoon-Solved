import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String pattern, text;
    static int checkCnt;
    static int[] pi;
    static StringBuilder sbpattern = new StringBuilder();
    public static void getPi(){
        // j = 접두사, i 접미사
        int j = 0;
        for(int i = 1; i < pattern.length(); i++){
            // 처음 접두사가 아니면서 일치하지 않으면, 반복되는 패턴의 앞부분으로 변경
            // 만약 반복되는 패턴이 없으면, j = 0까지 돌아갈거임
            while(j > 0 && pattern.charAt(i) != pattern.charAt(j)){
                j = pi[j-1];
            }
            // 일치할때, 접두사의 길이(경계) 저장
            // 현재 맞은 idx의 +1은 길이이자, 다음 체크할 idx가 됨
            if(pattern.charAt(i) == pattern.charAt(j)){
                pi[i] = ++j;
            }
        }
    }
    public static void kmp(){
        // 체크 인덱스
        int j = 0;
        // 텍스트 길이동안
		for (int i = 0; i < text.length(); i++) {
            // 글자 다르면 j를 0으로 만들고 넘기기
			while(j > 0 && text.charAt(i) != pattern.charAt(j)) {
				j = pi[j - 1];
			}
			// 글자가 서로 맞는 경우
			if(text.charAt(i) == pattern.charAt(j)) {
                // 인덱스 j 가 패턴길이에 도달 시
				if(j == pattern.length() - 1) {
                    checkCnt++;
                    sbpattern.append(i - j + 1).append(" ");
                    j = pi[j];
				}
                // 도달 안했으면 +1 하고 다음꺼 비교
                else {
                    j++;
                }
			}
		}
	}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        text = br.readLine();
        pattern = br.readLine();
        if (text == null || pattern == null || text.isEmpty() || pattern.isEmpty()) {
            System.out.println(0);
            System.out.println();
            return;
        }
        pi = new int[pattern.length()];
        checkCnt = 0;
        getPi();
        kmp();
        System.out.println(checkCnt);
        System.out.println(sbpattern.toString().trim());
    }
}