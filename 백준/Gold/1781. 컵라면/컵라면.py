import heapq

def solver(arr):
    heap = []
    for i in arr:
        heapq.heappush(heap, i[1])
        if i[0] < len(heap):
            heapq.heappop(heap)
    return sum(heap)


N = int(input())
arr = []
for i in range(N):
    arr.append(list(map(int, input().split())))

arr.sort(key=lambda x: x[0])

print(solver(arr))