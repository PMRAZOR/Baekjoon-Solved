from collections import deque

def bfs(queue, arr):
    while queue:
        x, y, z = queue.popleft()
        if 0 <= x < N and 0 <= y < M:
            if x - 1 >= 0 and arr[z][x - 1][y] == 0:
                arr[z][x - 1][y] = arr[z][x][y] + 1
                queue.append((x - 1, y, z))
            if x + 1 < N and arr[z][x + 1][y] == 0:
                arr[z][x + 1][y] = arr[z][x][y] + 1
                queue.append((x + 1, y, z))
            if y - 1 >= 0 and arr[z][x][y - 1] == 0:
                arr[z][x][y - 1] = arr[z][x][y] + 1
                queue.append((x, y - 1, z))
            if y + 1 < M and arr[z][x][y + 1] == 0:
                arr[z][x][y + 1] = arr[z][x][y] + 1
                queue.append((x, y + 1, z))
            if z - 1 >= 0 and arr[z - 1][x][y] == 0:
                arr[z - 1][x][y] = arr[z][x][y] + 1
                queue.append((x, y, z - 1))
            if z + 1 < H and arr[z + 1][x][y] == 0:
                arr[z + 1][x][y] = arr[z][x][y] + 1
                queue.append((x, y, z + 1))

M, N, H = map(int, input().split())
arr = [[list(map(int, input().split())) for _ in range(N)] for _ in range(H)]
queue = deque([])
res = 0
for k in range(H):
    for i in range(N):
        for j in range(M):
            if arr[k][i][j] == 1:
                queue.append((i, j, k))

bfs(queue, arr)

for k in range(H):
    for i in range(N):
        for j in range(M):
            if arr[k][i][j] == 0:
                print(-1)
                exit(0)
            res = max(res, arr[k][i][j])
print(res - 1)