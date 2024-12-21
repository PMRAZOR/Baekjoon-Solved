import heapq

N = int(input())
list = []
for _ in range(N):
    heapq.heappush(list, int(input()))

cnt = 0

while len(list) > 1:
    a = heapq.heappop(list)
    b = heapq.heappop(list)
    heapq.heappush(list, a + b)
    cnt += a + b
print(cnt)