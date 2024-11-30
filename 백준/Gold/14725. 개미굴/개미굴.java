import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import org.w3c.dom.Node;

public class Main {
    public static class Node {
        Map<String, Node> child = new HashMap<>();
        public Node(){
            this.child = new HashMap<>();
        }
    }
    public static class trie {
        static Node root;
        public trie() {
            root = new Node();
        }
        public void insert(String str) {
            Node node = root;
            String[] words = str.split(" ");
            for (String s : words) {
                node.child.putIfAbsent(s, new Node());
                node = node.child.get(s);
            }
        }
        public static void print(Node cur, int depth) {
            Node node = cur;
            if (node.child != null) {
                List<String> list = new ArrayList<>(node.child.keySet());
                Collections.sort(list);
                for (String s : list) {
                    for (int i = 0; i < depth; i++) {
                        System.out.print("--");
                    }
                    System.out.println(s);
                    print(node.child.get(s), depth + 1);
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        trie trie = new trie();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < K; j++) {
                sb.append(st.nextToken() + " ");
                trie.insert(sb.toString());
            }
        }
        trie.print(trie.root, 0);
    }
    
}