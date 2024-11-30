import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true){
            String str = br.readLine();
            if (str.equals("0 W 0")) break;
            StringTokenizer st = new StringTokenizer(str);
            int N = Integer.parseInt(st.nextToken());
            String WD = st.nextToken();
            int M = Integer.parseInt(st.nextToken());
            if (N - M < -200 && WD.equals("W")) System.out.println("Not allowed");
            else if (WD.equals("W")) System.out.println(N - M);
            else System.out.println(N + M);
        }
    }
}