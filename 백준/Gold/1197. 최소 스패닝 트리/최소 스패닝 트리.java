import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
    static int V;
    static int[] parents;
    static class Edge implements Comparable<Edge>{
        int start, end, weight;

        public Edge(int start, int end, int weight){
            super();
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.weight, o.weight);
        }
    }
    static void make(){
        parents = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parents[i] = -1;
        }
        // Arrays.fill(parents, -1)
    }

    static int findSet(int a){
        if (parents[a] < 0) return a;
        // 대표자를 자신의 부모로 변경 : 패스 압축
        return parents[a] = findSet(parents[a]);
    }

    static boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if (aRoot == bRoot) return false;
        if (parents[aRoot] > parents[bRoot]) {
            int temp = aRoot;
            aRoot = bRoot;
            bRoot = temp;
        }
        parents[aRoot] += parents[bRoot]; // 집합 크기 관리
        parents[bRoot] = aRoot;
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        Edge[] edges = new Edge[E];
        for(int i = 0; i < E; i++){
            st = new StringTokenizer(br.readLine());
            edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(edges);
        make();
        int cnt = 0;
        int cost = 0;
        for(Edge edge : edges){
            if(union(edge.start, edge.end)){
                cost += edge.weight;
                if(++cnt == V-1) break;
            }
        }
        System.out.println(cost);
    }
}