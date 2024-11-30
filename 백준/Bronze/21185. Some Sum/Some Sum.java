import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        if (N % 4 == 0) {
            System.out.println("Even");
        } else if (N % 2 == 0) {
            System.out.println("Odd");
        } else {
            System.out.println("Either");
        }
    }
}