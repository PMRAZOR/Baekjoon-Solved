import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if (str.equals("Es")) ans += num * 21;
            else if (str.equals("Stair")) ans += num * 17;
        }
        System.out.println(ans);
    }
}