import java.io.*;
import java.util.*;

public class Main {
    public static class Node {
        char ch;
        HashMap<Character, Node> child;
        boolean isEnd;
        public Node(char ch){
            this.ch = ch;
            this.child = new HashMap<>();
            this.isEnd = false;
        }
    }

    public static class trie {
        static Node root;
        public trie() {
            root = new Node('\0');
        }

        public void insert(String word) {
            Node node = root;
            for(char ch : word.toCharArray()) {
                if(!node.child.containsKey(ch)) {
                    node.child.put(ch, new Node(ch));
                }
                node = node.child.get(ch);
            }
            node.isEnd = true;
        }

        public static int search(String word) {
            Node node = root;
            int count = 0;
            for(char ch : word.toCharArray()) {
                node = node.child.get(ch);
                if(node.child.size() > 1 || node.isEnd) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            try {
                int N = Integer.parseInt(br.readLine());
                String[] arr = new String[N];
                trie trie = new trie();
                for (int i = 0; i < N; i++) {
                    String temp = br.readLine();
                    trie.insert(temp);
                    arr[i] = temp;
                }
                double result = 0;
                for (int i = 0; i < N; i++) {
                    result += trie.search(arr[i]);
                }
                System.out.printf("%.2f%n", result / N);
            } catch (Exception e) {
                break;
            }
        }
    }
}