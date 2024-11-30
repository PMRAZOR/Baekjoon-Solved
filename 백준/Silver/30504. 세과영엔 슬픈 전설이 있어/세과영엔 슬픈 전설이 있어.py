import heapq

N = int(input())
tar = list(map(int, input().split()))
money = list(map(int, input().split()))

tar_index = [(num, idx) for idx, num in enumerate(tar)]
heapq.heapify(tar_index)
heapq.heapify(money)

result = [0] * N

while tar_index:
    tar_num, tar_idx = heapq.heappop(tar_index)
    money_num = heapq.heappop(money)
    
    if money_num < tar_num:
        print("-1")
        exit()
    
    result[tar_idx] = money_num

print(*result)