import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        int tcase = 4;
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur == 'C' && tcase == 4) tcase = 3;
            if (cur == 'B' && tcase > 2) tcase = 2;
            if (cur == 'A' && tcase > 1){
                tcase = 1;
                break;
            }
        }
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (tcase == 1 && (cur == 'B' || cur == 'C' || cur == 'D' || cur == 'F')) sb.append('A');
            else if (tcase == 2 && (cur == 'C' || cur == 'D' || cur == 'F')) sb.append('B');
            else if (tcase == 3 && (cur == 'D' || cur == 'F')) sb.append('C');
            else if (tcase == 4) sb.append('A');
            else sb.append(cur);
        }
        System.out.println(sb);
    }
}