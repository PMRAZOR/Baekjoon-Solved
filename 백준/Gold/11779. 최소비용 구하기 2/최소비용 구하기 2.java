import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.util.ArrayList;

// 메모리 : 45232KB / 시간 : 344 ms

public class Main {
    static class Node{
        int vertex, weight;
        Node next;
        public Node(int vertex, int weight, Node next) {
            this.vertex = vertex;
            this.weight = weight;
            this.next = next;
        }
    }
    public static int[] dijkstra(Node[] adjNodes, int start, int end, int[] prev) {
        int V = adjNodes.length;
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(prev, -1);
        dist[start] = 0;

        for (int i = 1; i < V; i++) {
            int min = Integer.MAX_VALUE;
            int stopOver = -1;
            for (int j = 1; j < V; j++) {
                if(!visited[j] && dist[j] < min){
                    min = dist[j];
                    stopOver = j;
                }
            }
            if(stopOver == -1) break;
            visited[stopOver] = true;

            for (Node node = adjNodes[stopOver]; node != null; node = node.next) {
                if(!visited[node.vertex] && dist[node.vertex] > dist[stopOver] + node.weight) {
                    dist[node.vertex] = dist[stopOver] + node.weight;
                    prev[node.vertex] = stopOver;
                }
            }
        }

        return dist;
    }

    public static List<Integer> getPath(int[] prev, int start, int end) {
        List<Integer> path = new ArrayList<>();
        for (int at = end; at != -1; at = prev[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        Node[] adjNodes = new Node[V + 1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjNodes[from] = new Node(to, weight, adjNodes[from]);
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        
        int[] prev = new int[V + 1];
        int[] ans = dijkstra(adjNodes, start, end, prev);
        List<Integer> path = getPath(prev, start, end);

        System.out.println(ans[end]);
        System.out.println(path.size());
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i) + " ");
        }
    }
}