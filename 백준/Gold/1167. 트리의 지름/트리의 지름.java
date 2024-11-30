import java.io.*;
import java.util.*;

public class Main {
    static int V;
    static Node[] adjList;
    static class Node {
        int to, dist;
        Node next;
        public Node(int to, int dist, Node next) {
            this.to = to;
            this.dist = dist;
            this.next = next;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        adjList = new Node[V + 1];
        StringTokenizer st = null;
        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                adjList[from] = new Node(to, dist, adjList[from]);
                adjList[to] = new Node(from, dist, adjList[to]);
            }
        }
        
        int[] result = dfs(1, new boolean[V + 1], 0);
        int nextNode = result[0];
        result = dfs(nextNode, new boolean[V + 1], 0);
        System.out.println(result[1]);
    }

    private static int[] dfs(int cur, boolean[] visited, int distance) {
        visited[cur] = true;
        int[] result = {cur, distance};
        for (Node temp = adjList[cur]; temp != null; temp = temp.next) {
            if (!visited[temp.to]) {
                int[] subResult = dfs(temp.to, visited, distance + temp.dist);
                if (subResult[1] > result[1]) {
                    result = subResult;
                }
            }
        }
        return result;
    }
}