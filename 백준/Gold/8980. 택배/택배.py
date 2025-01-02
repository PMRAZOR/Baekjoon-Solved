N, C = map(int, input().split())
M = int(input())
arr = [list(map(int, input().split())) for _ in range(M)]

arr.sort(key=lambda x: x[1])
village = [0 for _ in range(N + 1)]
bag = 0

for i in arr:
    current = i[2]
    for j in range(i[0], i[1]):
        if village[j] + current >= C:
            current = C - village[j]
    for j in range(i[0], i[1]):
        village[j] += current
    bag += current
print(bag)