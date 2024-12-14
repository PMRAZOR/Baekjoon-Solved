from collections import deque

dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def solver(x, y, size, N):
    distance = [[0] * N for _ in range(N)]
    visited = [[False] * N for _ in range(N)]
    visited[x][y] = True
    queue = deque()
    queue.append((x, y))
    target_list = []
    while queue:
        x, y = queue.popleft()
        for i in range(4):
            nx = x + dx[i]
            ny = y + dy[i]
            if nx >= 0 and nx < N and ny >= 0 and ny < N:
                if arr[nx][ny] <= size and not visited[nx][ny]:
                    queue.append((nx, ny))
                    visited[nx][ny] = True
                    distance[nx][ny] = distance[x][y] + 1
                    if arr[nx][ny] != 0 and arr[nx][ny] < size:
                        target_list.append((nx, ny, distance[nx][ny]))
    if not target_list:
        return -1, -1, -1
    target_list.sort(key=lambda x: (x[2], x[0], x[1]))
    return target_list[0]


N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

current = (0, 0)
size = 2
cnt = 0
ans = 0

for i in range(N):
    for j in range(N):
        if arr[i][j] == 9:
            current = (i, j)
            break

while True:
    shark = solver(current[0], current[1], size, N)
    if shark[0] == -1:
        break
    ans += shark[2]
    cnt += 1
    if cnt == size:
        size += 1
        cnt = 0
    arr[shark[0]][shark[1]] = 9
    arr[current[0]][current[1]] = 0
    current = (shark[0], shark[1])
print(ans)