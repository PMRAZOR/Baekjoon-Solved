N, M = map(int, input().split())
arr = list(map(int, input().split()))
count = 0
for i in range(N):
    temp = arr[i]
    if temp == M:
        count += 1
        continue
    for j in range(i + 1, N):
        temp += arr[j]
        if temp == M:
            count += 1
            break
print(count)