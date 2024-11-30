import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 메모리 : 45232KB / 시간 : 344 ms

public class Main {
    static class Node implements Comparable<Node> {
        int vertex, weight;
        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
        @Override
        public int compareTo(Node other) {
            return Integer.compare(this.weight, other.weight);
        }
    }

    public static int[] dijkstra(List<Node>[] adjList, int start, int V) {
        int[] dist = new int[V + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            if (current.weight > dist[u]) continue;

            for (Node neighbor : adjList[u]) {
                int v = neighbor.vertex;
                int weight = neighbor.weight;

                if (dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        List<Node>[] adjList = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList[from].add(new Node(to, weight));
        }

        int[] distances = dijkstra(adjList, start, V);

        for (int i = 1; i <= V; i++) {
            System.out.println(distances[i] != Integer.MAX_VALUE ? distances[i] : "INF");
        }
    }
}