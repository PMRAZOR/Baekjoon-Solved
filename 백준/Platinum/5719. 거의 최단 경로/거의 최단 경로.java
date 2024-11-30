import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int to, weight;
        Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static ArrayList<Edge>[] graph, reverseGraph;
    static int N, M, S, D;
    static final int INF = 1_000_000_000;

    public static int[] dijkstra(int s, boolean[][] avoid) {
        int[] dist = new int[N];
        Arrays.fill(dist, INF);
        dist[s] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(s, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            if (dist[cur.to] < cur.weight) continue;

            for (Edge next : graph[cur.to]) {
                if (avoid != null && avoid[cur.to][next.to]) continue;
                int newDist = dist[cur.to] + next.weight;
                if (newDist < dist[next.to]) {
                    dist[next.to] = newDist;
                    pq.offer(new Edge(next.to, newDist));
                }
            }
        }
        return dist;
    }

    public static void markShortestPaths(int[] dist, boolean[][] isShortestPath) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(D);

        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == S) continue;

            for (Edge prev : reverseGraph[cur]) {
                if (dist[cur] == dist[prev.to] + prev.weight) {
                    if (!isShortestPath[prev.to][cur]) {
                        isShortestPath[prev.to][cur] = true;
                        q.offer(prev.to);
                    }
                }
            }
        }
    }

    public static int findAlmostShortestPath() {
        int[] dist = dijkstra(S, null);
        if (dist[D] == INF) return -1;

        boolean[][] isShortestPath = new boolean[N][N];
        markShortestPaths(dist, isShortestPath);

        int[] almostShortest = dijkstra(S, isShortestPath);
        return almostShortest[D] == INF ? -1 : almostShortest[D];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String line;
        while (!(line = br.readLine()).equals("0 0")) {
            StringTokenizer st = new StringTokenizer(line);
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            graph = new ArrayList[N];
            reverseGraph = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<>();
                reverseGraph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine());
            S = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());
                graph[u].add(new Edge(v, p));
                reverseGraph[v].add(new Edge(u, p));
            }

            bw.write(findAlmostShortestPath() + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}