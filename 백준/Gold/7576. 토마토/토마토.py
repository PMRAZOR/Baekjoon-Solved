from collections import deque

def bfs(queue, arr):
    while queue:
        x, y = queue.popleft()
        if 0 <= x < N and 0 <= y < M:
            if x - 1 >= 0 and arr[x - 1][y] == 0:
                arr[x - 1][y] = arr[x][y] + 1
                queue.append((x - 1, y))
            if x + 1 < N and arr[x + 1][y] == 0:
                arr[x + 1][y] = arr[x][y] + 1
                queue.append((x + 1, y))
            if y - 1 >= 0 and arr[x][y - 1] == 0:
                arr[x][y - 1] = arr[x][y] + 1
                queue.append((x, y - 1))
            if y + 1 < M and arr[x][y + 1] == 0:
                arr[x][y + 1] = arr[x][y] + 1
                queue.append((x, y + 1))

M, N = map(int, input().split())
arr = [list(map(int, input().split())) for _ in range(N)]
queue = deque([])
res = 0
for i in range(N):
    for j in range(M):
        if arr[i][j] == 1:
            queue.append((i, j))

bfs(queue, arr)

for i in range(N):
    for j in range(M):
        if arr[i][j] == 0:
            print(-1)
            exit(0)
        res = max(res, arr[i][j])
print(res - 1)