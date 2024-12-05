import heapq

N, K = map(int, input().split())
arr = []
for i in range(N):
    arr.append(list(map(int, input().split())))
C = [int(input()) for _ in range(K)]

arr.sort(key=lambda x : x[0])
C.sort()
heap = []
cnt = 0
for i in C:
    while arr and arr[0][0] <= i:
        heapq.heappush(heap, -arr[0][1])
        heapq.heappop(arr)
    if heap:
        cnt -= heapq.heappop(heap)
print(cnt)