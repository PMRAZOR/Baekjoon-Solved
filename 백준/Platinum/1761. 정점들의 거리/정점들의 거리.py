from collections import deque

class Node:
    def __init__(self, value):
        self.value = value
        self.connect = {}

class NodeManager:
    def __init__(self):
        self.nodes = {}
        self.LOG = 20  # log2(100000) < 20
        self.parent = {}
        self.depth = {}
        self.dist = {}  # 루트로부터의 거리
        self.is_preprocessed = False
    
    def create_node(self, value):
        if value not in self.nodes:
            self.nodes[value] = Node(value)
        return self.nodes[value]
    
    def insert_node(self, node1, node2, distance):
        node1_val = self.create_node(node1)
        node2_val = self.create_node(node2)
        # 양방향 연결
        node1_val.connect[node2] = distance
        node2_val.connect[node1] = distance
    
    def preprocess_lca(self, root=1):
        """반복문으로 DFS 구현하여 재귀 에러 방지"""
        if self.is_preprocessed:
            return
        
        # 초기화
        for node in self.nodes:
            self.parent[node] = [-1] * self.LOG
            self.depth[node] = 0
            self.dist[node] = 0
        
        # 반복문으로 DFS 구현
        stack = [(root, -1, 0, 0)]  # (현재노드, 부모, 깊이, 거리)
        visited = set()
        
        while stack:
            node, par, d, distance = stack.pop()
            
            if node in visited:
                continue
            
            visited.add(node)
            self.parent[node][0] = par
            self.depth[node] = d
            self.dist[node] = distance
            
            # 자식 노드들을 스택에 추가 (역순으로 추가하여 올바른 순서 보장)
            children = []
            for next_node, weight in self.nodes[node].connect.items():
                if next_node != par and next_node not in visited:
                    children.append((next_node, node, d + 1, distance + weight))
            
            # 역순으로 스택에 추가
            for child in reversed(children):
                stack.append(child)
        
        # 희소 배열 구성
        for j in range(1, self.LOG):
            for node in self.nodes:
                if self.parent[node][j-1] != -1:
                    parent_node = self.parent[node][j-1]
                    if parent_node in self.parent:
                        self.parent[node][j] = self.parent[parent_node][j-1]
        
        self.is_preprocessed = True
    
    def _dfs(self, node, par, d, distance):
        """DFS로 부모, 깊이, 거리 설정"""
        self.parent[node][0] = par
        self.depth[node] = d
        self.dist[node] = distance
        
        for next_node, weight in self.nodes[node].connect.items():
            if next_node != par:
                self._dfs(next_node, node, d + 1, distance + weight)
    
    def find_lca(self, u, v):
        """두 노드의 최소 공통 조상 찾기"""
        # u가 더 깊도록 설정
        if self.depth[u] < self.depth[v]:
            u, v = v, u
        
        # u를 v와 같은 깊이로 올리기
        diff = self.depth[u] - self.depth[v]
        for i in range(self.LOG):
            if (diff >> i) & 1:
                u = self.parent[u][i]
        
        if u == v:
            return u
        
        # 동시에 올라가며 LCA 찾기
        for i in range(self.LOG - 1, -1, -1):
            if self.parent[u][i] != self.parent[v][i]:
                u = self.parent[u][i]
                v = self.parent[v][i]
        
        return self.parent[u][0]
    
    def search_node_lca(self, start, end):
        """LCA를 이용한 두 노드 간 거리 계산"""
        if start not in self.nodes or end not in self.nodes:
            return -1
        if start == end:
            return 0
        
        # 전처리가 안 되어있으면 실행
        if not self.is_preprocessed:
            self.preprocess_lca()
        
        lca_node = self.find_lca(start, end)
        return self.dist[start] + self.dist[end] - 2 * self.dist[lca_node]
    
    # bfs(타임아웃)
    # def search_node_bfs(self, start, end):
    #     if start not in self.nodes or end not in self.nodes:
    #         return -1
    #     if start == end:
    #         return 0
        
    #     queue = deque([(start, 0)])
    #     visited = set([start])
        
    #     while queue:
    #         current_node, current_distance = queue.popleft()
    #         for connected, node_distance in self.nodes[current_node].connect.items():
    #             if connected == end:
    #                 return current_distance + node_distance
    #             if connected not in visited:
    #                 visited.add(connected)
    #                 queue.append((connected, current_distance + node_distance))
    #     return -1
    
    # dfs(타임아웃)
    # def search_node_dfs(self, start, end):
    #     if start not in self.nodes or end not in self.nodes:
    #         return -1
    #     if start == end:
    #         return 0
        
    #     stack = [(start, 0)]
    #     visited = set()
        
    #     while stack:
    #         current, distance = stack.pop()
    #         if current in visited:
    #             continue
    #         visited.add(current)
    #         if current == end:
    #             return distance
    #         for connected, current_distance in self.nodes[current].connect.items():
    #             if connected not in visited:
    #                 stack.append((connected, distance + current_distance))
    #     return -1

# 코드 start
graph = NodeManager()
N = int(input())
for _ in range(N - 1):
    node1, node2, distance = map(int, input().split())
    graph.insert_node(node1, node2, distance)

M = int(input())
for _ in range(M):
    start, end = map(int, input().split())
    print(graph.search_node_lca(start, end))  # LCA 방법 사용