import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

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
    public static int dijkstra(Node[] adjNodes, int start, int end) {
        // 노드 길이 체크
        int V = adjNodes.length;
        // 각 최소 거리 넣을 배열
        int[] dist = new int[V];
        boolean[] visited = new boolean[V];
        // 최소배열에 최대값 때려넣기
        Arrays.fill(dist, Integer.MAX_VALUE);
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
                if(!visited[node.vertex] && dist[node.vertex] > dist[stopOver] + node.weight) dist[node.vertex] = min + node.weight;
            }
        }

        return dist[end];
    }
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // V == 노드, E == 간선
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());
        StringTokenizer st = null;
        // 입력이 1부터 시작 = V + 1
        Node[] adjNodes = new Node[V + 1];
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            // 시작, 도착, 가중치
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            // 노드 리스트에 노드 추가
            adjNodes[from] = new Node(to, weight, adjNodes[from]);
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        // 노드리스트, 시작, 도착
        System.out.println(dijkstra(adjNodes, start, end));
    }
}