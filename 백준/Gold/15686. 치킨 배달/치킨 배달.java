import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Solution1
 */
public class Main {
    static List<int[]> list, homeList;
    static int N, M, fresult;
    static int[][] map;

    static int calc(List<int[]> list2){
        int fmin = 0;
        for (int home[] : homeList){
            int xhome = home[1];
            int yhome = home[0];
            int min = Integer.MAX_VALUE;
            for (int temp[] : list2){
                int x = temp[1];
                int y = temp[0];
                // System.out.println(x + " " + y);
                min = Math.min(Math.abs(xhome - x) + Math.abs(yhome - y), min);
            }
            fmin += min;
        }
        return fmin;
    }

    static void combination(List<int[]> visited, int start, int r) {
        if(r == 0) {
            int result = calc(visited);
            fresult = Math.min(result, fresult);
            return;
        } 
    
        for(int i = start; i < list.size(); i++) {
            visited.add(list.get(i));
            combination(visited, i + 1, r - 1);
            visited.remove(visited.size() - 1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        list = new ArrayList<>();
        homeList = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    list.add(new int[]{i, j});
                    map[i][j] = 0;
                }
                if (map[i][j] == 1) homeList.add(new int[]{i, j});
            }
        }
        fresult = Integer.MAX_VALUE;
        combination(new ArrayList<>(), 0, M);
        System.out.println(fresult);
    }
}