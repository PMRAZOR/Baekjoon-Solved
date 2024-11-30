import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String sol(String str, String bomb) {
        StringBuilder sb = new StringBuilder();
        int bombLength = bomb.length();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(i));
            if (sb.length() >= bombLength) {
                boolean boom = true;
                for (int j = 0; j < bombLength; j++) {
                    if (sb.charAt(sb.length() - bombLength + j) != bomb.charAt(j)) {
                        boom = false;
                        break;
                    }
                }
                if (boom) {
                    sb.setLength(sb.length() - bombLength);
                }
            }
        }
        return sb.length() == 0 ? "FRULA" : sb.toString();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();
        
        System.out.println(sol(str, bomb));
    }
}