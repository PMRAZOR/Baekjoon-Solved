import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int vertex, weight;
        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    static int inf = 200000000;
    static ArrayList<ArrayList<Node>> graph;
    static int N;

    public static int dijkstra(int start, int end) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, inf);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int cur = current.vertex;
            
            if (dist[cur] < current.weight) continue;
            
            for (Node next : graph.get(cur)) {
                if (dist[next.vertex] > dist[cur] + next.weight) {
                    dist[next.vertex] = dist[cur] + next.weight;
                    pq.offer(new Node(next.vertex, dist[next.vertex]));
                }
            }
        }

        return dist[end];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c)); // 무방향 그래프
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        // 1 -> v1 -> v2 -> N
        int path1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);
        // 1 -> v2 -> v1 -> N
        int path2 = dijkstra(1, v2) + dijkstra(v2, v1) + dijkstra(v1, N);

        int result = Math.min(path1, path2);
        System.out.println(result >= inf ? -1 : result);
    }
}