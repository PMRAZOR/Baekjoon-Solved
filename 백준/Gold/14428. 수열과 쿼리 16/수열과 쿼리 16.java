import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr, tree;

    public static void segment(int left, int right, int node) {
        if (left == right) {
            tree[node] = left;  // 인덱스 저장
            return;
        }
        int mid = (left + right) / 2;
        segment(left, mid, node * 2);
        segment(mid + 1, right, node * 2 + 1);
        // 더 작은 값을 가진 인덱스 저장
        if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
            tree[node] = tree[node * 2];
        } else {
            tree[node] = tree[node * 2 + 1];
        }
    }

    public static void update(int left, int right, int node, int index, int value) {
        if (index < left || index > right) {
            return;
        }
        if (left == right) {
            arr[index] = value;
            tree[node] = index;
            return;
        }
        int mid = (left + right) / 2;
        update(left, mid, node * 2, index, value);
        update(mid + 1, right, node * 2 + 1, index, value);
        if (arr[tree[node * 2]] <= arr[tree[node * 2 + 1]]) {
            tree[node] = tree[node * 2];
        } else {
            tree[node] = tree[node * 2 + 1];
        }
    }

    public static int query(int left, int right, int node, int queryLeft, int queryRight) {
        if (queryLeft > right || queryRight < left) {
            return -1;  // 유효하지 않은 인덱스
        }
        if (queryLeft <= left && queryRight >= right) {
            return tree[node];
        }
        int mid = (left + right) / 2;
        int leftResult = query(left, mid, node * 2, queryLeft, queryRight);
        int rightResult = query(mid + 1, right, node * 2 + 1, queryLeft, queryRight);

        if (leftResult == -1) return rightResult;
        if (rightResult == -1) return leftResult;

        return (arr[leftResult] <= arr[rightResult]) ? leftResult : rightResult;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int queryTime = Integer.parseInt(br.readLine());
        int H = (int) Math.ceil(Math.log(N) / Math.log(2));
        int treeSize = (int) Math.pow(2, H + 1);
        tree = new int[treeSize];
        segment(0, N - 1, 1);
        for (int i = 0; i < queryTime; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (a == 1) {
                update(0, N - 1, 1, b - 1, c);
            } else {
                int result = query(0, N - 1, 1, b - 1, c - 1);
                System.out.println(result + 1);  // 1-based 인덱스로 출력
            }
        }
    }
}