import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    // 메모리 : 11472KB / 소요 시간 : 64ms
    static int selectPeople = 2; // 선택할 카드
	static int[] arr; // 카드 담을 배열
    static int resultSave = 0; // 결과 저장할 곳
    static boolean trigger; // 최소 마이너스 저장할 포인터
    static int totalMinus = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int allPeople = 9;
        int maxHat = 0;
        arr = new int[allPeople];

        for(int i = 0; i < allPeople; i++){
            arr[i] = Integer.parseInt(br.readLine()); // 숫자정보 입력
            maxHat += arr[i];
        }
        totalMinus = maxHat - 100;
        // 메소드 호출
        method(0, 0, 0, new boolean[allPeople]); //selectcard = 3
        // 결과 표시
        for(int i = 0; i < allPeople; i++){
            if(arr[i] != 0) System.out.println(arr[i]);
        }
    }
    // cnt = 카운터, start = 시작할 숫자, sum = 최종 합
    public static void method(int cnt, int start, int sum, boolean selected[]) {
        
        if (trigger) return;

        if (cnt == selectPeople) {
            if (sum == totalMinus) {
                for(int i = 0; i < arr.length; i++){
                    if(selected[i]) arr[i] = 0;
                }
                trigger = true;
            }

        }
        //start(0) 부터 N까지 돌리기
        for(int i = start; i < arr.length; i++){
            if(!selected[i]){
                selected[i] = true;
                method(cnt + 1, i + 1, arr[i] + sum, selected);
                selected[i] = false;
            }
        }
    }
}