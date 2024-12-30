import sys
sys.setrecursionlimit(10000) 

def dfs(x, y):
    # 탈출식
    if x == N - 1 and y == M - 1:
        return 1
    
    # 이미 방문한 곳 체크
    if visited[y][x] != -1:
        return visited[y][x]
    
    # 방문 인증
    visited[y][x] = 0
    
    # 상하좌우 탐색
    for dx, dy in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
        if 0 <= x + dx < N and 0 <= y + dy < M:
            if arr[y][x] > arr[y + dy][x + dx]:
                visited[y][x] += dfs(x + dx, y + dy)
    
    return visited[y][x]

M, N = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(M)]  # M개의 행
visited = [[-1] * N for _ in range(M)]

print(dfs(0, 0))