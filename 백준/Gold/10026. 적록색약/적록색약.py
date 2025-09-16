from collections import deque

def bfs(arr, x, y, visited):
    queue = deque([])
    queue.append((x, y))
    while queue:
        x, y = queue.popleft()
        now = arr[x][y]
        if 0 <= x < N and 0 <= y < N:
            if x - 1 >= 0 and visited[x - 1][y] == False and arr[x - 1][y] == now:
                visited[x - 1][y] = True
                queue.append((x - 1, y))
            if x + 1 < N and visited[x + 1][y] == False and arr[x + 1][y] == now:
                visited[x + 1][y] = True
                queue.append((x + 1, y))
            if y - 1 >= 0 and visited[x][y - 1] == False and arr[x][y - 1] == now:
                visited[x][y - 1] = True
                queue.append((x, y - 1))
            if y + 1 < N and visited[x][y + 1] == False and arr[x][y + 1] == now:
                visited[x][y + 1] = True
                queue.append((x, y + 1))

N = int(input())
arr1 = [["" for _ in range(N)] for _ in range (N)]
arr2 = [["" for _ in range(N)] for _ in range (N)]
for i in range(N):
    temp = input()
    for j in range(N):
        arr1[i][j] = temp[j]
        if temp[j] == "G":
            arr2[i][j] = "R"
        else: arr2[i][j] = temp[j]

visited1 = [[False for _ in range(N)] for _ in range (N)]
visited2 = [[False for _ in range(N)] for _ in range (N)]

ans1 = 0
ans2 = 0

for i in range(N):
    for j in range(N):
        if visited1[i][j] == True:
            continue
        bfs(arr1, i, j, visited1)
        ans1 += 1

for i in range(N):
    for j in range(N):
        if visited2[i][j] == True:
            continue
        bfs(arr2, i, j, visited2)
        ans2 += 1

print(ans1, ans2)