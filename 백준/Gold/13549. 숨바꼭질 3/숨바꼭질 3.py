import heapq

N, K = map(int, input().split())
ans = 0
queue = [(0, N)]
visited = [False for _ in range(999999)]
while queue:
    cnt, now = heapq.heappop(queue)
    if visited[now]:
        continue
    else: visited[now] = True
    if now == K:
        ans = cnt
        break
    if now * 2 <= 200002 and not visited[now * 2]:
        heapq.heappush(queue, (cnt, now * 2))
    if now + 1 <= 200002 and not visited[now + 1]:
        heapq.heappush(queue, (cnt + 1, now + 1))
    if now - 1 >= 0 and not visited[now - 1]:
        heapq.heappush(queue, (cnt + 1,now - 1))

print(ans)