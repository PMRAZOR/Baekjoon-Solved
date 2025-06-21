N, S = map(int, input().split())

arr = [0 for i in range(N)]

for i in range(N):
    arr[i] = int(input())

cnt = 0

for i in range(N - 1):
    for j in range(i + 1, N):
        if arr[i] + arr[j] <= S:
            # print("case", cnt + 1, ":", i, j)
            cnt += 1

print(cnt)