import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**5)

def DFS(now, parent):
    global id
    id += 1
    visited[now] = ID[now] = id
    cnt = 0
    check = 0
    for next in graph[now]:
        if next == parent:
            continue
        if visited[next]:
            visited[now] = min(visited[now], ID[next])
        else:
            cnt += 1
            DFS(next, now)
            if visited[next] >= ID[now]:
                check = 1
            visited[now] = min(visited[now], visited[next])
    if (parent != 0 and check) or (parent == 0 and cnt > 1):
        point.append(now)

N, M = map(int, input().split())

graph = [[] for _ in range(N+1)]
for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

visited = [0] * (N+1)
ID = [0] * (N+1)
point = []
id = 0

for i in range(1, N+1):
    if not visited[i]:
        DFS(i, 0)

print(len(point))
if point:
    print(*sorted(point))