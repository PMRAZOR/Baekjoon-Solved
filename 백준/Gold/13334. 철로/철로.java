import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] locations = new int[N][2];
        StringTokenizer st;
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            locations[i] = new int[]{Math.min(first, end), Math.max(first, end)};
        }
        int length = Integer.parseInt(br.readLine());
        
        // Sort locations based on end point, then start point
        Arrays.sort(locations, (a, b) -> a[1] != b[1] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));
        
        PriorityQueue<Integer> startPoints = new PriorityQueue<>();
        int ans = 0;
        
        for (int[] location : locations) {
            int start = location[0];
            int end = location[1];
            
            startPoints.offer(start);
            int lineStart = end - length;
            
            while (!startPoints.isEmpty() && startPoints.peek() < lineStart) {
                startPoints.poll();
            }
            
            ans = Math.max(ans, startPoints.size());
        }
        
        System.out.println(ans);
    }
}