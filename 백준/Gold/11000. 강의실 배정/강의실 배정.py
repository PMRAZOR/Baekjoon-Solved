import heapq

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]
arr.sort(key=lambda x: (x[0], x[1]))

room = []
heapq.heappush(room, 0)

for temp in arr:
    if temp[0] >= room[0]:
        heapq.heappop(room)
    heapq.heappush(room, temp[1])
print(len(room))