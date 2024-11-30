import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        Set<String> setN = new HashSet<>();
        for (int i = 0; i < N; i++) {
            setN.add(br.readLine());
        }
        
        List<String> result = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            if (setN.contains(str)) {
                result.add(str);
            }
        }
        
        Collections.sort(result);
        
        System.out.println(result.size());
        for (String s : result) {
            System.out.println(s);
        }
    }
}